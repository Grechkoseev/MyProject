package net.thumbtack.school.misc.v3;

import net.thumbtack.school.figures.v3.Point;
import net.thumbtack.school.iface.v3.Movable;
import net.thumbtack.school.iface.v3.Stretchable;

import java.util.Objects;

public class LineSegment implements Movable, Stretchable {

    private Point first, second;

    public LineSegment(Point first, Point second) {
        this.first = first;
        this.second = second;
    }

    public LineSegment(int xFirst, int yFirst, int xSecond, int ySecond) {
        this(new Point(xFirst, yFirst), new Point(xSecond, ySecond));
    }

    public LineSegment(Point point) {
        this(new Point(0, 0), point);
    }

    public LineSegment() {
        this(new Point(0, 0), new Point(1, 1));
    }

    public Point getFirstPoint() {
        return first;
    }

    public Point getSecondPoint() {
        return second;
    }

    public void setFirstPoint(Point firstPoint) {
        first = firstPoint;
    }

    public void setSecondPoint(Point secondPoint) {
        second = secondPoint;
    }

    @Override
    public void moveTo(int x, int y) {
        second.moveTo(second.getX() + x - first.getX(), second.getY() + y - first.getY());
        first.moveTo(x, y);
    }

    @Override
    public void moveRel(int dx, int dy) {
        first.moveRel(dx, dy);
        second.moveRel(dx, dy);
    }

    @Override
    public void stretch(double xRatio, double yRatio) {
        second.moveTo(first.getX() + (int) ((second.getX() - first.getX()) * xRatio), first.getY() +
                (int) ((second.getY() - first.getY()) * yRatio));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LineSegment that = (LineSegment) o;

        if (!Objects.equals(first, that.first)) return false;
        return Objects.equals(second, that.second);
    }

    @Override
    public int hashCode() {
        int result = first != null ? first.hashCode() : 0;
        result = 31 * result + (second != null ? second.hashCode() : 0);
        return result;
    }

    @Override
    public void resize(double ratio) {
        second.moveTo((int) ((second.getX() - first.getX()) * ratio) + first.getX(), (int) ((second.getY()
                - first.getY()) * ratio) + first.getY());
    }

    public double getLength() {
        return Math.sqrt(Math.pow(second.getX() - first.getX(), 2) + Math.pow(second.getY() - first.getY(), 2));
    }

    public boolean isInside(Point point) {
        return (point.getX() - first.getX()) / (second.getX() - first.getX()) == (point.getY() - first.getY()) /
                (second.getY() - first.getY()) && (point.getX() >= first.getX() && point.getX() <= second.getX() ||
                point.getX() <= first.getX() && point.getX() >= second.getX());
    }

}
