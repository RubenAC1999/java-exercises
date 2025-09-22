package url;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpGetExample {
    public static void main(String[] args) throws IOException {
       URL url = new URL("https://catfact.ninja/fact");
       HttpURLConnection connection = (HttpURLConnection) url.openConnection();
    }
}
