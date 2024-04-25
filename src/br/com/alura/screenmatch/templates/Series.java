package br.com.alura.screenmatch.templates;

import br.com.alura.screenmatch.interfaces.Ratable;

public class Series extends Title implements Ratable {
    private int seasons;
    private boolean active;
    private int episodesPerSeason;
    private int minutesPerEpisode;

    public Series(String name, int year) {
        super(name, year);
    }

    public int getSeasons() {
        return seasons;
    }

    public void setSeasons(int seasons) {
        this.seasons = seasons;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getEpisodesPerSeason() {
        return episodesPerSeason;
    }

    public void setEpisodesPerSeason(int episodesPerSeason) {
        this.episodesPerSeason = episodesPerSeason;
    }

    public int getMinutesPerEpisode() {
        return minutesPerEpisode;
    }

    public void setMinutesPerEpisode(int minutesPerEpisode) {
        this.minutesPerEpisode = minutesPerEpisode;
    }

    @Override
    public int getRuntimeInMinutes() {
        return seasons * episodesPerSeason * minutesPerEpisode;
    }

    @Override
    public int getRating() {
        return (int) getAverageRating() / 2;
    }

    @Override
    public String toString() {
        return "Série: " + this.getName() + " (" + this.getYear() + ")";
    }
}
