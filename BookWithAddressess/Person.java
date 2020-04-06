package com.company;

public class Person extends Address {

    private String name;
    private String surname;
    private String phone;
    private Address Add;

    Person(){};
    Person(String name, String surname, String phone, String street, String houseNr, String flatNr, String postCode, String postOffice) {
        super(street, houseNr, flatNr, postCode, postOffice);
        this.name = name;
        this.surname = surname;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) { super.street = street; }

    public String getPostOffice() {
        return postOffice;
    }

    public void setPostOffice(String postOffice) {
        super.postOffice = postOffice;
    }

    public String getHouseNr() {
        return houseNr;
    }

    public void setHouseNr(String houseNr) {
        super.houseNr = houseNr;
    }

    public String getFlatNr() {
        return flatNr;
    }

    public void setFlatNr(String flatNr) {
        super.flatNr = flatNr;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        super.postCode = postCode;
    }

}
