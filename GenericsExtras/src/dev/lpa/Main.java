package dev.lpa;


import dev.lpa.model.LPAStudent;
import dev.lpa.model.LPAStudentComparator;
import dev.lpa.util.QueryList;

import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {

        QueryList<LPAStudent> queryList = new QueryList<>();

        for (int i = 0; i < 50; i++) {
            queryList.add(new LPAStudent());
        }
        System.out.println("Ordered");
        queryList.sort(Comparator.naturalOrder());
        printList(queryList);

        System.out.println("Matches");

        var matches = queryList.getMatches("Course", "Python");
        matches.sort(new LPAStudentComparator());
        printList(matches);
        System.out.println("Ordered");

        matches.sort(null);
        printList(matches);
        Consumer<String> asr = (String st) -> {
            var elements = st.split(" ");
            for (var e : elements) {
                System.out.println(e);
            }
        };

        asr.accept("HLA que ytal stas");


        Function<String, String> fise = source -> {
            var returnVal = new StringBuilder();
            for (int i = 0; i < source.length(); i++) {

                if (i % 2 == 1) {
                    returnVal.append(source.charAt(i));
                }
            }
            return returnVal.toString();
        };


        System.out.println(execLam(fise, "v9vhfdjvndf9vhdf9v8h"));


        Supplier<String> iLoveJava = () -> "I Love Java";
        var supResult= iLoveJava.get();
        System.out.println(supResult);

    }

    public static String execLam(Function<String, String> func, String sent) {

        return func.apply(sent);
    }

    public static void printList(List<?> students) {

        for (var student : students) {
            System.out.println(student);
        }

    }

}
