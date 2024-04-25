package br.com.alura.screenmatch.main;

import br.com.alura.screenmatch.behavior.TimeCalculator;
import br.com.alura.screenmatch.behavior.RecommendationFilter;
import br.com.alura.screenmatch.templates.Episode;
import br.com.alura.screenmatch.templates.Film;
import br.com.alura.screenmatch.templates.Series;

import java.util.ArrayList;

public class MainTest {
    public static void main(String[] args) {
        Film myFilm = new Film("The Hunger Games", 2012);

        myFilm.rate(8);
        myFilm.rate(10);
        myFilm.rate(7);
        myFilm.rate(5.6);

        myFilm.showDetails();

        Film anotherFilm = new Film("Avatar", 2023);

        Series serie = new Series("How I Met Your Mother", 2005);

        serie.setSeasons(9);
        serie.setEpisodesPerSeason(24);
        serie.setMinutesPerEpisode(25);
        serie.setIncludedInPlan(true);

        serie.rate(8);
        serie.rate(10);
        serie.rate(7);
        serie.rate(7.6);

        serie.showDetails();

        Episode episode = new Episode();
        episode.setEpisodeNumber(1);
        episode.setName("Piloto");
        episode.setSeries(serie);
        episode.setTotalViewers(150);

        TimeCalculator calculator = new TimeCalculator();
        calculator.inclui(myFilm);
        calculator.inclui(anotherFilm);
        calculator.inclui(serie);
        System.out.println(calculator.getTotalTime());

        RecommendationFilter filter = new RecommendationFilter();
        filter.filtra(episode);

        ArrayList<Film> films = new ArrayList<>();
        films.add(myFilm);
        films.add(anotherFilm);
        System.out.println("Tamanho da lista: " + films.size());
        System.out.println(films.get(0).toString());
        System.out.println(films);

    }
}