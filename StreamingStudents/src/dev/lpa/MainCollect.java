package dev.lpa;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainCollect {

    public static void main(String[] args) {

        Course pymc = new Course("PYMC", "Python Masterclass");
        Course jmc = new Course("JMC", "Java Masterclass");

        List<Student> students = Stream.generate(() -> Student.getRandomStudent())
                .limit(1000)
                .toList();

        Set<Student> australianStudents = students.stream()
                .filter(student -> student.getCountryCode().equals("AU"))
                .collect(Collectors.toSet());
        System.out.println("# of australian students" + australianStudents.size());


        Set<Student> underThirty = students.stream()
                .filter(student -> student.getAge() < 30)
                .collect(Collectors.toSet());
        System.out.println("# of australian students" + underThirty.size());


        Set<Student> youngAussies = new TreeSet<>(Comparator.comparing(Student::getStudentId));

        youngAussies.addAll(australianStudents);
        youngAussies.retainAll(underThirty);


        Set<Student> noAussies = students.stream()
                .filter(s -> !s.getCountryCode().equals("AU"))
                .filter(student -> student.getAge() < 30)
                .limit(10)
                .collect(() -> new TreeSet<>(Comparator.comparing(Student::getStudentId)), TreeSet::add, TreeSet::addAll);


        youngAussies.forEach(s -> System.out.println(s.getStudentId()));
        System.out.println("-".repeat(20));
        noAussies.forEach(s -> System.out.println(s.getStudentId()));


        String countryList = students.stream()
                .map(student -> student.getCountryCode())
                .distinct()
                .sorted()
                .reduce("", (r, v) -> r + " " + v);

        System.out.println("countryList: "+countryList);
//        System.out.println(youngAussies);
//        System.out.println(noAussies);
    }
}
