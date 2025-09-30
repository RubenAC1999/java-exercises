package exercises.ejercicio2;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static final String HOST = "localhost";

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Socket cliente abierto. Escriba el numero de puerto al que desee conectarse: ");
        int port = scanner.nextInt();
        scanner.nextLine();

        try(Socket serverSocket = new Socket(HOST, port);
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(serverSocket.getInputStream()));
            PrintWriter writer = new PrintWriter(
                    new OutputStreamWriter(serverSocket.getOutputStream()), true)) {
            System.out.println("Cliente conectado correctamente a: " + serverSocket.getInetAddress());
            System.out.println("Escriba una palabra o frase para colocar en mayus: ");
            String response = scanner.nextLine();

            writer.println(response);

            System.out.println("Respuesta recibida -> " + reader.readLine());
        }
    }
}
