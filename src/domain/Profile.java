package domain;

public class Profile {
    private String Name;
    private String DateOfBirth;

    public Profile(String name, String dateOfBirth) {
        Name = name;
        DateOfBirth = dateOfBirth;
    }

    public String getName() {
        return Name;
    }
    
}
