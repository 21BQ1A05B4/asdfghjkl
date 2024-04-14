import java.util.*;
import javax.crypto.*;

public class DES {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the plain text :");
        String pt = sc.nextLine();
        SecretKey key = KeyGenerator.getInstance("DES").generateKey();
        Cipher ct = Cipher.getInstance("DES");
        ct.init(ct.ENCRYPT_MODE, key);
        byte [] encrypt = ct.doFinal(pt.getBytes());
        String enBase64 = Base64.getEncoder().encodeToString(encrypt);
        System.out.println(enBase64);
        ct.init(ct.DECRYPT_MODE, key);
        byte [] dec = ct.doFinal(Base64.getDecoder().decode(enBase64));
        String dt = new String(dec);
        System.out.println(dt);
    }
}