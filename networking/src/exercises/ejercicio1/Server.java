package exercises.ejercicio1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;

public class Server {
    private static final int PORT = 5000;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        LocalDate hoy = LocalDate.now();
        System.out.println("Server socket creado correctamente.");
        System.out.println("Fecha: " + hoy);
        System.out.println("-----------------------------");

        try (Socket socket = serverSocket.accept();
             BufferedReader reader = new BufferedReader(
                     new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
             PrintWriter writer = new PrintWriter(
                     new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8), true)) {

            System.out.println("Cliente conectado correctamente: " + socket.getInetAddress());

            while (true) {
                System.out.println("Esperando respuesta...");
                String mensaje = reader.readLine();
                System.out.println("El cliente ha escrito --> " + mensaje + "[" + LocalTime.now() + "]");

                if (mensaje.contains("ping")) {
                    writer.println("PONG!");
                    writer.println("Cerrando programa...");
                    break;
                }
                writer.println("Server echo --> " + mensaje);
            }
            serverSocket.close();
        }
    }
    }


