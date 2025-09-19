import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.util.Base64;

public class secretKeySpecExample {
    public static void main(String[] args) throws NoSuchPaddingException, NoSuchAlgorithmException,
             InvalidKeyException, IllegalBlockSizeException, BadPaddingException {

        // PROCESO PARA GENERAR UNA KEY Y ALMACENARLA EN BASE DE DATOS
        String algorithm = "AES";
        byte[] plainText = "datos a encriptar".getBytes(StandardCharsets.UTF_8);
        Cipher cipher = Cipher.getInstance(algorithm);
        KeyGenerator keyGenerator = KeyGenerator.getInstance(algorithm);
        SecureRandom secureRandom = new SecureRandom();
        int KEYBYTESIZE = 256;

        keyGenerator.init(KEYBYTESIZE, secureRandom);

        SecretKey generatedKey = keyGenerator.generateKey();

        cipher.init(Cipher.ENCRYPT_MODE, generatedKey);
        byte[] cipherText = cipher.doFinal(plainText);

        String savedKey = Base64.getEncoder().encodeToString(cipherText);

        // ----------------------------------------------------------------------------

        // RECUPERAR LA KEY PARA DE LA BASE DE DATOS

        byte[] decoded = Base64.getDecoder().decode(savedKey);
        SecretKeySpec restoredKey = new SecretKeySpec(decoded, algorithm);
        cipher.init(Cipher.DECRYPT_MODE, restoredKey);
        byte[] decriptedText = cipher.doFinal(cipherText);
        System.out.println(new String(decriptedText));


    }
}
