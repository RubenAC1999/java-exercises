package exercises.ejercicio1;

// El cliente deberá enviar "ping" y el servidor responder con "pong"

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Client {
    private static final int PORT = 5000;
    private static final String HOST = "localhost";
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

    try (Socket socket = new Socket(HOST, PORT);
         BufferedReader reader = new BufferedReader(
                new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
         PrintWriter writer = new PrintWriter(
                    new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8), true)) {

        System.out.println("Conectado correctamente a: " + socket.getInetAddress());
        String line;

        do {
            System.out.println("Escriba una palabra: ");
            line = SCANNER.nextLine();

            writer.println(line);

            String respuesta = reader.readLine();

            System.out.println(respuesta);

        } while (!line.contains("ping"));

        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }

        }
    }
}
