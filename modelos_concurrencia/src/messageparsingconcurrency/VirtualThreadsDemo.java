package messageparsingconcurrency;

import java.time.Duration;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VirtualThreadsDemo {
    public static void main(String[] args) {
        // También se podría:
        // Thread virtualThread = Thread.ofVirtual().start(() ->

        Thread virtualThread = Thread.startVirtualThread(() ->
                System.out.println("Ejemplo usando virtual thread. " + Thread.currentThread()));

        try {
            virtualThread.join();
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 0; i < 5; i++) {
                int taskId = i;
                executor.submit(() -> System.out.println("Este es el hilo " + taskId + ": "
                        + Thread.currentThread()));
                Thread.sleep(Duration.ofSeconds(1L));
            }
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}
