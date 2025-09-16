import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class messageDigestExample {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        String password = "password123";

        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] hash = messageDigest.digest(password.getBytes());

        System.out.println(new String(hash));
    }
}
