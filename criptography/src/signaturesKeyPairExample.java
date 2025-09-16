import java.security.*;

public class signaturesKeyPairExample {
    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
        SecureRandom secureRandom = new SecureRandom();
        keyPairGen.initialize(2048, secureRandom);
        KeyPair keyPair = keyPairGen.generateKeyPair();

        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initSign(keyPair.getPrivate());
        signature.update("Mensaje importante: ".getBytes());
        byte[] signBytes = signature.sign();

        signature.initVerify(keyPair.getPublic());
        signature.update("Mensaje importante: ".getBytes());
        boolean isValid = signature.verify(signBytes);

        System.out.println("Firma válida?: " + isValid);
    }
}
