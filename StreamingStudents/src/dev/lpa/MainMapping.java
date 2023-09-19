package dev.lpa;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;

public class MainMapping {

    public static void main(String[] args) {


        Course pymc = new Course("PYMC", "Python Masterclass", 50);
        Course jmc = new Course("JMC", "Java Masterclass", 100);

        Course games = new Course("GAMES", "Creating games in java");

        var listStudents = IntStream
                .rangeClosed(1, 5000)
                .mapToObj(s -> Student.getRandomStudent(jmc, pymc))
                .toList();

        var mappedStudents = listStudents.stream()
                .collect(Collectors.groupingBy(Student::getCountryCode));


        mappedStudents.forEach((k, v) -> System.out.println(k + " " + v.size()));

        System.out.println("------------------------------------");

        int minAge = 25;
        var youngerSet = listStudents.stream()
                .collect(groupingBy(Student::getCountryCode,
                        filtering(s -> s.getAge() < minAge, toList())));

        youngerSet.forEach((k, v) -> System.out.println(k + " " + v.size()));


//        var experienced= listStudents.stream()
//                .collect(partitioningBy(Student::hasProgrammingExperience));
//
//        System.out.println("experienced students :"+ experienced.get(true).size());
//        System.out.println("unexperienced students :"+ experienced.get(false).size());


        var experiencedCount = listStudents.stream()
                .collect(partitioningBy(Student::hasProgrammingExperience, counting()));


        System.out.println("experienced students :" + experiencedCount.get(true));


        var experienceAndActive = listStudents.stream()
                .collect(partitioningBy(s -> s.getMonthsSinceActive() == 0 && s.getMonthsSinceActive() == 0, counting()));


        System.out.println("experienced and active students :" + experienceAndActive.get(true));
        System.out.println("non experienced or non active students :" + experienceAndActive.get(false));


        var multiLevel = listStudents.stream()
                .collect(groupingBy(Student::getCountryCode, groupingBy(Student::getGender, counting())));


        multiLevel.forEach(

                (k, v) -> {
                    System.out.println(k);
                    v.forEach((s, l) -> System.out.println("\t" + s + ": " + l));

                }
        );

        var studentBodyCount= experiencedCount.values().stream()
                        .peek(s-> System.out.println(s))
                .reduce(Long::sum)
                .get();





        System.out.println("contando "+ studentBodyCount);

//
//
//        System.out.println("Students from au and females "+ multiLevel.get("AU").get("F"));
//
//        System.out.println("Students from au and males "+ multiLevel.get("AU").get("M"));
//        System.out.println("Students from au and undetermined "+ multiLevel.get("AU").get("U"));
    }
}
