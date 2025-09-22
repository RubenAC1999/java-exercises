package sockets;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class EchoServer {
    private static final int PORT = 5000;

    public static void main(String[] args) {
        try(ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Esperando respuesta...");

            try (Socket client = serverSocket.accept();
            BufferedReader inFromClient = new BufferedReader(
                    new InputStreamReader(client.getInputStream(), StandardCharsets.UTF_8));
            PrintWriter outToClient = new PrintWriter(
                    new OutputStreamWriter(client.getOutputStream(), StandardCharsets.UTF_8), true)) {

                System.out.println("Cliente conectado: " + client.getInetAddress());
                outToClient.println("Te has conectado a " + serverSocket.getInetAddress());
               String mensaje = inFromClient.readLine();

               if (mensaje != null && !mensaje.isEmpty()) {
                   System.out.println("Respuesta aceptada: " + mensaje);
               }

            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

}
