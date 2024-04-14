import java.util.*;
import java.security.*;
import java.math.*;

public class CryptographicHashFunctions {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the data :");
        String data = sc.nextLine();
        System.out.println("choose the algorithm: from SHA-512, SHA-256, MD5");
        String algorithm = sc.nextLine().toUpperCase();
        HashSet<String> algorithms = new HashSet<>();
        algorithms.add("SHA-256");
        algorithms.add("SHA-512");
        algorithms.add("MD5");
        if(!algorithms.contains(algorithm)) {
            System.out.println("Invalid algorithm choose from the above mentioned ");
            return;
        }
        String hash = generateHash(data, algorithm);
        System.out.println(hash + " is generated using " + algorithm);
    }

    static String generateHash(String data, String algorithm) throws Exception{
        MessageDigest digest = MessageDigest.getInstance(algorithm);
        digest.update(data.getBytes());
        byte [] hashedBytes = digest.digest();
        BigInteger hashInt = new BigInteger(1, hashedBytes);
        return hashInt.toString(16);
    }
}