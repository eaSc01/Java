import java.util.*;

public class PrintN {
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);

        int max = scan.nextInt();

        for (int i = 0; i< max ; i++ ) {
            System.out.println("hello");
        }

        scan.close();
    }
}