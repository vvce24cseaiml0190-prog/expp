
package com.example.maven_project;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for Student Grade Calculator.
 */
public class AppTest {

    @Test
    public void testTotalMarks() {
        App app = new App();

        int[] marks = {80, 90, 70, 85, 75};

        assertEquals(400, app.calculateTotal(marks));
    }

    @Test
    public void testAverageMarks() {
        App app = new App();

        int[] marks = {80, 90, 70, 85, 75};

        assertEquals(80.0, app.calculateAverage(marks), 0.01);
    }

    @Test
    public void testGradeA() {
        App app = new App();
        assertEquals("A", app.calculateGrade(95));
    }

    @Test
    public void testGradeB() {
        App app = new App();
        assertEquals("B", app.calculateGrade(85));
    }

    @Test
    public void testGradeC() {
        App app = new App();
        assertEquals("C", app.calculateGrade(75));
    }

    @Test
    public void testGradeD() {
        App app = new App();
        assertEquals("D", app.calculateGrade(65));
    }

    @Test
    public void testGradeF() {
        App app = new App();
        assertEquals("F", app.calculateGrade(45));
    }

    @Test
    public void testZeroMarks() {
        App app = new App();

        int[] marks = {0, 0, 0, 0, 0};

        assertEquals(0, app.calculateTotal(marks));
        assertEquals(0.0, app.calculateAverage(marks), 0.01);
        assertEquals("F", app.calculateGrade(0));
    }

    @Test
    public void testNegativeMarks() {
        App app = new App();

        int[] marks = {80, 90, -10, 85, 75};

        assertThrows(IllegalArgumentException.class,
                () -> app.calculateTotal(marks));
    }

    @Test
    public void testMarksAbove100() {
        App app = new App();

        int[] marks = {80, 90, 110, 85, 75};

        assertThrows(IllegalArgumentException.class,
                () -> app.calculateTotal(marks));
    }

    @Test
    public void testInvalidSubjectCount() {
        App app = new App();

        int[] marks = {80, 90, 70};

        assertThrows(IllegalArgumentException.class,
                () -> app.calculateTotal(marks));
    }
}
