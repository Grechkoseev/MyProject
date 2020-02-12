package net.thumbtack.school.figures.v3;

import net.thumbtack.school.iface.v3.Movable;

public class Point implements Movable {

    private int leftTop, rightBottom;

    public Point(int leftTop, int rightBottom) {
        this.leftTop = leftTop;
        this.rightBottom = rightBottom;
    }

    public Point() {
        this(0, 0);
    }

    public int getX() {
        return leftTop;
    }

    public void setX(int leftTop) {
        this.leftTop = leftTop;
    }

    public int getY() {
        return rightBottom;
    }

    public void setY(int rightBottom) {
        this.rightBottom = rightBottom;
    }

    public void moveTo(int newX, int newY) {
        leftTop = newX;
        rightBottom = newY;
    }

    public void moveRel(int dx, int dy) {
        leftTop += dx;
        rightBottom += dy;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + leftTop;
        result = prime * result + rightBottom;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Point other = (Point) obj;
        if (leftTop != other.leftTop)
            return false;
        if (rightBottom != other.rightBottom)
            return false;
        return true;
    }
}