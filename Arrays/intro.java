import java.util.*;

public class intro {
    
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);

        int array[] = new int[5];

        for (int i = 0 ; i<5 ; i++) {
            System.out.print("ENTER A[" + i + "]: ");
            array[i] = scan.nextInt();
        }

        for (int i=4 ; i>=0 ; i--) {
            System.out.println("A[" + i + "]: " + array[i]);
        }

        scan.close();
    }
}