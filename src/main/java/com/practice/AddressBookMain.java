
package com.practice;

import java.util.Scanner;

public class AddressBookMain {

    public static final int ADD_CONTACT = 1;
    public static final int VIEW_CONTACT = 2;
    public static final int EDIT_CONTACT = 3;
    public static final int DELETE_CONTACT = 4;
    public static final int EXIT = 5;

    public static void main(String[] args) {
        AddressBookService addressBookManager = new AddressBookService();
        addressBookManager.startAddressBookSystem();
    }

    public static void performAddressBookOperations(AddressBook addressBook, Scanner scanner) {
        while (true) {
            System.out.println("Choose an option: \n1. Add Contact \n2. View Contacts \n3. Edit Contact " +
                    "\n4. Delete Contact \n5. Back to Main Menu");

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
                    System.out.println("Enter the first name of the contact to edit: ");
                    String name = scanner.nextLine();

                    System.out.println("Enter details of new contact");
                    Contact updateContact = getInputContact(scanner);

                    addressBook.editContact(name, updateContact);
                    break;

                case DELETE_CONTACT:
                    System.out.println("Enter the first name of the contact to delete: ");
                    name = scanner.nextLine();
                    addressBook.deleteContact(name);
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
