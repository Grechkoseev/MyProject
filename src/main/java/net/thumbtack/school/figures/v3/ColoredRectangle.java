package net.thumbtack.school.figures.v3;

import net.thumbtack.school.colors.v3.Color;
import net.thumbtack.school.colors.v3.ColorException;
import net.thumbtack.school.iface.v3.Colored;

import static net.thumbtack.school.colors.v3.Color.checkColor;

public class ColoredRectangle extends Rectangle implements Colored {

    private Color color;

    public ColoredRectangle(Point leftTop, Point rightBottom, Color color) throws ColorException {
        super(leftTop, rightBottom);
        checkColor(color);
        this.color = color;
    }

    public ColoredRectangle(Point leftTop, Point rightBottom, String color) throws ColorException {
        this(leftTop, rightBottom, Color.colorFromString(color));
    }

    public ColoredRectangle(int xLeft, int yTop, int xRight, int yBottom, Color color) throws ColorException {
        this(new Point(xLeft, yTop), new Point(xRight, yBottom), color);
    }

    public ColoredRectangle(int xLeft, int yTop, int xRight, int yBottom, String color) throws ColorException {
        this(new Point(xLeft, yTop), new Point(xRight, yBottom), Color.colorFromString(color));
    }

    public ColoredRectangle(int length, int width, Color color) throws ColorException {
        this(new Point(0, -width), new Point(length, 0), color);
    }

    public ColoredRectangle(int length, int width, String color) throws ColorException {
        this(new Point(0, -width), new Point(length, 0), Color.colorFromString(color));
    }

    public ColoredRectangle(Color color) throws ColorException {
        this(new Point(0, -1), new Point(1, 0), color);
    }

    public ColoredRectangle(String color) throws ColorException {
        this(new Point(0, -1), new Point(1, 0), Color.colorFromString(color));
    }

    public ColoredRectangle() throws ColorException {
        this(new Point(0, -1), new Point(1, 0), Color.RED);
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void setColor(Color color) throws ColorException {
        checkColor(color);
        this.color = color;
    }

    @Override
    public void setColor(String color) throws ColorException {
        this.color = Color.colorFromString(color);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        ColoredRectangle that = (ColoredRectangle) o;

        return color == that.color;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (color != null ? color.hashCode() : 0);
        return result;
    }
}
