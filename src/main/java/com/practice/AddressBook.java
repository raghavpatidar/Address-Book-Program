package com.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddressBook {
    private String name;

    private ArrayList<Contact> contacts;

    private Map<String, List<Contact>> cityPersonMap;
    private Map<String, List<Contact>> statePersonMap;

    public AddressBook(String name) {
        this.name = name;
        this.contacts = new ArrayList<>();
        this.cityPersonMap = new HashMap<>();
        this.statePersonMap = new HashMap<>();
    }

    public void addContact(Contact contact) {
        if (isDuplicate(contact)) {
            System.out.println("Contact Already Present");
            return;
        }
        this.contacts.add(contact);
        updateCityStateMap(contact);
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

    public void updateCityStateMap(Contact contact) {
        String city = contact.getCity().toLowerCase();

        cityPersonMap.computeIfAbsent(city, k -> new ArrayList<>()).add(contact);

        String state = contact.getAddress().toLowerCase();
        statePersonMap.computeIfAbsent(state, k -> new ArrayList<>()).add(contact);
    }

    public String getName() {
        return name;
    }

    public Map<String, List<Contact>> getCityPersonMap() {
        return cityPersonMap;
    }

    public Map<String, List<Contact>> getStatePersonMap() {
        return statePersonMap;
    }

    public ArrayList<Contact> getContacts() {
        return contacts;
    }
}
