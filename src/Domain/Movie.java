package Domain;

public class Movie {

    private String ProgramTitle;
    private String Genre;
    private String Language;
    private String ageIndication;

    public Movie(String programTitle, String genre, String language, String ageIndication) {
        ProgramTitle = programTitle;
        Genre = genre;
        Language = language;
        this.ageIndication = ageIndication;
    }

    public String getProgramTitle(){
        return this.ProgramTitle;
    }

    public String getGenre(){
        return this.Genre;
    }

    public String getLanguage(){
        return this.Language;
    }

    public String getAgeIndication(){
        return this.ageIndication;
    }

}



