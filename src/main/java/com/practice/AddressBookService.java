package com.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AddressBookService {
    private Map<String, AddressBook> addressBooks;
    public static final int ADD_ADDRESS_BOOK = 1;
    public static final int SELECT_ADDRESS_BOOK = 2;
    public static final int SEARCH_PERSON_IN_CITY_OR_STATE = 3;
    public static final int VIEW_PERSON_CITY_OR_STATE = 4;
    public static final int EXIT_ADDRESS_BOOK = 5;

    AddressBookService() {
        addressBooks = new HashMap<>();
    }

    public void startAddressBookSystem() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Address Book System");

        boolean isExit = false;

        while (true) {
            System.out.println(
                    "Choose an option: \n1. Add Address Book \n2. Select Address Book \n3. Search Person in City or State \n4. View person in city of state \n5. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case ADD_ADDRESS_BOOK:
                    addAddressBook(scanner);
                    break;

                case SELECT_ADDRESS_BOOK:
                    selectAddressBook(scanner);
                    break;

                case SEARCH_PERSON_IN_CITY_OR_STATE:
                    System.out.print("Enter City of State name : ");
                    String stateOrCity = scanner.nextLine();
                    searchPersonInCityOrState(stateOrCity);
                    break;

                case VIEW_PERSON_CITY_OR_STATE:
                    viewPersonsByCityOrState(scanner);
                    break;

                case EXIT_ADDRESS_BOOK:
                    isExit = true;
                    System.out.println("Exit Address Book System");
                    break;

                default:
                    System.out.println("Invalid Input, Please Try Again....");
                    break;
            }

            if (isExit)
                break;
        }

        scanner.close();
    }

    private void addAddressBook(Scanner scanner) {
        System.out.print("Enter the name of the new Address Book: ");
        String addressBookName = scanner.nextLine();
        addressBooks.put(addressBookName, new AddressBook(addressBookName));
        System.out.println("Address Book added successfully");
    }

    private void selectAddressBook(Scanner scanner) {
        System.out.print("Enter the name of the Address Book: ");
        String selectedAddressBookName = scanner.nextLine();
        AddressBook selectedAddressBook = addressBooks.get(selectedAddressBookName);
        if (selectedAddressBook != null) {
            AddressBookMain.performAddressBookOperations(selectedAddressBook, scanner);
        } else {
            System.out.println("Address Book not found");
        }
    }

    public void searchPersonInCityOrState(String cityOrState) {
        for (AddressBook addressBook : addressBooks.values()) {
            for (Contact contact : addressBook.getContacts()) {
                if (contact.getAddress().equalsIgnoreCase(cityOrState)
                        || contact.getCity().equalsIgnoreCase(cityOrState)) {
                    System.out.println(addressBook.getName() + " " + contact);
                }
            }
        }
    }

    public void viewPersonsByCityOrState(Scanner scanner) {
        System.out.println("Choose an option: \n1. View Persons by City \n2. View Persons by State");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                viewPersonsByDictionary(1, scanner);
                break;

            case 2:
                viewPersonsByDictionary(2, scanner);
                break;

            default:
                System.out.println("Invalid Input, Please Try Again....");
                break;
        }
    }

    private void viewPersonsByDictionary(int type, Scanner scanner) {

        System.out.print("Enter the city or state: ");
        String location = scanner.nextLine();
        location = location.toLowerCase();
        boolean found = false;

        for (AddressBook addressBook : addressBooks.values()) {
            Map<String, List<Contact>> map;
            if (type == 1)
                map = addressBook.getCityPersonMap();
            else
                map = addressBook.getStatePersonMap();

            if (map.containsKey(location))
                for (Contact contact : map.get(location)) {
                    found = true;
                    System.out.println(addressBook.getName() + " --> " + contact);
                }

        }

        if (!found) {
            System.out.println("No contact Found");
        }
    }

}
