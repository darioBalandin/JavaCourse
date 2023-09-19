package dev.lpa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapMain {

    public static void main(String[] args) {
        List<Contact> phones = ContactData.getData("phone");

        List<Contact> emails = ContactData.getData("email");

        List<Contact> fullList = new ArrayList<>(phones);

        fullList.addAll(emails);
        fullList.forEach(System.out::println);
        System.out.println("-".repeat(20));

        Map<String, Contact> contacts = new HashMap<>();

        for (var contact : fullList) {
            contacts.put(contact.getName(), contact);

        }

        contacts.forEach((k, v) -> System.out.println("key= " + k + ", value= " + v));
        System.out.println("-".repeat(20));

//        System.out.println(contacts.get("Charlie Brown"));


        contacts.clear();
        for (var contact : fullList) {

            Contact duplicate = contacts.put(contact.getName(), contact);
            if (duplicate != null) {
                contacts.put(contact.getName(), contact.mergeContactData(duplicate));
            }
        }

        contacts.forEach((k, v) -> System.out.println("key= " + k + ", value= " + v));


        System.out.println("-".repeat(20));

        contacts.clear();
        for (var contact : fullList) {
            contacts.putIfAbsent(contact.getName(), contact);

        }

        contacts.forEach((k, v) -> System.out.println("key= " + k + ", value= " + v));


        contacts.clear();
        for (var contact : fullList) {
            var duplicate = contacts.putIfAbsent(contact.getName(), contact);
            if (duplicate != null) {
                contacts.put(contact.getName(), contact.mergeContactData(duplicate));
            }

        }

        contacts.forEach((k, v) -> System.out.println("key= " + k + ", value= " + v));


        contacts.clear();

        fullList.forEach(contact -> contacts.merge(contact.getName(), contact,
                Contact::mergeContactData
        ));


        contacts.forEach((k, v) -> System.out.println("key= " + k + ", value= " + v));
    }


}
