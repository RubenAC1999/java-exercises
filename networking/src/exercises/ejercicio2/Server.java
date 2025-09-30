package exercises.ejercicio2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static final int PORT = 1024;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);

        try (serverSocket; Socket clientSocket = serverSocket.accept();
             BufferedReader reader = new BufferedReader(
                     new InputStreamReader(clientSocket.getInputStream()));
             PrintWriter writer = new PrintWriter(
                     new OutputStreamWriter(clientSocket.getOutputStream()), true)) {
            System.out.println("Server socket abierto: " + serverSocket.getInetAddress());
            System.out.println("Esperando cliente...");

            System.out.println("Cliente conectado [" + clientSocket.getInetAddress() + "]");
            System.out.println("Esperando respuesta...");
            String line;

            while((line = reader.readLine()) != null) {
                System.out.println("Mensaje del cliente -> " + line);
                writer.println(line.toUpperCase());
            }
        }
    }
}
