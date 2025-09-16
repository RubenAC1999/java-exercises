import javax.crypto.*;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.sql.SQLOutput;

public class keyPairExample {
    public static void main(String[] args) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        Cipher cipher = Cipher.getInstance("RSA");
        KeyPairGenerator keyPair = KeyPairGenerator.getInstance("RSA");
        keyPair.initialize(2048);
        KeyPair secretKey = keyPair.generateKeyPair();

        cipher.init(Cipher.ENCRYPT_MODE, secretKey.getPublic());

        byte[] plainText = "hola a todos".getBytes(StandardCharsets.UTF_8);
        byte[] cipherText = cipher.doFinal(plainText);
        System.out.println(new String(cipherText));

        cipher.init(Cipher.DECRYPT_MODE, secretKey.getPrivate());
        byte[] textRestored = cipher.doFinal(cipherText);
        System.out.println(new String(textRestored));
    }
}
