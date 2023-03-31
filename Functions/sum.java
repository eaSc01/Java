import java.util.*;

public class sum {

    public static int sumnumbers(int a, int b) {       //a and b are parameters or formal parameters
        return a+b;
    }

    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);

        System.out.print("ENTER X: ");
        int x = scan.nextInt();
        System.out.print("ENTER Y: ");
        int y = scan.nextInt();

        int z = sumnumbers(x, y); // x and y are arguements or actual parameters
        System.out.println("SUM OF X AND Y: " + z);

        scan.close();
    }
}