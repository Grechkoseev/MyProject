package net.thumbtack.school.misc.v2;

import net.thumbtack.school.figures.v2.Point;
import net.thumbtack.school.iface.v2.Colored;

public class ColoredTriangle extends Triangle implements Colored {

    private int color;

    public ColoredTriangle(Point firstPoint, Point secondPoint, Point thirdPoint, int color) {
        super(firstPoint, secondPoint, thirdPoint);
        this.color = color;
    }

    public ColoredTriangle(int xFirst, int yFirst, int xSecond, int ySecond, int xThird, int yThird, int color) {
        this(new Point(xFirst, yFirst), new Point(xSecond, ySecond), new Point(xThird, yThird), color);
    }

    public ColoredTriangle(Point secondPoint, Point thirdPoint, int color) {
        this(new Point(0, 0), secondPoint, thirdPoint, color);
    }

    public ColoredTriangle(Point thirdPoint, int color) {
        this(new Point(0, 0), new Point(1, 1), thirdPoint, color);
    }

    public ColoredTriangle(int color) {
        this(new Point(0, 0), new Point(0, 1), new Point(1, 0), color);
    }

    public ColoredTriangle() {
        this(new Point(0, 0), new Point(0, 1), new Point(1, 0), 1);
    }

    @Override
    public void setColor(int color) {
        this.color = color;
    }

    @Override
    public int getColor() {
        return color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        ColoredTriangle that = (ColoredTriangle) o;

        return color == that.color;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + color;
        return result;
    }
}
