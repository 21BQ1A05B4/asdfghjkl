import java.util.Scanner;

public class OneTimePad {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the plainText : ");
        String plainText = sc.nextLine();
        System.out.print("Enter the key :");
        String key = sc.nextLine();
        if(plainText.length() != key.length()) {
            System.out.println("Lenght MisMatch...");
            return;
        }
        StringBuilder ct = new StringBuilder();
        for(int i=0; i<plainText.length(); i++) {
            char c = (char)(plainText.charAt(i) ^ key.charAt(i));
            ct.append(c);
        }
        System.out.println("Encryption Done...");
        for(int i=0; i<ct.length(); i++) {
            System.out.println(Integer.toBinaryString((int)(ct.charAt(i))));
        }
        StringBuilder dt = new StringBuilder();
        for(int i=0; i<ct.length(); i++) {
            char dc = (char)(ct.charAt(i) ^ key.charAt(i));
            dt.append(dc);
        }
        System.out.println(dt);
    }
}