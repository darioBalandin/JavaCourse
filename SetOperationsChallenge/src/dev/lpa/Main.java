package dev.lpa;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Set<Task> tasks = TaskData.getTasks("all");
        Comparator<Task> sortByPriority = Comparator.comparing(Task::getPriority);
        sortAndPrint("All Tasks", tasks, sortByPriority);

        Set<Task> annsTasks = TaskData.getTasks("Ann");
        sortAndPrint("Ann's Tasks", annsTasks, sortByPriority);


        Set<Task> bobsTasks = TaskData.getTasks("Bob");
        sortAndPrint("Bob's Tasks", bobsTasks, sortByPriority);
        Set<Task> carolTasks = TaskData.getTasks("Carol");

        var unionAssigned = getUnion(List.of(annsTasks, bobsTasks, carolTasks));

        sortAndPrint("Union tasks assigned", unionAssigned);

        var unionAll = getUnion(List.of(tasks, annsTasks, bobsTasks, carolTasks));
        sortAndPrint("Union tasks all", unionAll);


        var difference = getDifference(unionAll, unionAssigned);

        sortAndPrint("All Tasks unassigned", difference, sortByPriority);
    }

    private static void sortAndPrint(String header, Collection<Task> collection) {
        sortAndPrint(header, collection, null);
    }


    private static Set<Task> getUnion(List<Set<Task>> set) {
        Set<Task> unionTask = new HashSet<>();
        for (var subset : set) {
            unionTask.addAll(subset);
        }

        return unionTask;
    }


    private static Set<Task> getIntersect(Set<Task> set1, Set<Task> set2) {

        Set<Task> intersectionTasks = new HashSet<>(set1);
        intersectionTasks.containsAll(set2);
        return intersectionTasks;
    }

    private static Set<Task> getDifference(Set<Task> set1, Set<Task> set2) {

        Set<Task> diffTasks = new HashSet<>(set1);
        diffTasks.removeAll(set2);
        return diffTasks;
    }

    private static void sortAndPrint(String header, Collection<Task> collection,
                                     Comparator<Task> sorter) {

        String lineSeparator = "_".repeat(90);
        System.out.println(lineSeparator);
        System.out.println(header);
        System.out.println(lineSeparator);

        List<Task> list = new ArrayList<>(collection);
        list.sort(sorter);
        list.forEach(System.out::println);
    }
}
