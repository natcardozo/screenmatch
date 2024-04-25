package br.com.alura.screenmatch.behavior;

import br.com.alura.screenmatch.interfaces.Ratable;

public class RecommendationFilter {
    public void filtra(Ratable ratable) {
        if (ratable.getRating() >= 4) {
            System.out.println("Está entre os preferidos do momento");
        } else if (ratable.getRating() >= 2) {
            System.out.println("Muito bem avaliado no momento!");
        } else {
            System.out.println("Coloque na sua lista para assistir depois");
        }
    }
}
