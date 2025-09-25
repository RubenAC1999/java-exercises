package url.HttpClient;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class HttpClientPOSTExample {
    public static void main(String[] args) throws Exception {

        // Otra manera de hacer el client (aplicando followRedirects para redirecciones código 300).
        HttpClient client = HttpClient.newBuilder()
                .followRedirects(HttpClient.Redirect.NORMAL)
                .build();

        String json = "{\"name\":\"Juan\", \"age\":25}";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://httpbin.org/post"))
                .header("Content-type", "application/json; charset=UTF-8")
                .header("Accept", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(json, StandardCharsets.UTF_8))
                .build();

        HttpResponse<String> response = client.send(
                request, HttpResponse.BodyHandlers.ofString());

        System.out.println("Código de estado: " + response.statusCode());
        System.out.println("Cabeceras: " + response.headers());
        System.out.println("Body: " + response.body());
    }
}
