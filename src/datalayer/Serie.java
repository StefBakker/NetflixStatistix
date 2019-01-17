package datalayer;

public class Serie {
    private int seriesID;
    private int minAge;
    private String title;
    private String language;
    private String genre;
    private int sharedAmountCompleted;
    private String[] associations;
    private int amountOfEpisodes;

    public int getMinAge() {
        return minAge;
    }

    public String getTitle() {
        return title;
    }

    public String getLanguage() {
        return language;
    }

    public String getGenre() {
        return genre;
    }

    public int getSharedAmountCompleted() {
        return sharedAmountCompleted;
    }

    public int getAmountOfEpisodes() {
        return amountOfEpisodes;
    }


}


