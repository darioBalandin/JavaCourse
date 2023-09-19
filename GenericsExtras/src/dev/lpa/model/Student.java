package dev.lpa.model;

import dev.lpa.util.QueryItem;

import java.util.Random;

public class Student implements QueryItem, Comparable<Student> {

    private String name;
    private String course;
    private int yearStarted;

    private static int LAST_ID = 10000;
    private int studentId;

    protected static Random random = new Random();

    private static String[] firstNames = {"Ann", "Bill", "Cathy", "John", "Tim"};
    private static String[] courses = {"C++", "Java", "Python"};

    public Student() {
        studentId = LAST_ID;
        int lastNameIndex = LAST_ID++;

        name = firstNames[random.nextInt(5)] + " " + (char) random.nextInt(65,91);
        course = courses[random.nextInt(3)];
        yearStarted = random.nextInt(2018, 2023);
    }

    @Override
    public String toString() {
        return "%d %-15s %-15s %d".formatted(studentId, name, course, yearStarted);
    }

    public int getYearStarted() {
        return yearStarted;
    }

    @Override
    public boolean matchFieldValue(String fieldName, String value) {

        String fName = fieldName.toUpperCase();
        return switch (fName) {
            case "NAME" -> name.equalsIgnoreCase(value);
            case "COURSE" -> course.equalsIgnoreCase(value);
            case "YEARSTARTED" -> yearStarted == (Integer.parseInt(value));
            default -> false;
        };
    }

    @Override
    public int compareTo(Student o) {
        return Integer.compare(studentId, o.studentId);
    }
}
