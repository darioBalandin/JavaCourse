package dev.lpa;

import java.util.stream.Stream;

public class MainChallenge {

    public static void main(String[] args) {
        Course pymc = new Course("PYMC", "Python Masterclass", 50);
        Course jmc = new Course("JMC", "Java Masterclass", 100);

        Course games = new Course("GAMES", "Creating games in java");

        var listStudents = Stream.generate(() -> Student.getRandomStudent(jmc, pymc, games))
                .limit(50)
                .toList();


//        listStudents.forEach(s->System.out.println(s+"\n"));


        var summaryStatistics = listStudents.stream()
                .mapToDouble(s -> s.getPercentComplete("PYMC"))
                .summaryStatistics();
//                .reduce(0, Double::sum);

        System.out.println(summaryStatistics.getAverage());

        int topPercent= (int) (1.25 * summaryStatistics.getAverage());

        var filtered=listStudents.stream()
                .filter(s->s.getPercentComplete("PYMC")> topPercent)
                .toList();

        filtered.forEach(System.out::println);
//        var average = totalPercent / listStudents.size();
//        System.out.printf("average percentage completed = %.2f%%", average);
    }
}
