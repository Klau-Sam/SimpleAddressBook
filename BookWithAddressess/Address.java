package com.company;

public abstract class Address {

    protected String street;
    protected String houseNr;
    protected String flatNr;
    protected String postCode;
    protected String postOffice;

    Address(){};
    Address(String street, String houseNr, String flatNr, String postCode, String postOffice) {
        this.street = street;
        this.houseNr = houseNr;
        this.flatNr = flatNr;
        this.postCode = postCode;
        this.postOffice = postOffice;
    }

    // public address() {}

    public abstract String getStreet();
    public abstract void setStreet(String street);
    public abstract String getPostOffice();
    public abstract void setPostOffice(String postOffice);
    public abstract String getHouseNr();
    public abstract void setHouseNr(String houseNr);
    public abstract String getFlatNr();
    public abstract void setFlatNr(String flatNr);
    public abstract String getPostCode();
    public abstract void setPostCode(String postCode);

}
