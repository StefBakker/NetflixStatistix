package domain;

public class Exercise1 {

    private String serieTitle;
    private String episodeNr;
    private String watchedPercentage;

    public Exercise1(String serieTitle, String episodeNr, String watchedPercentage) {
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
