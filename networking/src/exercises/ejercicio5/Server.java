package exercises.ejercicio5;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.Duration;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    private static final int PORT = 5000;
    private static final int THREAD_POOL_SIZE = 10;

    public static void main(String[] args) throws Exception {
        ExecutorService pool = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        try(ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Servidor escuchando en " + PORT);

            while(true) {
                Socket socket = server.accept();
                System.out.println("Cliente conectado: " + socket.getRemoteSocketAddress());
                Thread thread = new Thread(new ClientHandler (socket));

                thread.start();

            }
        }
    }

    static class ClientHandler implements Runnable {
        private final Socket socket;

        ClientHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            System.out.println("Cliente conectado: " + socket.getRemoteSocketAddress());
            try {
                Thread.sleep(Duration.ofSeconds(new Random().nextInt(10)));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


            try(socket;
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(
                    new OutputStreamWriter(socket.getOutputStream()), true)) {
                writer.println("--> Cliente conectado [" + Thread.currentThread() + "]");


            } catch (IOException exception) {
                System.err.println(exception.getMessage());
            }
        }
    }
}
