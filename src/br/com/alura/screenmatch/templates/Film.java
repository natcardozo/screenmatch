package br.com.alura.screenmatch.templates;

import br.com.alura.screenmatch.interfaces.Ratable;

public class Film extends Title implements Ratable {
    private String director;

    public Film(String name, int year) {
        super(name, year);
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public int getRating() {
        return (int) getAverageRating() / 2;
    }

    @Override
    public String toString() {
        return "Filme: " + this.getName() + " (" + this.getYear() + ")";
    }
}
