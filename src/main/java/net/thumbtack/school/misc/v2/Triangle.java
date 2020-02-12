package net.thumbtack.school.misc.v2;

import net.thumbtack.school.figures.v2.Figure;
import net.thumbtack.school.figures.v2.Point;
import net.thumbtack.school.iface.v2.HasArea;
import net.thumbtack.school.iface.v2.Movable;
import net.thumbtack.school.iface.v2.Resizable;

import java.util.Objects;

public class Triangle extends Figure implements Movable, HasArea, Resizable {

    private Point firstPoint, secondPoint, thirdPoint;

    public Triangle(Point firstPoint, Point secondPoint, Point thirdPoint) {
        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;
        this.thirdPoint = thirdPoint;
    }

    public Triangle(int xFirst, int yFirst, int xSecond, int ySecond, int xThird, int yThird) {
        this(new Point(xFirst, yFirst), new Point(xSecond, ySecond), new Point(xThird, yThird));
    }

    public Triangle(Point secondPoint, Point thirdPoint) {
        this(new Point(0, 0), secondPoint, thirdPoint);
    }

    public Triangle(Point thirdPoint) {
        this(new Point(0, 0), new Point(1, 1), thirdPoint);
    }

    public Triangle() {
        this(new Point(0, 0), new Point(0, 1), new Point(1, 0));
    }

    public Point getFirstPoint() {
        return firstPoint;
    }

    public void setFirstPoint(Point firstPoint) {
        this.firstPoint = firstPoint;
    }

    public Point getSecondPoint() {
        return secondPoint;
    }

    public void setSecondPoint(Point secondPoint) {
        this.secondPoint = secondPoint;
    }

    public Point getThirdPoint() {
        return thirdPoint;
    }

    public void setThirdPoint(Point thirdPoint) {
        this.thirdPoint = thirdPoint;
    }

    @Override
    public void moveTo(int x, int y) {
        thirdPoint.moveTo(thirdPoint.getX() + x - firstPoint.getX(), thirdPoint.getY() + y - firstPoint.getY());
        secondPoint.moveTo(secondPoint.getX() + x - firstPoint.getX(), secondPoint.getY() + y - firstPoint.getY());
        firstPoint.moveTo(x, y);
    }

    @Override
    public void moveRel(int dx, int dy) {
        firstPoint.moveRel(dx, dy);
        secondPoint.moveRel(dx, dy);
        thirdPoint.moveRel(dx, dy);
    }

    @Override
    public double getArea() {
        return 0.5 * Math.abs((secondPoint.getX() - firstPoint.getX()) * (thirdPoint.getY() - firstPoint.getY()) -
                (thirdPoint.getX() - firstPoint.getX()) * (secondPoint.getY() - firstPoint.getY()));
    }

    @Override
    public double getPerimeter() {
        LineSegment firstSide = new LineSegment(firstPoint, secondPoint);
        LineSegment secondSide = new LineSegment(firstPoint, thirdPoint);
        LineSegment thirdSide = new LineSegment(secondPoint, thirdPoint);
        return firstSide.getLength() + secondSide.getLength() + thirdSide.getLength();
    }

    @Override
    public void resize(double ratio) {
        LineSegment firstSide = new LineSegment(firstPoint, secondPoint);
        LineSegment secondSide = new LineSegment(firstPoint, thirdPoint);
        firstSide.resize(ratio);
        secondSide.resize(ratio);
    }

    @Override
    public boolean isInside(int x, int y) {
        int side1 = (firstPoint.getX() - x) * (secondPoint.getY() - firstPoint.getY()) - (secondPoint.getX() -
                firstPoint.getX()) * (firstPoint.getY() - y);
        int side2 = (secondPoint.getX() - x) * (thirdPoint.getY() - secondPoint.getY()) - (thirdPoint.getX() -
                secondPoint.getX()) * (secondPoint.getY() - y);
        int side3 = (thirdPoint.getX() - x) * (firstPoint.getY() - thirdPoint.getY()) - (firstPoint.getX() -
                thirdPoint.getX()) * (thirdPoint.getY() - y);
        return side1 >= 0 && side2 >= 0 && side3 >= 0 || side1 <= 0 && side2 <= 0 && side3 <= 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Triangle triangle = (Triangle) o;

        if (!Objects.equals(firstPoint, triangle.firstPoint)) return false;
        if (!Objects.equals(secondPoint, triangle.secondPoint))
            return false;
        return Objects.equals(thirdPoint, triangle.thirdPoint);
    }

    @Override
    public int hashCode() {
        int result = firstPoint != null ? firstPoint.hashCode() : 0;
        result = 31 * result + (secondPoint != null ? secondPoint.hashCode() : 0);
        result = 31 * result + (thirdPoint != null ? thirdPoint.hashCode() : 0);
        return result;
    }
}
