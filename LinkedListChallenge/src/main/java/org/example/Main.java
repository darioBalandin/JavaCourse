package org.example;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    static boolean flag = true;
    static boolean forward = true;

    public static void main(String[] args) {

        LinkedList<Town> list = new LinkedList<>();
        Town sidney = new Town("Sidney", 0);
        list.addFirst(sidney);
        addPlace(list, new Town("brisbane", 1000));
        addPlace(list, new Town("newton", 100));
        addPlace(list, new Town("melbourne", 200));
        addPlace(list, new Town("perth", 3000));
        addPlace(list, new Town("darwin", 4000));

        System.out.println(list);

        var iterator = list.listIterator();
        Scanner scanner = new Scanner(System.in);

        System.out.println("""
                Avaliable options:
                (F)orward
                (B)ackward
                (L)ist places
                (M)enu
                (Q)uit
                """);

        while (flag) {
            var option = scanner.next().toUpperCase().charAt(0);

            readOption(option, iterator);

        }


    }

    private static void addPlace(LinkedList<Town> list, Town town) {

        for (var element : list) {
            if (element.name().equalsIgnoreCase(town.name())) {
                System.out.println("found duplicate: " + town);
                return;
            }

        }
        var index = 0;
        for (var element : list) {

            if (town.distance() < element.distance()) {
                list.add(index, town);
                return;
            }
            index++;
        }
        list.addLast(town);

    }

    private static void readOption(char option, ListIterator<Town> iterator) {
        if (!iterator.hasPrevious()) {
            System.out.println("Originating : " + iterator.next());
            forward = true;
        }
        if (!iterator.hasNext()) {
            System.out.println("Final : " + iterator.previous());
            forward = false;
        }
        switch (option) {

            case 'F' -> {
                System.out.println("Has elegido la F");
                if (!forward) {
                    forward = true;
                    if (iterator.hasNext()) {
                        iterator.next();
                    }
                }
                if (iterator.hasNext()) {
                    System.out.println("Going to : " + iterator.next());

                }

            }

            case 'B' -> {
                System.out.println("Has elegido la B");

                if (forward) {
                    forward = false;
                    if (iterator.hasPrevious()) {
                        iterator.previous();
                    }
                }
                if (iterator.hasPrevious()) {
                    System.out.println("Going to : " + iterator.previous());
                    forward = false;
                }
            }
            case 'L' -> {
                printPlaces(iterator);
            }
            case 'Q' -> {
                flag = false;
            }

            default -> {
                System.out.println("Opcion incorrecta");
            }


        }
    }

    private static void printPlaces(ListIterator<Town> iterator) {
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
//            System.out.printf("La ciudad %s está a %d de Sidney \n", iterator.next().name(), iterator.next().distance());
        }
    }

}