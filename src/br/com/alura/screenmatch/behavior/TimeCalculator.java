package br.com.alura.screenmatch.behavior;

import br.com.alura.screenmatch.templates.Title;

public class TimeCalculator {
    private int totalTime;

    public int getTotalTime() {
        return totalTime;
    }

    public void inclui (Title titulo) {
        totalTime += titulo.getRuntimeInMinutes();
    }
}
