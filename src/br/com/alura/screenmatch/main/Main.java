package br.com.alura.screenmatch.main;

import br.com.alura.screenmatch.exceptions.CouldNotConvertYearException;
import br.com.alura.screenmatch.templates.Title;
import br.com.alura.screenmatch.templates.OmdbTitle;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner userInput = new Scanner(System.in);
        String filmName = "";
        List<Title> titles = new ArrayList<>();

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        while (!filmName.equalsIgnoreCase("sair")) {
            System.out.println("Digite o filme que deseja buscar ou sair para finalizar:");
            filmName = userInput.nextLine();
            filmName = filmName.replace(" ", "+");

            if (filmName.equalsIgnoreCase("sair")) {
                break;
            }

            String apiUrl = "https://www.omdbapi.com/?t=" + filmName + "&apikey=3dd5799f";

            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(apiUrl))
                        .build();
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());

                String json = response.body();
                System.out.println(json);

                OmdbTitle myOmdbTitle = gson.fromJson(json, OmdbTitle.class);
                System.out.println(myOmdbTitle);


                Title meuTitulo = new Title(myOmdbTitle);
                System.out.println("Título já convertido: ");
                System.out.println(meuTitulo);

                titles.add(meuTitulo);
            } catch (NumberFormatException e) {
                System.out.println("Aconteceu um erro: ");
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Verifique o endereço.");
                System.out.println(e.getMessage());
            } catch (CouldNotConvertYearException e) {
                System.out.println(e.getMessage());
            } finally {
                System.out.println("Finalizou!");
            }
        }
        System.out.println(titles);

        FileWriter writtenFile = new FileWriter("filmes.json");
        writtenFile.write(gson.toJson(titles));
        writtenFile.close();
    }
}
