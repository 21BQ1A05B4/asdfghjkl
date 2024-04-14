import java.util.*;
import javax.crypto.*;

public class AES {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the plain text : ");
        String pt = sc.nextLine();
        SecretKey key = KeyGenerator.getInstance("AES").generateKey();
        Cipher ct = Cipher.getInstance("AES");
        ct.init(Cipher.ENCRYPT_MODE, key);
        byte [] encrypt = ct.doFinal(pt.getBytes());
        String enBase64 = Base64.getEncoder().encodeToString(encrypt);
        System.out.println(enBase64);
        ct.init(Cipher.DECRYPT_MODE, key);
        byte [] dec = ct.doFinal(Base64.getDecoder().decode(enBase64));
        String dt = new String(dec);
        System.out.println(dt);
    }
}