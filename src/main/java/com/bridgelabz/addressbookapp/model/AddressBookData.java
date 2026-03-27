package com.bridgelabz.addressbookapp.model;

/**
 * UC3: AddressBookData (Model)
 * Represents an Address Book entry in the system.
 * Contains an auto-generated ID plus address details.
 */
public class AddressBookData {

    private int id;
    private String name;
    private String address;
    private String city;
    private String phoneNumber;

    // Default constructor
    public AddressBookData() {
    }

    // Constructor from DTO
    public AddressBookData(int id, String name, String address, String city, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.city = city;
        this.phoneNumber = phoneNumber;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
        return "AddressBookData{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
