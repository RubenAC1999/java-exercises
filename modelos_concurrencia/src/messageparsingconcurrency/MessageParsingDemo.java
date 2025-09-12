package messageparsingconcurrency;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

public class MessageParsingDemo {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> cola = new LinkedBlockingQueue<>();

        Thread productor = new Thread(() -> {
            try {
                cola.put("Mensaje 1");
                cola.put("Mensaje 2");
                cola.put("FIN");

            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        });

        Thread consumidor = new Thread(() -> {
           try {
               String msg;
               while (!(msg = cola.take()).equals("FIN")) {
                   System.out.println("Consumido: " + msg);
               }
           } catch (InterruptedException ex) {
               Thread.currentThread().interrupt();
           }
        });

        productor.start();
        consumidor.start();

        productor.join();
        consumidor.join();
    }
}
