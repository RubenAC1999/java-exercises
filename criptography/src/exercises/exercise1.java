package exercises;

// Calcular un hash usando SHA-256 e imprimir el resultado en formato hexadecimal

import java.net.StandardSocketOptions;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class exercise1 {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) throws NoSuchAlgorithmException {
        System.out.println("Introduzca el mensaje que desee hashear: ");
        String message = SCANNER.nextLine();

        MessageDigest digest = MessageDigest.getInstance("SHA-256");

        byte[] messsageHash = digest.digest(message.getBytes(StandardCharsets.UTF_8));
        StringBuilder hexString = new StringBuilder(2 * messsageHash.length);

        System.out.println("Mensaje recibido: " + message);
        System.out.println("Mensaje encriptado: " + new String(messsageHash));

    }
}
