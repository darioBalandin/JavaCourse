package dev.lpa;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        List<Contact> emails = ContactData.getData("email");
        List<Contact> phones = ContactData.getData("phone");
        printData("Phone List", phones);
        printData("Email List", emails);


        Set<Contact> emailSet = new HashSet<>(emails);
        Set<Contact> phoneSet = new HashSet<>(phones);

        printData("Set phones", phoneSet);
        printData("Set emails", emailSet);

        int index = emails.indexOf(new Contact("Robin Hood"));
        Contact robinHood= emails.get(index);
        robinHood.addEmail("Sherwood Forest");

        System.out.println(robinHood);


        Set<Contact> union= new HashSet<>(emailSet);
        union.addAll(phoneSet);
        printData("Union", union);

        Set<Contact> inters= new HashSet<>(emailSet);
        inters.retainAll(phoneSet);
        printData("interseccion", inters);

        Set<Contact> difference= new HashSet<>(emailSet);
        difference.removeAll(phoneSet);
        printData("asymmetric difference  emailset - phoneset", difference);
    }

    public static void printData(String header, Collection<Contact> contacts) {

        System.out.println("----------------------------------------------");
        System.out.println(header);
        System.out.println("----------------------------------------------");
        contacts.forEach(System.out::println);
    }
}
