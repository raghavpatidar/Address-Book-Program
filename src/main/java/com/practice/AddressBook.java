package com.practice;

import java.util.ArrayList;

public class AddressBook {
    private String name;

    ArrayList<Contact> contacts;

    public ArrayList<Contact> getContacts() {
        return contacts;
    }

    public AddressBook(String name) {
        this.name = name;
        this.contacts = new ArrayList<>();
    }

    public void addContact(Contact contact) {
        if (isDuplicate(contact)) {
            System.out.println("Contact Already Present");
            return;
        }
        this.contacts.add(contact);
        System.out.println("Contact added successfully");
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
                System.out.println("Contact update successfully");
                return;
            }
        }
        System.out.println("Contact not found");
    }

    public void deleteContact(String name) {
        for (int i = 0; i < contacts.size(); i++) {
            Contact contact = contacts.get(i);
            if (contact.getfirstName().equalsIgnoreCase(name)) {
                contacts.remove(i);
                System.out.println("Contact deleted successfully");
            }
        }
        System.out.println("Contact not found");

    }

    public boolean isDuplicate(Contact contact) {
        for (Contact c : contacts)
            if (c.equals(contact))
                return true;

        return false;
    }

    public String getName() {
        return name;
    }
}
