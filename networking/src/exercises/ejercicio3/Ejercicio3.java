    package exercises.ejercicio3;

    import java.net.URI;
    import java.net.http.HttpClient;
    import java.net.http.HttpRequest;
    import java.net.http.HttpResponse;
    import java.nio.charset.StandardCharsets;
    import java.time.Duration;

    public class Ejercicio3 {
        public static void main(String[] args) throws Exception {
            HttpClient client = HttpClient.newBuilder()
                    .connectTimeout(Duration.ofSeconds(10))
                    .followRedirects(HttpClient.Redirect.NORMAL)
                    .version(HttpClient.Version.HTTP_1_1)
                    .build();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://example.org"))
                    .timeout(Duration.ofSeconds(15))
                    .header("Accept", "text/html")
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(
                    request, HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8));

            System.out.println("Código de estado: " + response.statusCode());
            System.out.println("body: " +   response.body());
        }
    }
