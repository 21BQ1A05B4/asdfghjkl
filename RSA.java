import java.util.Scanner;
import java.math.BigInteger;

public class RSA {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter two large prime numbers (p and q): ");
        BigInteger p = sc.nextBigInteger();
        BigInteger q = sc.nextBigInteger();

        BigInteger n = p.multiply(q); // Calculate n (modulus)
        BigInteger phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE)); // Calculate Euler's totient function phi(n)

        BigInteger e = BigInteger.valueOf(2);
        while (e.compareTo(phi) < 0 && !e.gcd(phi).equals(BigInteger.ONE)) {
            e = e.add(BigInteger.ONE);
        }

        BigInteger d = e.modInverse(phi); // Calculate the modular multiplicative inverse of e mod phi

        System.out.println("Enter a message to encrypt (as a number): ");
        BigInteger message = sc.nextBigInteger();

        BigInteger encryptedMessage = message.modPow(e, n); // Encryption: c = message^e mod n
        BigInteger decryptedMessage = encryptedMessage.modPow(d, n); // Decryption: decryptedMessage = c^d mod n

        System.out.println("Original Message: " + message);
        System.out.println("Encrypted Message: " + encryptedMessage);
        System.out.println("Decrypted Message: " + decryptedMessage);

        sc.close();
    }
}
