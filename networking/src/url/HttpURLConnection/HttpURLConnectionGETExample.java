package url.HttpURLConnection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;
import java.nio.charset.StandardCharsets;

// Esto usa HTTPUrlConnection, a partir de java 11 se usa HTTPClient para un código más limpio.
// A partir de java 20 se usa URI en vez de URL para que sea más seguro y evitar errores (escaping por ejemplo)

public class HttpURLConnectionGETExample {
    public static void main(String[] args) throws IOException, URISyntaxException {
        URL url = new URI("https://catfact.ninja/fact").toURL();
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("GET");
        connection.setRequestProperty("Accept", "application/json; charset=UTF-8");
        connection.setConnectTimeout(5_000);
        connection.setReadTimeout(5_000);
        StringBuilder response = new StringBuilder();

        try {
            int status = connection.getResponseCode();

            InputStream bodyStream = (status >= 200 && status < 300) ?
                    connection.getInputStream()
                    : connection.getErrorStream();

            if (bodyStream != null) {
                try (BufferedReader in = new BufferedReader(
                        new InputStreamReader(bodyStream, StandardCharsets.UTF_8))) {
                    String line;

                    while ((line = in.readLine()) != null) {
                        response.append(line).append(System.lineSeparator());

                    }
                }

                System.out.println("Código de respuesta: " + status);
                System.out.println("Respuesta recibida: " + response);
            }
        } finally {
            connection.disconnect();
        }
    }
}
