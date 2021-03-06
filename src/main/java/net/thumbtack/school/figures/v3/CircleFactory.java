package net.thumbtack.school.figures.v3;

public class CircleFactory {

    private static int counter;

    public static Circle createCircle(Point center, int radius) {
        counter++;
        return new Circle(center, radius);
    }

    public static int getCircleCount() {
        return counter;
    }

    public static void reset() {
        counter = 0;
    }
}
