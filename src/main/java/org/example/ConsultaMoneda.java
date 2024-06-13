package org.example;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class ConsultaMoneda {
    Moneda buscaMoneda( String monedaConsultada) {
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/3f74eb3f332f4aa652bdc557/latest/" + monedaConsultada);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .GET()
                .build();

        HttpResponse<String> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (response.statusCode() != 200) {
            throw new RuntimeException("Error en la respuesta de la API: " + response.statusCode());
        }

        return new Gson().fromJson(response.body(), Moneda.class);


    }

}


