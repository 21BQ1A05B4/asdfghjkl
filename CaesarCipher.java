import java.util.Scanner;

public class CaesarCipher {

    static final String alpha = "abcdefghijklmnopqrstuvwxyz";

    static String encrypt (String data, int shift) {
        data = data.toLowerCase();
        StringBuilder encryptString = new StringBuilder();
        for(int i=0; i<data.length(); i++) {
            int pos = alpha.indexOf(data.charAt(i));
            int encryptPos = (shift + pos) % 26;
            char encryptChar = alpha.charAt(encryptPos);
            encryptString.append(encryptChar);
        }
        return encryptString.toString();
    }

    static String decrypt(String data, int shift) {
        data = data.toLowerCase();
        StringBuilder decryptString = new StringBuilder();
        for(int i=0; i<data.length(); i++) {
            int pos = alpha.indexOf(data.charAt(i));
            int decryptPos = (pos - shift) % 26;
            if(decryptPos < 0) {
                decryptPos = (decryptPos + 26) % 26;
            }
            char decryptChar = alpha.charAt(decryptPos);
            decryptString.append(decryptChar);
        }
        return decryptString.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Data to Encrypt : ");
        String data = sc.nextLine();
        System.out.print("Enter the shift : ");
        int shift = sc.nextInt();
        String encryptRes = encrypt(data, shift);
        String decryptRes = decrypt(encryptRes, shift);
        System.out.println(encryptRes);
        System.out.println(decryptRes);
    }
}