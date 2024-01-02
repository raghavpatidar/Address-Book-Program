// // package com.practice;

// // import java.util.Scanner;

// // public class AddressBookMain {

// // public static final int ADD_CONTACT = 1;
// // public static final int VIEW_CONTACT = 2;
// // public static final int EDIT_CONTACT = 3;
// // public static final int DELETE_CONTACT = 4;
// // public static final int EXIT = 5;

// // public static void main(String[] args) {

// //     System.out.println("Welcome to Address Book Program");
// //     AddressBook addressBook = new AddressBook();

// //     Scanner scanner = new Scanner(System.in);
// //     boolean isExit = false;

// //     while (true) {
// //         System.out.println(
// //                 "Choose an option: \n1. Add Contact \n2. View Contacts \n3. Edit Contact \n4. Delete Contact \n5.Exit");

// //         int choice = scanner.nextInt();
// //         scanner.nextLine();

// //         switch (choice) {
// //             case ADD_CONTACT:
// //                 addressBook.addContact(getInputContact(scanner));
// //                 break;

// //             case VIEW_CONTACT:
// //                 addressBook.viewContacts();
// //                 break;

// //             case EDIT_CONTACT:
// //                 System.out.println("Enter the first name of the contact to edit: ");
// //                 String name = scanner.nextLine();

// //                 System.out.println("Enter details of new contact");
// //                 Contact updateContact = getInputContact(scanner);

// //                 addressBook.editContact(name, updateContact);
// //                 break;

// //             case DELETE_CONTACT:
// //                 System.out.println("Enter the first name of the contact to delete: ");
// //                 name = scanner.nextLine();
// //                 addressBook.deleteContact(name);
// //                 break;

// //             case EXIT:
// //                 isExit = true;
// //                 System.out.println("Exit Address Book");
// //                 break;

// //             default:
// //                 System.out.println("Invalid Input , Please Try Again....");
// //                 break;
// //         }
// //         if (isExit)
// //             break;
// //     }
// //     scanner.close();

// // }

// package com.practice;

// import java.util.*;

// public class AddressBookMain {

//     public static final int ADD_CONTACT = 3;
//     public static final int VIEW_CONTACT = 4;
//     public static final int EDIT_CONTACT = 5;
//     public static final int DELETE_CONTACT = 6;
//     public static final int EXIT = 7;

//     public static void main(String[] args) {

//         System.out.println("Welcome to Address Book System");

//         Map<String, AddressBook> addressBooks = new HashMap<>();
//         Scanner scanner = new Scanner(System.in);
//         boolean isExit = false;

//         while (true) {
//             System.out.println("Choose an option: \n1. Add Address Book \n2. Select Address Book \n3. Add Contact " +
//                     "\n4. View Contacts \n5. Edit Contact \n6. Delete Contact \n7. Exit");

//             int choice = scanner.nextInt();
//             scanner.nextLine();

//             switch (choice) {
//                 case ADD_ADDRESS_BOOK:
//                     System.out.println("Enter the name of the new Address Book: ");
//                     String addressBookName = scanner.nextLine();
//                     addressBooks.put(addressBookName, new AddressBook(addressBookName));
//                     System.out.println("Address Book added successfully");
//                     break;

//                 case SELECT_ADDRESS_BOOK:
//                     System.out.println("Enter the name of the Address Book: ");
//                     String selectedAddressBookName = scanner.nextLine();
//                     AddressBook selectedAddressBook = addressBooks.get(selectedAddressBookName);
//                     if (selectedAddressBook != null) {
//                         performAddressBookOperations(selectedAddressBook, scanner);
//                     } else {
//                         System.out.println("Address Book not found");
//                     }
//                     break;

//                 case EXIT:
//                     isExit = true;
//                     System.out.println("Exit Address Book System");
//                     break;

//                 default:
//                     System.out.println("Invalid Input, Please Try Again....");
//                     break;
//             }
//             if (isExit)
//                 break;
//         }
//         scanner.close();
//     }

//     private static void performAddressBookOperations(AddressBook addressBook, Scanner scanner) {
//         while (true) {
//             System.out.println("Choose an option: \n1. Add Contact \n2. View Contacts \n3. Edit Contact " +
//                     "\n4. Delete Contact \n5. Back to Main Menu");

//             int choice = scanner.nextInt();
//             scanner.nextLine();

//             switch (choice) {
//                 case ADD_CONTACT:
//                     addressBook.addContact(getInputContact(scanner));
//                     break;

//                 case VIEW_CONTACT:
//                     addressBook.viewContacts();
//                     break;

//                 case EDIT_CONTACT:
//                     System.out.println("Enter the first name of the contact to edit: ");
//                     String name = scanner.nextLine();

//                     System.out.println("Enter details of new contact");
//                     Contact updateContact = getInputContact(scanner);

//                     addressBook.editContact(name, updateContact);
//                     break;

//                 case DELETE_CONTACT:
//                     System.out.println("Enter the first name of the contact to delete: ");
//                     name = scanner.nextLine();
//                     addressBook.deleteContact(name);
//                     break;

//                 case EXIT:
//                     System.out.println("Back to Main Menu");
//                     return;

//                 default:
//                     System.out.println("Invalid Input , Please Try Again....");
//                     break;
//             }
//         }
//     }

//     // remaining methods unchanged

//     public static Contact getInputContact(Scanner scanner) {
//         System.out.print("First Name : ");
//         String firstName = scanner.nextLine();

//         System.out.print("Last Name : ");
//         String lastName = scanner.nextLine();

//         System.out.print("Address : ");
//         String address = scanner.nextLine();

//         System.out.print("City : ");
//         String city = scanner.nextLine();

//         System.out.print("Zip : ");
//         String zip = scanner.nextLine();

//         System.out.print("Phone Number : ");
//         String phoneNumber = scanner.nextLine();

//         System.out.print("Email : ");
//         String email = scanner.nextLine();

//         Contact contact = new Contact(firstName, lastName, address, city, zip, phoneNumber, email);
//         return contact;

//     }

// }
package com.practice;

import java.util.Scanner;

public class AddressBookMain {

    public static final int ADD_CONTACT = 1;
    public static final int VIEW_CONTACT = 2;
    public static final int EDIT_CONTACT = 3;
    public static final int DELETE_CONTACT = 4;
    public static final int EXIT = 5;

    public static void main(String[] args) {
        AddressBookManager addressBookManager = new AddressBookManager();
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
