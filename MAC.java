import java.util.Scanner;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class MAC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String secret = sc.nextLine();
        String message = sc.nextLine();
        try {
            Mac hasher = Mac.getInstance("HMacSHA256");
            SecretKeySpec secretKey = new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8), "HMacSHA256");
            hasher.init(secretKey);
            byte [] hashedBytes = hasher.doFinal(message.getBytes(StandardCharsets.UTF_8));
            String encryptString = Base64.getEncoder().encodeToString(hashedBytes);
            System.out.println(encryptString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
