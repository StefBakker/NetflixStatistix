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

    public void setName(String name) {
        Name = name;
    }

    public String getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }
}
