package domain;

public class ExercisegetPercentage {

    private String serieTitle;
    private String episodeNr;
    private String watchedPercentage;

    public ExercisegetPercentage(String serieTitle, String episodeNr, String watchedPercentage) {
        this.serieTitle = serieTitle;
        this.episodeNr = episodeNr;
        this.watchedPercentage = watchedPercentage;
    }

    public String getSerieTitle() {
        return serieTitle;
    }

    public String getEpisodeNr() {
        return episodeNr;
    }

    public String getWatchedPercentage() {
        return watchedPercentage;
    }
}
