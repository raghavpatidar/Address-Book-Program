package com.practice;

import java.util.ArrayList;

public class AddressBook {

    ArrayList<Contact> contacts;

    public AddressBook() {
        this.contacts = new ArrayList<>();
    }

    public void addContact(Contact contact) {
        this.contacts.add(contact);
    }

    public void viewContacts() {
        for (Contact contact : contacts) {
            System.out.println(contact);
        }
    }

    public void editContact(String name, Contact updatedContact) {
        for (int i = 0; i < contacts.size(); i++) {

            Contact contact = contacts.get(i);
            if (contact.getfirstName().equalsIgnoreCase(name)) {
                contacts.set(i, updatedContact);
                return;
            }
        }
        System.out.println("Contact Not Found");
    }

}
