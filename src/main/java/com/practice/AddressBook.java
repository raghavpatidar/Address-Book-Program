package com.practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddressBook implements Serializable {
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

    public void sortEntriesByName() {

        contacts.sort(Comparator.comparing(Contact::getfirstName));
        System.out.println("Entries sorted alphabetically by Person's Name.");
    }

    public void sortEntriesByCity() {

        contacts.sort(Comparator.comparing(Contact::getCity));
        System.out.println("Entries sorted by City.");
    }

    public void sortEntriesByState() {

        contacts.sort(Comparator.comparing(Contact::getAddress));
        System.out.println("Entries sorted by State.");
    }

    public void sortEntriesByZip() {

        contacts.sort(Comparator.comparing(Contact::getZip));
        System.out.println("Entries sorted by Zip.");
    }

    public void writeToFile(String filePath) {
        try {
            FileOutputStream writeData = new FileOutputStream("data.txt");
            ObjectOutputStream writeStream = new ObjectOutputStream(writeData);

            writeStream.writeObject(contacts);
            writeStream.flush();
            writeStream.close();
            System.out.println("Contacts are write to file: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void readFromFile(String filePath) {
        try {
            FileInputStream readData = new FileInputStream("data.txt");
            ObjectInputStream readStream = new ObjectInputStream(readData);

            ArrayList<Contact> contacts2 = (ArrayList<Contact>) readStream.readObject();
            readStream.close();
            contacts.addAll(contacts2);
            System.out.println(contacts2.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
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
