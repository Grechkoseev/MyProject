package net.thumbtack.school.figures.v3;

import net.thumbtack.school.iface.v2.Stretchable;

import java.util.Objects;

public class Rectangle extends Figure implements Stretchable {

    private Point leftTop, rightBottom;

    public Rectangle(Point leftTop, Point rightBottom) {
        this.leftTop = leftTop;
        this.rightBottom = rightBottom;
    }

    public Rectangle(int xLeft, int yTop, int xRight, int yBottom) {
        this(new Point(xLeft, yTop), new Point(xRight, yBottom));
    }

    public Rectangle(int length, int width) {
        this(new Point(0, -width), new Point(length, 0));
    }

    public Rectangle() {
        this(new Point(0, -1), new Point(1, 0));
    }

    public Point getTopLeft() {
        return leftTop;
    }

    public Point getBottomRight() {
        return rightBottom;
    }

    public void setTopLeft(Point topLeft) {
        leftTop = topLeft;
    }

    public void setBottomRight(Point bottomRight) {
        rightBottom = bottomRight;
    }

    public int getLength() {
        return rightBottom.getX() - leftTop.getX();
    }

    public int getWidth() {
        return rightBottom.getY() - leftTop.getY();
    }

    public void moveTo(int x, int y) {
        rightBottom.moveTo(x + getLength(), y + getWidth());
        leftTop.moveTo(x, y);
    }

    public void moveRel(int dx, int dy) {
        rightBottom.moveRel(dx, dy);
        leftTop.moveRel(dx, dy);
    }

    public void resize(double ratio) {
        rightBottom.moveTo((int) (getLength() * ratio) + leftTop.getX(), (int) (getWidth() * ratio) + leftTop.getY());
    }

    public void stretch(double xRatio, double yRatio) {
        rightBottom.moveTo(leftTop.getX() + (int) (getLength() * xRatio), leftTop.getY() + (int) (getWidth() * yRatio));
    }

    public double getArea() {
        return getLength() * getWidth();
    }

    public double getPerimeter() {
        return (getLength() + getWidth()) * 2;
    }

    public boolean isInside(int x, int y) {
        return rightBottom.getX() >= x && leftTop.getX() <= x && rightBottom.getY() >= y && leftTop.getY() <= y;
    }

    public boolean isIntersects(Rectangle rectangle) {
        return isInside(rectangle.getTopLeft()) || isInside(rectangle.getBottomRight()) ||
                rectangle.isInside(leftTop) || rectangle.isInside(rightBottom);
    }

    public boolean isInside(Rectangle rectangle) {
        return isInside(rectangle.getTopLeft()) && isInside(rectangle.getBottomRight());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rectangle rectangle = (Rectangle) o;

        if (!Objects.equals(leftTop, rectangle.leftTop)) return false;
        return Objects.equals(rightBottom, rectangle.rightBottom);
    }

    @Override
    public int hashCode() {
        int result = leftTop != null ? leftTop.hashCode() : 0;
        result = 31 * result + (rightBottom != null ? rightBottom.hashCode() : 0);
        return result;
    }
}

