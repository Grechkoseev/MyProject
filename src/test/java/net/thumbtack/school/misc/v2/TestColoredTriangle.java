package net.thumbtack.school.misc.v2;

import net.thumbtack.school.figures.v2.Point;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestColoredTriangle {

    private static final double DOUBLE_EPS = 1E-6;

    @Test
    public void testColoredTriangle1() {
        Point firstPoint = new Point(10, 20);
        Point secondPoint = new Point(30, 40);
        Point thirdPoint = new Point(5,50);
        int color = 1;
        ColoredTriangle coloredTriangle = new ColoredTriangle(firstPoint, secondPoint, thirdPoint, color);
        assertAll(
                () -> assertEquals(10, coloredTriangle.getFirstPoint().getX()),
                () -> assertEquals(20, coloredTriangle.getFirstPoint().getY()),
                () -> assertEquals(30, coloredTriangle.getSecondPoint().getX()),
                () -> assertEquals(40, coloredTriangle.getSecondPoint().getY()),
                () -> assertEquals(5, coloredTriangle.getThirdPoint().getX()),
                () -> assertEquals(50, coloredTriangle.getThirdPoint().getY()),
                () -> assertEquals(1, coloredTriangle.getColor())
        );
    }

    @Test
    public void testColoredTriangle2() {
        ColoredTriangle coloredTriangle = new ColoredTriangle(10,20,30,40,5,50, 2);
        assertAll(
                () -> assertEquals(10, coloredTriangle.getFirstPoint().getX()),
                () -> assertEquals(20, coloredTriangle.getFirstPoint().getY()),
                () -> assertEquals(30, coloredTriangle.getSecondPoint().getX()),
                () -> assertEquals(40, coloredTriangle.getSecondPoint().getY()),
                () -> assertEquals(5, coloredTriangle.getThirdPoint().getX()),
                () -> assertEquals(50, coloredTriangle.getThirdPoint().getY()),
                () -> assertEquals(2, coloredTriangle.getColor())
        );
    }

    @Test
    public void testColoredTriangle3() {
        Point secondPoint = new Point(30, 40);
        Point thirdPoint = new Point(5,50);
        int color = 1;
        ColoredTriangle coloredTriangle = new ColoredTriangle(secondPoint, thirdPoint, color);
        assertAll(
                () -> assertEquals(0, coloredTriangle.getFirstPoint().getX()),
                () -> assertEquals(0, coloredTriangle.getFirstPoint().getY()),
                () -> assertEquals(30, coloredTriangle.getSecondPoint().getX()),
                () -> assertEquals(40, coloredTriangle.getSecondPoint().getY()),
                () -> assertEquals(5, coloredTriangle.getThirdPoint().getX()),
                () -> assertEquals(50, coloredTriangle.getThirdPoint().getY()),
                () -> assertEquals(1, coloredTriangle.getColor())
        );
    }

    @Test
    public void testColoredTriangle4() {
        Point thirdPoint = new Point(5,50);
        int color = 1;
        ColoredTriangle coloredTriangle = new ColoredTriangle(thirdPoint, color);
        assertAll(
                () -> assertEquals(0, coloredTriangle.getFirstPoint().getX()),
                () -> assertEquals(0, coloredTriangle.getFirstPoint().getY()),
                () -> assertEquals(1, coloredTriangle.getSecondPoint().getX()),
                () -> assertEquals(1, coloredTriangle.getSecondPoint().getY()),
                () -> assertEquals(5, coloredTriangle.getThirdPoint().getX()),
                () -> assertEquals(50, coloredTriangle.getThirdPoint().getY()),
                () -> assertEquals(1, coloredTriangle.getColor())
        );
    }

    @Test
    public void testColoredTriangle5() {
        int color = 1;
        ColoredTriangle coloredTriangle = new ColoredTriangle(color);
        assertAll(
                () -> assertEquals(0, coloredTriangle.getFirstPoint().getX()),
                () -> assertEquals(0, coloredTriangle.getFirstPoint().getY()),
                () -> assertEquals(0, coloredTriangle.getSecondPoint().getX()),
                () -> assertEquals(1, coloredTriangle.getSecondPoint().getY()),
                () -> assertEquals(1, coloredTriangle.getThirdPoint().getX()),
                () -> assertEquals(0, coloredTriangle.getThirdPoint().getY()),
                () -> assertEquals(1, coloredTriangle.getColor())
        );
    }

    @Test
    public void testColoredTriangle6() {
        ColoredTriangle coloredTriangle = new ColoredTriangle();
        assertAll(
                () -> assertEquals(0, coloredTriangle.getFirstPoint().getX()),
                () -> assertEquals(0, coloredTriangle.getFirstPoint().getY()),
                () -> assertEquals(0, coloredTriangle.getSecondPoint().getX()),
                () -> assertEquals(1, coloredTriangle.getSecondPoint().getY()),
                () -> assertEquals(1, coloredTriangle.getThirdPoint().getX()),
                () -> assertEquals(0, coloredTriangle.getThirdPoint().getY()),
                () -> assertEquals(1, coloredTriangle.getColor())
        );
    }

    @Test
    public void testSetColor() {
        ColoredTriangle coloredTriangle = new ColoredTriangle();
        coloredTriangle.setColor(5);
        assertAll(
                () -> assertEquals(5, coloredTriangle.getColor()),
                () -> assertNotEquals(1, coloredTriangle.getColor())
        );
    }

    @Test
    public void testEqualsTriangle() {
        ColoredTriangle triangle1 = new ColoredTriangle(10, 20, 30, 40, 5, 50, 1);
        ColoredTriangle triangle2 = new ColoredTriangle(10, 20, 30, 40, 5, 50, 1);
        ColoredTriangle triangle3 = new ColoredTriangle(10, 20, 30, 40, 5, 50, 2);
        assertEquals(triangle1, triangle2);
        assertNotEquals(triangle1, triangle3);
    }
}
