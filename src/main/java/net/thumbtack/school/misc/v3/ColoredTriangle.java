package net.thumbtack.school.misc.v3;

import net.thumbtack.school.colors.v3.Color;
import net.thumbtack.school.colors.v3.ColorException;
import net.thumbtack.school.figures.v3.Point;
import net.thumbtack.school.iface.v3.Colored;

import static net.thumbtack.school.colors.v3.Color.checkColor;

public class ColoredTriangle extends Triangle implements Colored {

    private Color color;

    public ColoredTriangle(Point firstPoint, Point secondPoint, Point thirdPoint, Color color) throws ColorException {
        super(firstPoint, secondPoint, thirdPoint);
        checkColor(color);
        this.color = color;
    }

    public ColoredTriangle(int xFirst, int yFirst, int xSecond, int ySecond, int xThird, int yThird, Color color) throws ColorException {
        this(new Point(xFirst, yFirst), new Point(xSecond, ySecond), new Point(xThird, yThird), color);
    }

    public ColoredTriangle(Point secondPoint, Point thirdPoint, Color color) throws ColorException {
        this(new Point(0, 0), secondPoint, thirdPoint, color);
    }

    public ColoredTriangle(Point thirdPoint, Color color) throws ColorException {
        this(new Point(0, 0), new Point(1, 1), thirdPoint, color);
    }

    public ColoredTriangle(Color color) throws ColorException {
        this(new Point(0, 0), new Point(0, 1), new Point(1, 0), color);
    }

    public ColoredTriangle() throws ColorException {
        this(new Point(0, 0), new Point(0, 1), new Point(1, 0), Color.RED);
    }

    @Override
    public void setColor(Color color) throws ColorException {
        checkColor(color);
        this.color = color;
    }

    @Override
    public Color getColor() {
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
        result = 31 * result + (color != null ? color.hashCode() : 0);
        return result;
    }
}
