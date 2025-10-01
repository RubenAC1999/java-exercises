package exercises.ejercicio5;

import java.io.*;
import java.net.Socket;

public class Client {
    private static final String HOST = "localhost";
    private static final int PORT = 5000;

    public static void main(String[] args) throws IOException {
     try(Socket socket = new Socket(HOST, PORT);
     BufferedReader reader = new BufferedReader(
             new InputStreamReader(socket.getInputStream()));
     PrintWriter writer = new PrintWriter(
             new OutputStreamWriter(socket.getOutputStream()), true)) {

         System.out.println("Conectado al servidor");

     }
    }
}
