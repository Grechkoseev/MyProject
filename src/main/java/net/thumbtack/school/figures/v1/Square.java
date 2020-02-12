package net.thumbtack.school.figures.v1;

import java.util.Objects;

public class Square {

    private Point leftTop;
    private int size;

    public Square(Point leftTop, int size) {
        this.leftTop = leftTop;
        this.size = size;
    }

    public Square(int xLeft, int yTop, int size) {
        this(new Point(xLeft, yTop), size);
    }

    public Square(int size) {
        this(new Point(0, -size), size);
    }

    public Square() {
        this(new Point(0, -1), 1);
    }

    public Point getTopLeft() {
        return leftTop;
    }

    public Point getBottomRight() {
        return new Point(leftTop.getX() + size, leftTop.getY() + size);
    }

    public void setTopLeft(Point topLeft) {
        leftTop = topLeft;
    }

    public int getLength() {
        return size;
    }

    public void moveTo(int x, int y) {
        leftTop.moveTo(x, y);
    }

    public void moveTo(Point point) {
        moveTo(point.getX(), point.getY());
    }

    public void moveRel(int dx, int dy) {
        leftTop.moveRel(dx, dy);
    }

    public void resize(double ratio) {
        size *= ratio;
    }

    public double getArea() {
        return size * size;
    }

    public double getPerimeter() {
        return size * 4;
    }

    public boolean isInside(int x, int y) {
        return getBottomRight().getX() >= x && leftTop.getX() <= x && getBottomRight().getY() >= y && leftTop.getY() <= y;
    }

    public boolean isInside(Point point) {
        return isInside(point.getX(), point.getY());
    }

    public boolean isIntersects(Square square) {
        return isInside(square.getTopLeft()) || isInside(square.getBottomRight()) || square.isInside(leftTop) ||
                square.isInside(new Point(leftTop.getX() + size, leftTop.getY() + size));
    }

    public boolean isInside(Square square) {
        return isInside(square.getTopLeft()) && isInside(square.getBottomRight());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Square square = (Square) o;

        if (size != square.size) return false;
        return Objects.equals(leftTop, square.leftTop);
    }

    @Override
    public int hashCode() {
        int result = leftTop != null ? leftTop.hashCode() : 0;
        result = 31 * result + size;
        return result;
    }
}