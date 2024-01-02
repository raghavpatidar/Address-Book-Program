package com.practice;

import java.util.Objects;

class Contact {
    String firstName;
    String lastName;

    public String getLastName() {
        return lastName;
    }

    String address;
    String city;
    String zip;
    String phoneNumber;
    String email;

    public Contact(String firstName, String lastName, String address, String city, String zip, String phoneNumber,
            String email) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", zip='" + zip + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public String getfirstName() {
        return firstName;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Contact other = (Contact) obj;
        if (other.firstName.equalsIgnoreCase(this.firstName)
                && other.lastName.equalsIgnoreCase(this.lastName))
            return true;
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

}