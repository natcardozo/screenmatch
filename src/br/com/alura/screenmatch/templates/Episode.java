package br.com.alura.screenmatch.templates;

import br.com.alura.screenmatch.interfaces.Ratable;

public class Episode implements Ratable {
    private int episodeNumber;
    private String name;
    private Series series;
    int totalViewers;

    public int getEpisodeNumber() {
        return episodeNumber;
    }

    public void setEpisodeNumber(int episodeNumber) {
        this.episodeNumber = episodeNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Series getSeries() {
        return series;
    }

    public void setSeries(Series series) {
        this.series = series;
    }

    public int getTotalViewers() {
        return totalViewers;
    }

    public void setTotalViewers(int totalViewers) {
        this.totalViewers = totalViewers;
    }

    @Override
    public int getRating() {
        if (totalViewers > 100) {
            return 4;
        } else {
            return 2;
        }
    }
}
