import java.util.Scanner;
import java.math.BigInteger;

public class DH {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger n, g, x, y, k1, k2, A, B;
        System.out.println("Enter two prime numbers :");
        n = new BigInteger(sc.next());
        g = new BigInteger(sc.next());

        System.out.println("Person A : Enter your secret Key :");
        x = new BigInteger(sc.next());
        A = g.modPow(x, n);

        System.out.println("Person B : Enter your secret Key : ");
        y = new BigInteger(sc.next());
        B = g.modPow(y, n);

        k1 = B.modPow(x, n);
        k2 = A.modPow(y, n);
        System.out.println("A's secret key : " + k1);
        System.out.println("B's secret Key : "+ k2);
    }
}
