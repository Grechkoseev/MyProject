package net.thumbtack.school.figures.v3;

import net.thumbtack.school.colors.v3.Color;
import net.thumbtack.school.colors.v3.ColorException;
import net.thumbtack.school.iface.v3.Colored;

import static net.thumbtack.school.colors.v3.Color.checkColor;

public class ColoredCircle extends Circle implements Colored {

    private Color color;

    public ColoredCircle(Point center, int radius, Color color) throws ColorException {
        super(center, radius);
        checkColor(color);
        this.color = color;
    }

    public ColoredCircle(Point center, int radius, String color) throws ColorException {
        this(center, radius, Color.colorFromString(color));
    }

    public ColoredCircle(int xCenter, int yCenter, int radius, Color color) throws ColorException {
        this(new Point(xCenter, yCenter), radius, color);
    }

    public ColoredCircle(int xCenter, int yCenter, int radius, String color) throws ColorException {
        this(new Point(xCenter, yCenter), radius, Color.colorFromString(color));
    }

    public ColoredCircle(int radius, Color color) throws ColorException {
        this(new Point(0, 0), radius, color);
    }

    public ColoredCircle(int radius, String color) throws ColorException {
        this(new Point(0, 0), radius, Color.colorFromString(color));
    }

    public ColoredCircle(Color color) throws ColorException {
        this(new Point(0, 0), 1, color);
    }

    public ColoredCircle(String color) throws ColorException {
        this(new Point(0, 0), 1, Color.colorFromString(color));
    }

    public ColoredCircle() throws ColorException {
        this(new Point(0, 0), 1, Color.RED);
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
    public Color getColor() {
        return color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        ColoredCircle that = (ColoredCircle) o;

        return color == that.color;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (color != null ? color.hashCode() : 0);
        return result;
    }
}
