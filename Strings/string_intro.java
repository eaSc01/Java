import java.util.Scanner;

public class string_intro {

    public static boolean palindrome(String str) {
        for (int i = 0 ; i<str.length()/2 ; i++) {
            if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
                return false;
            }
        } return true;    
    }
    
    public static void pString(String str) {
        for (int i=0 ; i<str.length() ; i++) {
            System.out.print(str.charAt(i) + " ");
        } System.out.println();
    }

    public static void concatStrings() {
        String fName = "Ishant";
        String LName = "Sikdar";
        String fullName = fName + " " + LName;
        System.out.println(fullName.charAt(10));
    }
    public static void main(String args[]) {
        // String str = "hello world";
        // String str2 = new String("Hello java");

        // System.out.println(str + "\n" + str2);
        String str1;
        Scanner scan = new Scanner(System.in);

        System.out.print("ENTER A STRING: ");
        str1 = scan.nextLine();

        // System.out.println(str1 + "\nLENGTH: " + str1.length());
        // concatStrings();
        // pString(str1);
        System.out.println(palindrome(str1));
        scan.close();
    }
}