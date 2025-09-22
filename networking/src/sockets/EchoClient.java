package sockets;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class EchoClient {
    private static final String HOST = "localhost";
    private static final int PORT = 5000;
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        try(Socket socket = new Socket(HOST, PORT);
            BufferedReader inFromServer = new BufferedReader(
                    new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
            PrintWriter outToSever = new PrintWriter(
                    new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8), true)) {

            System.out.println("Conectado al servidor " + socket.getInetAddress());
            System.out.println(inFromServer.readLine());

            System.out.println("Escribe el mensaje que quieras enviar al servidor: ");
            String mensaje = SCANNER.nextLine();

            outToSever.println(mensaje);
            System.out.println("Mensaje enviado: " + mensaje);


        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
