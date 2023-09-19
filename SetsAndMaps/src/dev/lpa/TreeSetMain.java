package dev.lpa;

import java.util.Comparator;
import java.util.List;
import java.util.NavigableSet;
import java.util.TreeSet;

public class TreeSetMain {
    public static void main(String[] args) {

        List<Contact> phones = ContactData.getData("phone");
        List<Contact> emails = ContactData.getData("email");



//        NavigableSet<Contact> sorted = new TreeSet<>(phones);

        Comparator<Contact> mySort = Comparator.comparing(Contact::getName);
        NavigableSet<Contact> sorted = new TreeSet<>(mySort);


        sorted.addAll(phones);

        sorted.forEach(System.out::println);

        NavigableSet<String> justNames = new TreeSet<>();

        phones.forEach(e -> justNames.add(e.getName()));

        System.out.println(justNames);


        NavigableSet<Contact> fullSet = new TreeSet<>(Comparator.comparing(Contact::getName));
        fullSet.addAll(emails);
        fullSet.forEach(System.out::println);

    }
}
