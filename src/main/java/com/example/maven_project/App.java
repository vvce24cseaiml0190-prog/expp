
package com.example.maven_project;

import java.util.Scanner;

/**
 * Student Grade Calculator Application
 */
public class App {

    // Calculate total marks
    public int calculateTotal(int[] marks) {

        validateMarks(marks);

        int total = 0;

        for (int mark : marks) {
            total += mark;
        }

        return total;
    }

    // Calculate average marks
    public double calculateAverage(int[] marks) {

        return calculateTotal(marks) / 5.0;
    }

    // Calculate grade based on average
    public String calculateGrade(double average) {

        if (average < 0 || average > 100) {
            throw new IllegalArgumentException(
                "Average must be between 0 and 100"
            );
        }

        if (average >= 90) {
            return "A";
        } else if (average >= 80) {
            return "B";
        } else if (average >= 70) {
            return "C";
        } else if (average >= 60) {
            return "D";
        } else {
            return "F";
        }
    }

    // Validate subject marks
    private void validateMarks(int[] marks) {

        if (marks == null || marks.length != 5) {
            throw new IllegalArgumentException(
                "Exactly five subject marks are required"
            );
        }

        for (int mark : marks) {

            if (mark < 0 || mark > 100) {
                throw new IllegalArgumentException(
                    "Marks must be between 0 and 100"
                );
            }
        }
    }

    // Main method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        App app = new App();

        int[] marks = new int[5];

        String[] subjects = {
            "Java",
            "Python",
            "DBMS",
            "Computer Networks",
            "Operating Systems"
        };

        System.out.println("================================");
        System.out.println("     STUDENT GRADE CALCULATOR");
        System.out.println("================================");

        try {

            // Accept marks for five subjects
            for (int i = 0; i < 5; i++) {

                System.out.print(
                    "Enter marks for " + subjects[i] + ": "
                );

                marks[i] = sc.nextInt();
            }

            // Calculate results
            int total = app.calculateTotal(marks);

            double average = app.calculateAverage(marks);

            String grade = app.calculateGrade(average);

            // Display results
            System.out.println("\n========== RESULT ==========");

            System.out.println("Total Marks: " + total + "/500");

            System.out.printf("Average: %.2f%%\n", average);

            System.out.println("Grade: " + grade);

            System.out.println("============================");

        } catch (IllegalArgumentException e) {

            System.out.println("Error: " + e.getMessage());

        } catch (java.util.InputMismatchException e) {

            System.out.println("Error: Please enter valid integer marks.");

        } finally {

            sc.close();
        }
    }
}

