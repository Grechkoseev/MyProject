package net.thumbtack.school.misc.v3;

import net.thumbtack.school.figures.v3.Point;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestTriangle {

    private static final double DOUBLE_EPS = 1E-6;

    @Test
    public void testTriangle1() {
        Point firstPoint = new Point(10, 20);
        Point secondPoint = new Point(30, 40);
        Point thirdPoint = new Point(5,50);
        Triangle triangle = new Triangle(firstPoint, secondPoint, thirdPoint);
        assertAll(
                () -> assertEquals(10, triangle.getFirstPoint().getX()),
                () -> assertEquals(20, triangle.getFirstPoint().getY()),
                () -> assertEquals(30, triangle.getSecondPoint().getX()),
                () -> assertEquals(40, triangle.getSecondPoint().getY()),
                () -> assertEquals(5, triangle.getThirdPoint().getX()),
                () -> assertEquals(50, triangle.getThirdPoint().getY())
        );
    }

    @Test
    public void testTriangle2() {
        Triangle triangle = new Triangle(10,20,30,40,5,50);
        assertAll(
                () -> assertEquals(10, triangle.getFirstPoint().getX()),
                () -> assertEquals(20, triangle.getFirstPoint().getY()),
                () -> assertEquals(30, triangle.getSecondPoint().getX()),
                () -> assertEquals(40, triangle.getSecondPoint().getY()),
                () -> assertEquals(5, triangle.getThirdPoint().getX()),
                () -> assertEquals(50, triangle.getThirdPoint().getY())
        );
    }

    @Test
    public void testTriangle3() {
        Point secondPoint = new Point(30, 40);
        Point thirdPoint = new Point(5,50);
        Triangle triangle = new Triangle(secondPoint, thirdPoint);
        assertAll(
                () -> assertEquals(0, triangle.getFirstPoint().getX()),
                () -> assertEquals(0, triangle.getFirstPoint().getY()),
                () -> assertEquals(30, triangle.getSecondPoint().getX()),
                () -> assertEquals(40, triangle.getSecondPoint().getY()),
                () -> assertEquals(5, triangle.getThirdPoint().getX()),
                () -> assertEquals(50, triangle.getThirdPoint().getY())
        );
    }

    @Test
    public void testTriangle4() {
        Point thirdPoint = new Point(5,50);
        Triangle triangle = new Triangle(thirdPoint);
        assertAll(
                () -> assertEquals(0, triangle.getFirstPoint().getX()),
                () -> assertEquals(0, triangle.getFirstPoint().getY()),
                () -> assertEquals(1, triangle.getSecondPoint().getX()),
                () -> assertEquals(1, triangle.getSecondPoint().getY()),
                () -> assertEquals(5, triangle.getThirdPoint().getX()),
                () -> assertEquals(50, triangle.getThirdPoint().getY())
        );
    }

    @Test
    public void testTriangle5() {
        Triangle triangle = new Triangle();
        assertAll(
                () -> assertEquals(0, triangle.getFirstPoint().getX()),
                () -> assertEquals(0, triangle.getFirstPoint().getY()),
                () -> assertEquals(0, triangle.getSecondPoint().getX()),
                () -> assertEquals(1, triangle.getSecondPoint().getY()),
                () -> assertEquals(1, triangle.getThirdPoint().getX()),
                () -> assertEquals(0, triangle.getThirdPoint().getY())
        );
    }

    @Test
    public void testSetCoordinates() {
        Triangle triangle = new Triangle(10, 20, 30, 40, 5, 50);
        triangle.setFirstPoint(new Point(50, 60));
        triangle.setSecondPoint(new Point(100, 200));
        triangle.setThirdPoint(new Point(70, 15));
        assertAll(
                () -> assertEquals(50, triangle.getFirstPoint().getX()),
                () -> assertEquals(60, triangle.getFirstPoint().getY()),
                () -> assertEquals(100, triangle.getSecondPoint().getX()),
                () -> assertEquals(200, triangle.getSecondPoint().getY()),
                () -> assertEquals(70, triangle.getThirdPoint().getX()),
                () -> assertEquals(15, triangle.getThirdPoint().getY())
        );
    }

    @Test
    public void testMoveTriangle() {
        Triangle triangle = new Triangle(10, 20, 30, 40, 5, 50);
        triangle.moveRel(100, 50);
        assertAll(
                () -> assertEquals(110, triangle.getFirstPoint().getX()),
                () -> assertEquals(70, triangle.getFirstPoint().getY()),
                () -> assertEquals(130, triangle.getSecondPoint().getX()),
                () -> assertEquals(90, triangle.getSecondPoint().getY()),
                () -> assertEquals(105, triangle.getThirdPoint().getX()),
                () -> assertEquals(100, triangle.getThirdPoint().getY())
        );
        triangle.moveTo(100, 200);
        assertAll(
                () -> assertEquals(100, triangle.getFirstPoint().getX()),
                () -> assertEquals(200, triangle.getFirstPoint().getY()),
                () -> assertEquals(120, triangle.getSecondPoint().getX()),
                () -> assertEquals(220, triangle.getSecondPoint().getY()),
                () -> assertEquals(95, triangle.getThirdPoint().getX()),
                () -> assertEquals(230, triangle.getThirdPoint().getY())
        );
        triangle.moveTo(new Point(1000, 2000));
        assertAll(
                () -> assertEquals(1000, triangle.getFirstPoint().getX()),
                () -> assertEquals(2000, triangle.getFirstPoint().getY()),
                () -> assertEquals(1020, triangle.getSecondPoint().getX()),
                () -> assertEquals(2020, triangle.getSecondPoint().getY()),
                () -> assertEquals(995, triangle.getThirdPoint().getX()),
                () -> assertEquals(2030, triangle.getThirdPoint().getY())
        );
    }

    @Test
    public void testResizeTriangle1() {
        Triangle triangle = new Triangle(10, 20, 30, 40, 5, 50);
        triangle.resize(3);
        assertAll(
                () -> assertEquals(10, triangle.getFirstPoint().getX()),
                () -> assertEquals(20, triangle.getFirstPoint().getY()),
                () -> assertEquals(70, triangle.getSecondPoint().getX()),
                () -> assertEquals(80, triangle.getSecondPoint().getY()),
                () -> assertEquals(-5, triangle.getThirdPoint().getX()),
                () -> assertEquals(110, triangle.getThirdPoint().getY())
        );
    }

    @Test
    public void testResizeTriangle2() {
        Triangle triangle = new Triangle(10, 20, 30, 40, 5, 50);
        triangle.resize(0.3);
        assertAll(
                () -> assertEquals(10, triangle.getFirstPoint().getX()),
                () -> assertEquals(20, triangle.getFirstPoint().getY()),
                () -> assertEquals(16, triangle.getSecondPoint().getX()),
                () -> assertEquals(26, triangle.getSecondPoint().getY()),
                () -> assertEquals(9, triangle.getThirdPoint().getX()),
                () -> assertEquals(29, triangle.getThirdPoint().getY())
        );
    }

    @Test
    public void testIsPointInsideTriangle1() {
        Triangle triangle = new Triangle(10, 20, 30, 40, 5, 50);
        assertAll(
                () -> assertTrue(triangle.isInside(20, 30)),
                () -> assertTrue(triangle.isInside(10, 30)),
                () -> assertTrue(triangle.isInside(10, 40)),
                () -> assertFalse(triangle.isInside(30, 30)),
                () -> assertFalse(triangle.isInside(0, 0)),
                () -> assertFalse(triangle.isInside(10, 100)),
                () -> assertFalse(triangle.isInside(-10, 20)),
                () -> assertFalse(triangle.isInside(10, -20))
        );
    }

    @Test
    public void testIsPointInsideTriangle2() {
        Triangle triangle = new Triangle(10, 20, 30, 40, 5, 50);
        assertAll(
                () -> assertTrue(triangle.isInside(new Point(20, 30))),
                () -> assertTrue(triangle.isInside(new Point(10, 30))),
                () -> assertTrue(triangle.isInside(new Point(10, 40))),
                () -> assertFalse(triangle.isInside(new Point(30, 30))),
                () -> assertFalse(triangle.isInside(new Point(0, 0))),
                () -> assertFalse(triangle.isInside(new Point(10, 100))),
                () -> assertFalse(triangle.isInside(new Point(-10, 20))),
                () -> assertFalse(triangle.isInside(new Point(10, -20)))
        );
    }

    @Test
    public void testEqualsTriangle() {
        Triangle triangle1 = new Triangle(10, 20, 30, 40, 5, 50);
        Triangle triangle2 = new Triangle(10, 20, 30, 40, 5, 50);
        Triangle triangle3 = new Triangle(20, 30, 40, 50, 5, 50);
        assertEquals(triangle1, triangle2);
        assertNotEquals(triangle1, triangle3);
    }

    @Test
    public void testAreaTriangle() {
        Triangle triangle1 = new Triangle(10, 20, 30, 40, 5, 50);
        Triangle triangle2 = new Triangle(20, 30, 40, 80, 35, 70);
        assertEquals(350, triangle1.getArea(), DOUBLE_EPS);
        assertEquals(25, triangle2.getArea(), DOUBLE_EPS);
    }

    @Test
    public void testPerimeterTriangle() {
        Triangle triangle1 = new Triangle(10, 20, 30, 40, 5, 50);
        Triangle triangle2 = new Triangle(20, 30, 40, 80, 35, 70);
        assertEquals(85.62390793462552, triangle1.getPerimeter(), DOUBLE_EPS);
        assertEquals(107.75200668543164, triangle2.getPerimeter(), DOUBLE_EPS);
    }
}
