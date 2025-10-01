package exercises.ejercicio4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static final String HOST = "localhost";
    private static final int PORT = 5000;
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        try(Socket socket = new Socket(HOST, PORT);
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
        PrintWriter writer = new PrintWriter(
                new OutputStreamWriter(socket.getOutputStream()), true)) {
            System.out.println("Conectado al servidor!");

            String response;
            do {
                System.out.println("Introduzca el mensaje a enviar (exit para salir): ");
                response = SCANNER.nextLine();
                writer.println(response);

                System.out.println(reader.readLine());


            } while (!response.equalsIgnoreCase("exit"));

            System.out.println("Cerrando conexión...");
            System.exit(0);
        }
    }
}
