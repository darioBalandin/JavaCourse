package dev.lpa;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class MainTerminalOptional {

    public static void main(String[] args) {


        Course pymc = new Course("PYMC", "Python Masterclass");
        Course jmc = new Course("JMC", "Java Masterclass");

        List<Student> students = Stream.generate(() -> Student.getRandomStudent())
                .limit(1000)
                .toList();

        int minAge = 17;

        students.stream()
                .filter(s -> s.getAge() < minAge)
                .max (Comparator.comparing(Student::getAge)).ifPresent(System.out::println);


        students.stream()
                .filter(s -> s.getAge() < minAge)
                .map(Student::getCountryCode)
                .distinct()
                .reduce((a,b)->String.join(",",a,b))
                .ifPresentOrElse(System.out::println,()-> System.out.println("None found"));


    }
}
