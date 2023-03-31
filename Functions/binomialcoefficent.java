import java.util.*;

public class binomialcoefficent {

    public static double fact(int number) {
        double factorial = 1;
        for (int dec = number ; dec>0 ; dec--) {            //number is the number of which factorial is needed
            factorial = factorial * dec;                    //dec is decreament of number till 1
        } return factorial;
    }

    public static int bi_coefficent(int n, int r) {
        /*double n_fact = fact(n);
        double r_fact = fact(r);
        double nr_fact = fact(n-r);
        int bi_coefficent = (int) (n_fact/(r_fact * nr_fact));
        return bi_coefficent;
        */
        
        int bi_coefficent = (int) (fact(n)/(fact(r) * fact(n-r)));
        return bi_coefficent;
    }

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        System.out.print("ENTER N: ");
        int n = scan.nextInt();
        System.out.print("ENTER R: ");
        int r = scan.nextInt();
        int binomialcoefficent = bi_coefficent(n, r);
        System.out.println("C: " + binomialcoefficent);
        scan.close();
    }
}