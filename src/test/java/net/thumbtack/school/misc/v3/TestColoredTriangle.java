package net.thumbtack.school.misc.v3;

import net.thumbtack.school.colors.v3.Color;
import net.thumbtack.school.colors.v3.ColorException;
import net.thumbtack.school.figures.v3.Point;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestColoredTriangle {

    @Test
    public void testColoredTriangle1() throws ColorException {
        Point firstPoint = new Point(10, 20);
        Point secondPoint = new Point(30, 40);
        Point thirdPoint = new Point(5,50);
        Color color = Color.RED;
        ColoredTriangle coloredTriangle = new ColoredTriangle(firstPoint, secondPoint, thirdPoint, color);
        assertAll(
                () -> assertEquals(10, coloredTriangle.getFirstPoint().getX()),
                () -> assertEquals(20, coloredTriangle.getFirstPoint().getY()),
                () -> assertEquals(30, coloredTriangle.getSecondPoint().getX()),
                () -> assertEquals(40, coloredTriangle.getSecondPoint().getY()),
                () -> assertEquals(5, coloredTriangle.getThirdPoint().getX()),
                () -> assertEquals(50, coloredTriangle.getThirdPoint().getY()),
                () -> assertEquals(Color.RED, coloredTriangle.getColor())
        );
    }

    @Test
    public void testColoredTriangle2() throws ColorException {
        ColoredTriangle coloredTriangle = new ColoredTriangle(10,20,30,40,5,50, Color.GREEN);
        assertAll(
                () -> assertEquals(10, coloredTriangle.getFirstPoint().getX()),
                () -> assertEquals(20, coloredTriangle.getFirstPoint().getY()),
                () -> assertEquals(30, coloredTriangle.getSecondPoint().getX()),
                () -> assertEquals(40, coloredTriangle.getSecondPoint().getY()),
                () -> assertEquals(5, coloredTriangle.getThirdPoint().getX()),
                () -> assertEquals(50, coloredTriangle.getThirdPoint().getY()),
                () -> assertEquals(Color.GREEN, coloredTriangle.getColor())
        );
    }

    @Test
    public void testColoredTriangle3() throws ColorException {
        Point secondPoint = new Point(30, 40);
        Point thirdPoint = new Point(5,50);
        Color color = Color.RED;
        ColoredTriangle coloredTriangle = new ColoredTriangle(secondPoint, thirdPoint, color);
        assertAll(
                () -> assertEquals(0, coloredTriangle.getFirstPoint().getX()),
                () -> assertEquals(0, coloredTriangle.getFirstPoint().getY()),
                () -> assertEquals(30, coloredTriangle.getSecondPoint().getX()),
                () -> assertEquals(40, coloredTriangle.getSecondPoint().getY()),
                () -> assertEquals(5, coloredTriangle.getThirdPoint().getX()),
                () -> assertEquals(50, coloredTriangle.getThirdPoint().getY()),
                () -> assertEquals(Color.RED, coloredTriangle.getColor())
        );
    }

    @Test
    public void testColoredTriangle4() throws ColorException {
        Point thirdPoint = new Point(5,50);
        Color color = Color.RED;
        ColoredTriangle coloredTriangle = new ColoredTriangle(thirdPoint, color);
        assertAll(
                () -> assertEquals(0, coloredTriangle.getFirstPoint().getX()),
                () -> assertEquals(0, coloredTriangle.getFirstPoint().getY()),
                () -> assertEquals(1, coloredTriangle.getSecondPoint().getX()),
                () -> assertEquals(1, coloredTriangle.getSecondPoint().getY()),
                () -> assertEquals(5, coloredTriangle.getThirdPoint().getX()),
                () -> assertEquals(50, coloredTriangle.getThirdPoint().getY()),
                () -> assertEquals(Color.RED, coloredTriangle.getColor())
        );
    }

    @Test
    public void testColoredTriangle5() throws ColorException {
        Color color = Color.RED;
        ColoredTriangle coloredTriangle = new ColoredTriangle(color);
        assertAll(
                () -> assertEquals(0, coloredTriangle.getFirstPoint().getX()),
                () -> assertEquals(0, coloredTriangle.getFirstPoint().getY()),
                () -> assertEquals(0, coloredTriangle.getSecondPoint().getX()),
                () -> assertEquals(1, coloredTriangle.getSecondPoint().getY()),
                () -> assertEquals(1, coloredTriangle.getThirdPoint().getX()),
                () -> assertEquals(0, coloredTriangle.getThirdPoint().getY()),
                () -> assertEquals(Color.RED, coloredTriangle.getColor())
        );
    }

    @Test
    public void testColoredTriangle6() throws ColorException {
        ColoredTriangle coloredTriangle = new ColoredTriangle(Color.RED);
        assertAll(
                () -> assertEquals(0, coloredTriangle.getFirstPoint().getX()),
                () -> assertEquals(0, coloredTriangle.getFirstPoint().getY()),
                () -> assertEquals(0, coloredTriangle.getSecondPoint().getX()),
                () -> assertEquals(1, coloredTriangle.getSecondPoint().getY()),
                () -> assertEquals(1, coloredTriangle.getThirdPoint().getX()),
                () -> assertEquals(0, coloredTriangle.getThirdPoint().getY()),
                () -> assertEquals(Color.RED, coloredTriangle.getColor())
        );
    }

    @Test
    public void testSetColor() throws ColorException {
        ColoredTriangle coloredTriangle = new ColoredTriangle(Color.BLUE);
        coloredTriangle.setColor(Color.RED);
        assertAll(
                () -> assertEquals(Color.RED, coloredTriangle.getColor()),
                () -> assertNotEquals(Color.GREEN, coloredTriangle.getColor())
        );
    }

    @Test
    public void testEqualsTriangle() throws ColorException {
        ColoredTriangle triangle1 = new ColoredTriangle(10, 20, 30, 40, 5, 50, Color.RED);
        ColoredTriangle triangle2 = new ColoredTriangle(10, 20, 30, 40, 5, 50, Color.RED);
        ColoredTriangle triangle3 = new ColoredTriangle(10, 20, 30, 40, 5, 50, Color.BLUE);
        assertEquals(triangle1, triangle2);
        assertNotEquals(triangle1, triangle3);
    }
}
