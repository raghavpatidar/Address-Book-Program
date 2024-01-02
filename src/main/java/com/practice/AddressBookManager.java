package com.practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddressBookManager {
    private Map<String, AddressBook> addressBooks;
    public static final int ADD_ADDRESS_BOOK = 1;
    public static final int SELECT_ADDRESS_BOOK = 2;
    public static final int EXIT_ADDRESS_BOOK = 3;

    AddressBookManager() {
        addressBooks = new HashMap<>();
    }

    public void startAddressBookSystem() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Address Book System");

        boolean isExit = false;

        while (true) {
            System.out.println("Choose an option: \n1. Add Address Book \n2. Select Address Book \n3. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case ADD_ADDRESS_BOOK:
                    addAddressBook(scanner);
                    break;

                case SELECT_ADDRESS_BOOK:
                    selectAddressBook(scanner);
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
        System.out.println("Enter the name of the new Address Book: ");
        String addressBookName = scanner.nextLine();
        addressBooks.put(addressBookName, new AddressBook(addressBookName));
        System.out.println("Address Book added successfully");
    }

    private void selectAddressBook(Scanner scanner) {
        System.out.println("Enter the name of the Address Book: ");
        String selectedAddressBookName = scanner.nextLine();
        AddressBook selectedAddressBook = addressBooks.get(selectedAddressBookName);
        if (selectedAddressBook != null) {
            AddressBookMain.performAddressBookOperations(selectedAddressBook, scanner);
        } else {
            System.out.println("Address Book not found");
        }
    }

}
