
package com.practice;

import java.util.Scanner;

public class AddressBookMain {

    public static final int ADD_CONTACT = 1;
    public static final int VIEW_CONTACT = 2;
    public static final int EDIT_CONTACT = 3;
    public static final int DELETE_CONTACT = 4;
    public static final int SORT_ENTRIES_BY_NAME = 5;
    public static final int SORT_ENTRIES_BY_CITY = 6;
    public static final int SORT_ENTRIES_BY_STATE = 7;
    public static final int SORT_ENTRIES_BY_ZIP = 8;
    public static final int WRITE_TO_FILE = 9;
    public static final int READ_FROM_FILE = 10;
    public static final int EXIT = 11;

    public static void main(String[] args) {
        AddressBookService addressBookManager = new AddressBookService();
        addressBookManager.startAddressBookSystem();
    }

    public static void performAddressBookOperations(AddressBook addressBook, Scanner scanner) {
        while (true) {
            System.out.println("Choose an option: \n1. Add Contact \n2. View Contacts \n3. Edit Contact " +
                    "\n4. Delete Contact \n5. Sort Entries by FirstName \n6. Sort Entries by City \n7. Sort Entries by State \n8. Srot Entries by Zip \n9. Write to file  \n10. Read from file \n11. Back to Main Menu");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case ADD_CONTACT:
                    addressBook.addContact(getInputContact(scanner));
                    break;

                case VIEW_CONTACT:
                    addressBook.viewContacts();
                    break;

                case EDIT_CONTACT:
                    System.out.print("Enter the first name of the contact to edit: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter details of new contact");
                    Contact updateContact = getInputContact(scanner);

                    addressBook.editContact(name, updateContact);
                    break;

                case DELETE_CONTACT:
                    System.out.print("Enter the first name of the contact to delete: ");
                    name = scanner.nextLine();
                    addressBook.deleteContact(name);
                    break;

                case SORT_ENTRIES_BY_NAME:
                    addressBook.sortEntriesByName();
                    break;

                case SORT_ENTRIES_BY_CITY:
                    addressBook.sortEntriesByCity();
                    break;

                case SORT_ENTRIES_BY_STATE:
                    addressBook.sortEntriesByState();
                    break;

                case SORT_ENTRIES_BY_ZIP:
                    addressBook.sortEntriesByZip();
                    break;

                case WRITE_TO_FILE:
                    System.out.println("Enter the file path to write the address book: ");
                    String writeFilePath = scanner.nextLine();
                    addressBook.writeToFile(writeFilePath);
                    break;

                case READ_FROM_FILE:
                    System.out.println("Enter the file path to read the address book: ");
                    String readFilePath = scanner.nextLine();
                    addressBook.readFromFile(readFilePath);
                    break;

                case EXIT:
                    System.out.println("Back to Main Menu");
                    return;

                default:
                    System.out.println("Invalid Input , Please Try Again....");
                    break;
            }
        }
    }

    public static Contact getInputContact(Scanner scanner) {
        System.out.print("First Name : ");
        String firstName = scanner.nextLine();

        System.out.print("Last Name : ");
        String lastName = scanner.nextLine();

        System.out.print("Address : ");
        String address = scanner.nextLine();

        System.out.print("City : ");
        String city = scanner.nextLine();

        System.out.print("Zip : ");
        String zip = scanner.nextLine();

        System.out.print("Phone Number : ");
        String phoneNumber = scanner.nextLine();

        System.out.print("Email : ");
        String email = scanner.nextLine();

        return new Contact(firstName, lastName, address, city, zip, phoneNumber, email);
    }
}
