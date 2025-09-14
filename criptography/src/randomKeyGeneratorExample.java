import javax.crypto.*;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class randomKeyGeneratorExample {
    public static void main(String[] args) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        String algorightm = "AES";
        Cipher cipher = Cipher.getInstance(algorightm);
        KeyGenerator keyGenerator = KeyGenerator.getInstance(algorightm);
        SecureRandom secureRandom = new SecureRandom();
        int keyBiteSize = 256;

        keyGenerator.init(keyBiteSize, secureRandom);
        SecretKey secretKey = keyGenerator.generateKey();

        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        byte[] plainText = "abcdefghijklmnopqrstuvwxyz".getBytes(StandardCharsets.UTF_8);
        byte[] cipherText = cipher.doFinal(plainText);

        System.out.println(new String(plainText, StandardCharsets.UTF_8));
        System.out.println(new String(cipherText, StandardCharsets.UTF_8));
    }
}
