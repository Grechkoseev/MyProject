package net.thumbtack.school.figures.v3;

import net.thumbtack.school.iface.v3.HasArea;
import net.thumbtack.school.iface.v3.Movable;
import net.thumbtack.school.iface.v3.Resizable;

public abstract class Figure implements HasArea, Movable, Resizable {

    abstract public void moveTo(int x, int y);

    abstract public void moveRel(int dx, int dy);

    abstract public double getArea();

    abstract public double getPerimeter();

    abstract public void resize(double ratio);

    abstract public boolean isInside(int x, int y);

    public boolean isInside(Point point) {
        return isInside(point.getX(), point.getY());
    }
}