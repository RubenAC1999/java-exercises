import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class messageDigestExample {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        String password1 = "password123";
        String password2 = "password124";

        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");

        byte[] hash1 = messageDigest.digest(password1.getBytes());

        messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] hash2 = messageDigest.digest(password2.getBytes());

        boolean isValid = Arrays.equals(hash1, hash2);

        System.out.println("Tienen el mismo hash: " + isValid);


        // Se puede meter más información para hacer 1 solo hash

        messageDigest = MessageDigest.getInstance("SHA-256");
        messageDigest.update(password1.getBytes());
        messageDigest.update(password2.getBytes());
        hash1 = messageDigest.digest();
        System.out.println(new String(hash1));
    }
}
