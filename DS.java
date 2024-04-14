import java.util.Scanner;
import java.security.*;

/*
 * Generate secret keys 
 * create signature 
 * Generate private, public keys
 * writing the secret message (user input)
 * signing message withour secret key
 * converting signature into secret code 
 * check the signature
 */

public class DS {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        // Generate Secret keys
        
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
    
        //  create Signature 

        Signature signature = Signature.getInstance("SHA256withRSA");
        
        //  Generate private and public keys 

        PrivateKey privateKey = keyPair.getPrivate();
        PublicKey publicKey = keyPair.getPublic();

        //  write the message 

        String message = sc.nextLine();

        // sign the message with secret key or private key

        signature.initSign(privateKey);
        signature.update(message.getBytes());
        byte [] digitalSignature = signature.sign();

        //  convert byte [] signature to hexaDecimal String 

        String hexSignature = bytesToHex(digitalSignature);
        System.out.println(hexSignature);

        // Check the Signature

        signature.initVerify(publicKey);
        signature.update(message.getBytes());
        boolean verified = signature.verify(digitalSignature);

        if(verified) {
            System.out.println("Verified");
        } else {
            System.out.println("tampered");
        }
    } 
    static String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder(2*bytes.length);
        for (int i = 0; i < bytes.length; i++) {
            String hex = Integer.toHexString(0xff & bytes[i]);
            if(hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
    }
    return hexString.toString;
}
