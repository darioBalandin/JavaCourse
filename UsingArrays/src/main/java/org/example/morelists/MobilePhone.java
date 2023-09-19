package org.example.morelists;

import java.util.ArrayList;
import java.util.Objects;

public class MobilePhone {
    // write code here

    private String myNumber;
    private ArrayList<Contact> myContacts;


    public MobilePhone(String phone) {
        myNumber = phone;
        myContacts = new ArrayList<>();
    }

    public boolean addNewContact(Contact contact) {
        if (findContact(contact) >= 0) {
            return true;
        } else {
            myContacts.add(contact);
            return true;
        }

    }

    public boolean updateContact(Contact oldContact, Contact newContact) {

        int position = findContact(oldContact);

        if (position >= 0) {

            myContacts.set(position, newContact);
            return true;
        } else {
            return false;
        }

    }

    public boolean removeContact(Contact contact) {

        int position = findContact(contact);

        if (position >= 0) {
            myContacts.remove(position);
            return true;
        } else {
            return false;
        }

    }

    public int findContact(Contact contact) {

        return myContacts.indexOf(contact);

    }



    public Contact queryContact(String name) {

        for (int i = 0; i < myContacts.size(); i++) {

            if(myContacts.get(i).getName().equals(name)){

                return myContacts.get(i);
            }
        }
        return null;

    }

    public void printContacts() {

        System.out.println("Contact List:");

        for (int i = 0; i < myContacts.size(); i++) {

            System.out.printf("%d. %s -> %s",i,myContacts.get(i).getName(),myContacts.get(i).getPhoneNumber());

        }
    }
}