package Domain;

public class Account {

    private String name;
    private String street;
    private String houseNumber;
    private String houseNumberAddition;
    private String residence;

    public Account(String name, String street, String houseNumber, String houseNumberAddition, String residence) {
        this.name = name;
        this.street = street;
        this.houseNumber = houseNumber;
        this.houseNumberAddition = houseNumberAddition;
        this.residence = residence;
    }

    public String getName(){
        return name;
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
