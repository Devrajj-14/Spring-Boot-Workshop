package com.bridgelabz.addressbookapp.dto;

/**
 * UC3: AddressBookDTO
 * Data Transfer Object for receiving/sending address book data from/to client.
 * Contains fields for the address book entry.
 */
public class AddressBookDTO {

    private String name;
    private String address;
    private String city;
    private String phoneNumber;

    // Default constructor
    public AddressBookDTO() {
    }

    // Parameterized constructor
    public AddressBookDTO(String name, String address, String city, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.phoneNumber = phoneNumber;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "AddressBookDTO{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
