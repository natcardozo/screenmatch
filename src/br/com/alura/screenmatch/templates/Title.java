package br.com.alura.screenmatch.templates;

import br.com.alura.screenmatch.exceptions.CouldNotConvertYearException;

public class Title implements Comparable<Title> {
    private String name;
    private int year;
    private boolean includedInPlan;
    private double ratingSum;
    private int ratingTotal;
    private int runtimeInMinutes;

    public Title(String name, int year) {
        this.name = name;
        this.year = year;
    }

    public Title(OmdbTitle meuTituloOmdb) {
        this.name = meuTituloOmdb.title();
        if (meuTituloOmdb.year().length() > 4) {
            throw new CouldNotConvertYearException("Não consegui converter o ano porque tem mais de 4 caracteres.");
        }
        this.year = Integer.valueOf(meuTituloOmdb.year());
        this.runtimeInMinutes = Integer.valueOf(meuTituloOmdb.runtime().substring(0,2));
    }

    int getRatingTotal() {
        return ratingTotal;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setRuntimeInMinutes(int runtimeInMinutes) {
        this.runtimeInMinutes = runtimeInMinutes;
    }

    public void setIncludedInPlan(boolean includedInPlan) {
        this.includedInPlan = includedInPlan;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public boolean isIncludedInPlan() {
        return includedInPlan;
    }

    public int getRuntimeInMinutes() {
        return runtimeInMinutes;
    }

    public void showDetails() {
        System.out.println("Título: " + name);
        System.out.println("Ano de lançamento: " + year);
        System.out.println("Duração: " + getRuntimeInMinutes() + " minutos");
        System.out.println("Avaliação: " + getAverageRating() + " de " + getRatingTotal() + " usuários");
        System.out.println("Incluído no plano: " + includedInPlan);
    }

    public void rate(double nota) {
        ratingSum += nota;
        ratingTotal++;
    }

    double getAverageRating() {
        return ratingSum / ratingTotal;
    }

    @Override
    public int compareTo(Title secondTitle) {
        return this.getName().compareTo(secondTitle.getName());
    }

    @Override
    public String toString() {
        return "(nome = '" + name + '\'' +
                ", anoDeLancamento = " + year +
                ", duracaoEmMinutos = " + runtimeInMinutes + ")";
    }
}
