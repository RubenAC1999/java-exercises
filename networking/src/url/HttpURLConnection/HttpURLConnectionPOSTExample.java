package url.HttpURLConnection;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

// Esto usa HTTPUrlConnection, a partir de java 11 se usa HTTPClient para un código más limpio.
// A partir de java 20 se usa URI en vez de URL para que sea más seguro y evitar errores (escaping por ejemplo)

public class HttpURLConnectionPOSTExample {
    public static void main(String[] args) throws URISyntaxException, IOException {
        URL url = new URI("https://httpbin.org/post").toURL();
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("POST");
        connection.setConnectTimeout(5_000);
        connection.setReadTimeout(5_000);
        connection.setDoOutput(true);

        String jsonInput = "{\"name\":\"Juan\", \"age\":25}";

        try(OutputStream outputStream = connection.getOutputStream()) {
            outputStream.write(jsonInput.getBytes(StandardCharsets.UTF_8));
        }

        int status = connection.getResponseCode();
        InputStream inputStream = (status >= 200 && status < 300) ?
                connection.getInputStream()
                : connection.getErrorStream();

        String body;

        if (inputStream != null) {
            try(BufferedReader reader = new BufferedReader(
                    new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
                String line;
                StringBuilder stringBuilder = new StringBuilder();

                while((line = reader.readLine()) != null) {
                    stringBuilder.append(line).append(System.lineSeparator());
                }

                body = stringBuilder.toString();
            }

            System.out.println("Código de respuesta: " + status);
            System.out.println("Respuesta recibida: " + body);

            connection.disconnect();
        }
    }
}
