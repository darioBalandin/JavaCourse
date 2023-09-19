package dev.lpa;

import java.util.stream.IntStream;

public class MainStreamChallenge {

    public static void main(String[] args) {


        Course pymc = new Course("PYMC", "Python Masterclass", 50);
        Course jmc = new Course("JMC", "Java Masterclass", 100);

        Course games = new Course("GAMES", "Creating games in java", 68);

        Course grandom = new Course("GRANDOM", "Random Game creation", 90);


        var listStudents = IntStream
                .rangeClosed(1, 10)
                .mapToObj(s -> Student.getRandomStudent(jmc, pymc, games, grandom))
                .toList();

        listStudents.forEach(System.out::println);


//        var stats = listStudents.stream()
//                .mapToInt(s -> s.getEngagementMap().size())
//                .summaryStatistics();
////        System.out.println("estats;" + stats);
//
//
//        var mappedActivity = listStudents.stream()
//                .flatMap(s -> s.getEngagementMap().keySet().stream())
////                .peek(System.out::println)
//                .collect(Collectors.groupingBy(String::valueOf, Collectors.counting()));
//
//        System.out.println("Alumnos apuntados a cada clase: " + mappedActivity);
//
//        var mappedClasses = listStudents.stream()
//                .map(s -> s.getEngagementMap().size())
//                .collect(Collectors.groupingBy(Integer::valueOf, Collectors.counting()));
//
//
//        System.out.println("Mapa de cuantas clases ha elegido cada alumno: " + mappedClasses);
//
//        var percentageCompleted = listStudents.stream()
//                .flatMap(s -> s.getEngagementMap().values().stream())
//                .collect(Collectors.groupingBy(CourseEngagement::getCourseCode, Collectors.
//                        summarizingDouble(CourseEngagement::getPercentComplete)));
//
//
//        System.out.println("estadisticas por curso: ");
//        percentageCompleted.forEach((k, v) -> System.out.println(k + " " + v));
//
//
//        var yearMap = listStudents.stream()
//                .flatMap(s -> s.getEngagementMap().values().stream())
//                .collect(Collectors.groupingBy(CourseEngagement::getCourseCode,
//                        Collectors.groupingBy(CourseEngagement::getEnrollmentYear,
//                                TreeMap::new, Collectors.counting())));
//
//        yearMap.forEach((k, v) -> {
//            System.out.println(k + " ");
//            v.forEach((k2, v2) -> System.out.println("\t" + k2 + " " + v2));
//        });
    }
}
