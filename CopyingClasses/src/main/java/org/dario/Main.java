package org.dario;


import java.util.Arrays;

record Person(String name, String dob) {
}

public class Main {
    public static void main(String[] args) {

        Person joe = new Person("joe", "erwe3");
        Person jacke = new Person("jacke", "ejsad");
        Person henry = new Person("henry", "erwe3");
        Person javier = new Person("javier", "erwe3");
        Person rob = new Person("rob", "erwe3");

        Person[] persons = {joe, jacke, henry, javier, rob};
        Person[] personsCopy = Arrays.copyOf(persons, persons.length);


        for (int i = 0; i < 5; i++) {

            if (persons[i] == personsCopy[i]){
                System.out.println( );
            }
        }

        System.out.println("Hello world!");
    }
}