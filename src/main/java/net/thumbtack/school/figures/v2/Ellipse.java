package net.thumbtack.school.figures.v2;

import net.thumbtack.school.iface.v2.Stretchable;

import java.util.Objects;

public class Ellipse extends Figure implements Stretchable {

    private Point center;
    private int xAxis, yAxis;

    public Ellipse(Point center, int xAxis, int yAxis) {
        this.center = center;
        this.xAxis = xAxis;
        this.yAxis = yAxis;
    }

    public Ellipse(int xCenter, int yCenter, int xAxis, int yAxis) {
        this(new Point(xCenter, yCenter), xAxis, yAxis);
    }

    public Ellipse(int xAxis, int yAxis) {
        this(new Point(0, 0), xAxis, yAxis);
    }

    public Ellipse() {
        this(new Point(0,0), 1, 1);
    }

    public Point getCenter() {
        return center;
    }

    public int getXAxis() {
        return xAxis;
    }

    public int getYAxis() {
        return yAxis;
    }

    public void setXAxis(int xAxis) {
        this.xAxis = xAxis;
    }

    public void setYAxis(int yAxis) {
        this.yAxis = yAxis;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public void moveTo(int leftTop, int rightBottom) {
        center.moveTo(leftTop, rightBottom);
    }

    public void moveRel(int dx, int dy) {
        center.moveRel(dx, dy);
    }

    public void resize(double ratio) {
        xAxis *= ratio;
        yAxis *= ratio;
    }

    public void stretch(double xRatio, double yRatio) {
        xAxis *= xRatio;
        yAxis *= yRatio;
    }

    public double getArea() {
        return Math.PI * xAxis * yAxis / 4;
    }

    public double getPerimeter() {
        return 2 * Math.PI * Math.sqrt((Math.pow(xAxis, 2) + Math.pow(yAxis, 2)) / 8);
    }

    public boolean isInside(int x, int y) {
        return (x - center.getX()) * (x - center.getX()) / (((double) xAxis / 2) * (double) xAxis / 2) +
                (y - center.getY()) * (y - center.getY()) / (((double) yAxis / 2) * (double) yAxis / 2) <= 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ellipse ellipse = (Ellipse) o;

        if (xAxis != ellipse.xAxis) return false;
        if (yAxis != ellipse.yAxis) return false;
        return Objects.equals(center, ellipse.center);
    }

    @Override
    public int hashCode() {
        int result = center != null ? center.hashCode() : 0;
        result = 31 * result + xAxis;
        result = 31 * result + yAxis;
        return result;
    }
}
