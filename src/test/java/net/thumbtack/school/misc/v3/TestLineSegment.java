package net.thumbtack.school.misc.v3;

import net.thumbtack.school.figures.v3.Point;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestLineSegment {

    @Test
    public void testLineSegment1() {
        Point first = new Point(10, 20);
        Point second = new Point(30, 40);
        LineSegment lineSegment = new LineSegment(first, second);
        assertAll(
                () -> assertEquals(10, lineSegment.getFirstPoint().getX()),
                () -> assertEquals(20, lineSegment.getFirstPoint().getY()),
                () -> assertEquals(30, lineSegment.getSecondPoint().getX()),
                () -> assertEquals(40, lineSegment.getSecondPoint().getY())
        );
    }

    @Test
    public void testRectangle2() {
        LineSegment lineSegment = new LineSegment(10, 20, 30, 40);
        assertAll(
                () -> assertEquals(10, lineSegment.getFirstPoint().getX()),
                () -> assertEquals(20, lineSegment.getFirstPoint().getY()),
                () -> assertEquals(30, lineSegment.getSecondPoint().getX()),
                () -> assertEquals(40, lineSegment.getSecondPoint().getY())
        );
    }

    @Test
    public void testRectangle3() {
        Point point = new Point(10, 20);
        LineSegment lineSegment = new LineSegment(point);
        assertAll(
                () -> assertEquals(0, lineSegment.getFirstPoint().getX()),
                () -> assertEquals(0, lineSegment.getFirstPoint().getY()),
                () -> assertEquals(10, lineSegment.getSecondPoint().getX()),
                () -> assertEquals(20, lineSegment.getSecondPoint().getY())
        );
    }

    @Test
    public void testRectangle4() {
        LineSegment lineSegment = new LineSegment();
        assertAll(
                () -> assertEquals(0, lineSegment.getFirstPoint().getX()),
                () -> assertEquals(0, lineSegment.getFirstPoint().getY()),
                () -> assertEquals(1, lineSegment.getSecondPoint().getX()),
                () -> assertEquals(1, lineSegment.getSecondPoint().getY())
        );
    }

    @Test
    public void testSetCoordinates() {
        LineSegment lineSegment = new LineSegment(10, 20, 30, 40);
        lineSegment.setFirstPoint(new Point(50, 60));
        lineSegment.setSecondPoint(new Point(100, 200));
        assertAll(
                () -> assertEquals(50, lineSegment.getFirstPoint().getX()),
                () -> assertEquals(60, lineSegment.getFirstPoint().getY()),
                () -> assertEquals(100, lineSegment.getSecondPoint().getX()),
                () -> assertEquals(200, lineSegment.getSecondPoint().getY())
        );
    }

    @Test
    public void testMoveLineSegment() {
        LineSegment lineSegment = new LineSegment(10, 20, 30, 40);
        lineSegment.moveRel(100, 50);
        assertAll(
                () -> assertEquals(110, lineSegment.getFirstPoint().getX()),
                () -> assertEquals(70, lineSegment.getFirstPoint().getY()),
                () -> assertEquals(130, lineSegment.getSecondPoint().getX()),
                () -> assertEquals(90, lineSegment.getSecondPoint().getY())
        );
        lineSegment.moveTo(100, 200);
        assertAll(
                () -> assertEquals(100, lineSegment.getFirstPoint().getX()),
                () -> assertEquals(200, lineSegment.getFirstPoint().getY()),
                () -> assertEquals(120, lineSegment.getSecondPoint().getX()),
                () -> assertEquals(220, lineSegment.getSecondPoint().getY())
        );
        lineSegment.moveTo(new Point(1000, 2000));
        assertAll(
                () -> assertEquals(1000, lineSegment.getFirstPoint().getX()),
                () -> assertEquals(2000, lineSegment.getFirstPoint().getY()),
                () -> assertEquals(1020, lineSegment.getSecondPoint().getX()),
                () -> assertEquals(2020, lineSegment.getSecondPoint().getY())
        );
    }

    @Test
    public void testResizeLineSegment1() {
        LineSegment lineSegment = new LineSegment(10, 20, 30, 40);
        lineSegment.resize(3);
        assertAll(
                () -> assertEquals(10, lineSegment.getFirstPoint().getX()),
                () -> assertEquals(20, lineSegment.getFirstPoint().getY()),
                () -> assertEquals(70, lineSegment.getSecondPoint().getX()),
                () -> assertEquals(80, lineSegment.getSecondPoint().getY())
        );
    }

    @Test
    public void testResizeLineSegment2() {
        LineSegment lineSegment = new LineSegment(10, 20, 30, 40);
        lineSegment.resize(0.3);
        assertAll(
                () -> assertEquals(10, lineSegment.getFirstPoint().getX()),
                () -> assertEquals(20, lineSegment.getFirstPoint().getY()),
                () -> assertEquals(16, lineSegment.getSecondPoint().getX()),
                () -> assertEquals(26, lineSegment.getSecondPoint().getY())
        );
    }

    @Test
    public void testStretchLineSegment1() {
        LineSegment lineSegment = new LineSegment(10, 20, 30, 40);
        lineSegment.stretch(3, 5);
        assertAll(
                () -> assertEquals(10, lineSegment.getFirstPoint().getX()),
                () -> assertEquals(20, lineSegment.getFirstPoint().getY()),
                () -> assertEquals(70, lineSegment.getSecondPoint().getX()),
                () -> assertEquals(120, lineSegment.getSecondPoint().getY())
        );
    }

    @Test
    public void testStretchLineSegment2() {
        LineSegment lineSegment = new LineSegment(10, 20, 30, 40);
        lineSegment.stretch(0.3, 0.5);
        assertAll(
                () -> assertEquals(10, lineSegment.getFirstPoint().getX()),
                () -> assertEquals(20, lineSegment.getFirstPoint().getY()),
                () -> assertEquals(16, lineSegment.getSecondPoint().getX()),
                () -> assertEquals(30, lineSegment.getSecondPoint().getY())
        );
    }

    @Test
    public void testEqualsLineSegment() {
        LineSegment lineSegment1 = new LineSegment(10, 20, 30, 40);
        LineSegment lineSegment2 = new LineSegment(10, 20, 30, 40);
        LineSegment lineSegment3 = new LineSegment(20, 30, 40, 50);
        assertEquals(lineSegment1, lineSegment2);
        assertNotEquals(lineSegment1, lineSegment3);
    }

    @Test
    public void testGetLength() {
        LineSegment lineSegment = new LineSegment(5, 4, 9, 7);
        assertAll(
                () -> assertEquals(5, lineSegment.getLength()),
                () -> assertNotEquals(4, lineSegment.getLength())
        );
    }

    @Test
    public void testPointIsInsideTriangle() {
        LineSegment lineSegment = new LineSegment(2, 2, 4, 4);
        Point point = new Point(3,3);
        Point point1 = new Point(5,5);
        Point point2 = new Point(2,2);
        assertAll(
                () -> assertTrue(lineSegment.isInside(point)),
                () -> assertFalse(lineSegment.isInside(point1)),
                () -> assertTrue(lineSegment.isInside(point2))
        );
    }
}