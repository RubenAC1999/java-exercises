package exercises.ejercicio4;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static final int PORT = 5000;

    public static void main(String[] args) throws IOException {
       ServerSocket serverSocket = new ServerSocket(PORT);
       System.out.println("Server socket abierto: " + serverSocket.getLocalPort());
       System.out.println("Esperando cliente....");

       try(serverSocket; Socket clientSocket = serverSocket.accept();
       BufferedReader reader = new BufferedReader(
               new InputStreamReader(clientSocket.getInputStream()));
       PrintWriter writer = new PrintWriter(
               new OutputStreamWriter(clientSocket.getOutputStream()), true)) {
           System.out.println("Cliente contectado: " + clientSocket.getInetAddress());
           System.out.println("Esperando respuesta...");

           String line;

           while((line = reader.readLine()) != null) {
               System.out.println("Recibido: " + line);
               writer.println("Mensaje Recibido.");

               if (line.equalsIgnoreCase("exit")) {
                   break;
               }
           }
       }
    }
}
