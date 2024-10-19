
import Monedas.Monedas;
import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultarMoneda {
    public Monedas buscarMonedas(String monedaBase) {
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/ea023aa44e7b79e65e4ff361/latest/" + monedaBase);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Manejo de respuesta no exitosa
            if (response.statusCode() != 200) {
                throw new RuntimeException("Error al consultar la API: " + response.body());
            }

            return new Gson().fromJson(response.body(), Monedas.class);
        } catch (Exception e) {
            throw new RuntimeException("No se pudo obtener la información de la moneda: " + e.getMessage());
        }
    }
}
