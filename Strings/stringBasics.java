import java.util.Scanner;

public class stringBasics {

    public static void largestString(String array[]) {
        String largest = array[0];
        for (int i=1 ; i<array.length ; i++ ) {
            if (largest.compareTo(array[i]) < 0 ) {
                largest = array[i];
            }
        } System.out.println("LARGEST STRING: " + largest);
    }

    public static void subString(String str, Scanner scan) {
        // String str = "Hello World";
        System.out.println("ENTER BEGIN AND END INDEX");
        int s_in = scan.nextInt();
        int e_in = scan.nextInt();

        // String etr = "";
        // for (int i = s_in ; i<e_in ; i++) {
        //     etr += str.charAt(i);
        // }
        
        //or
        System.out.println(str.substring(s_in,e_in));
        // System.out.println(etr);
    }

    //user defined string equals function
    public static void strcomp(String str1, String str2) {
        // String str1 = "Hehe";
        // String str2 = new String("Hehfe");

        if (str1.equals(str2) == true) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }

    //palindrome string
    public static boolean palindrome(String str) {
        for (int i = 0 ; i<str.length()/2 ; i++) {
            if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
                return false;
            }
        } return true;    
    }
    
    //print string using loop
    public static void pString(String str) {
        for (int i=0 ; i<str.length() ; i++) {
            System.out.print(str.charAt(i) + " ");
        } System.out.println();
    }

    //concatenation in a string
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
        String fruits[] = {"apple", "mango","banana"};
        Scanner scan = new Scanner(System.in);


        System.out.print("ENTER A STRING: ");
        str1 = scan.nextLine();

        // System.out.println(str1 + "\nLENGTH: " + str1.length());
        // concatStrings();
        // pString(str1);
        // System.out.println(palindrome(str1));
        subString(str1, scan);
        largestString(fruits);
        scan.close();
    }
}