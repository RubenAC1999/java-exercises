import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class messageAuthenticationCodeExample {
    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException {
        String algorithm = "AES";
        byte[] keyBytes = new byte[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        Mac mac = Mac.getInstance("HmacSHA256");

        SecretKeySpec key = new SecretKeySpec(keyBytes, algorithm);

        mac.init(key);

        byte[] data = "data".getBytes(StandardCharsets.UTF_8);
        byte[] macBytes = mac.doFinal(data);

        // Se puede poner más información con .update al igual que MessageDigest
    }
}
