package org.dario;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Main {

    private static Random random = new Random();

    public static void main(String[] args) {


        String[] names = {"Dario", "Davide", "Daniele", "ana", "maria"};

        List<UnaryOperator<String>> list = new ArrayList<>(List.of(
                String::toUpperCase,
                s -> s +". "+ (char) random.nextInt(66,90),
                Main::reverse
        ));

        applyChanges(names, list);

        Function<String,String> stringFunction = s -> s.concat(" JaJA");

        Function<String,String> other= String::toUpperCase;

        Function<String,String> u2= stringFunction.andThen(other);

        System.out.println(u2.apply("jere"));
    }


    private static String reverse(String s){

        return new StringBuilder(s).reverse().toString();


    }

    private static void applyChanges(String[] names, List<UnaryOperator<String>> stringFunctions) {


        List<String> backedByArray = Arrays.asList(names);

        for (var function : stringFunctions) {
            backedByArray.replaceAll(s -> s.transform(function));
            System.out.println(Arrays.toString(names));
        }
    }

}