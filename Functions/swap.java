import java.util.*;

public class swap {

    public static void swapn(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
        System.out.println("A: " + a + " B: " + b);
    }
    
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        int a = 10;
        int b = 5;

        swapn(a, b);
        System.out.println("A: " + a + " B: " + b);

        scan.close();
    }
}