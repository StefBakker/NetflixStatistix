package domain;

public class Serie {
    private String title;
    private String genre;
    private String language;
    private String ageIndication;

    public Serie(String title, String genre, String language, String ageIndication) {
        this.title = title;
        this.genre = genre;
        this.language = language;
        this.ageIndication = ageIndication;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public String getLanguage() {
        return language;
    }

    public String getAgeIndication() {
        return ageIndication;
    }
}
