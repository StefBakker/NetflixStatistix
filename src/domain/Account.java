package domain;

public class Account {

    private String firstName;
    private String lastName;
    private String street;
    private String houseNumber;
    private String houseNumberAddition;
    private String residence;

    public Account(String firstName, String lastName, String street, String houseNumber, String houseNumberAddition, String residence) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.houseNumber = houseNumber;
        this.houseNumberAddition = houseNumberAddition;
        this.residence = residence;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getStreet(){
        return street;
    }

    public String getHouseNumber(){
        return houseNumber;
    }

    public String getHouseNumberAddition(){
        return houseNumberAddition;
    }
    public String getResidence(){
        return residence;
    }
}
