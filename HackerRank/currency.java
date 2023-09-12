import java.util.*;
import java.text.*;

public class currency {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        double payment = sc.nextDouble();
        sc.close();
        
        NumberFormat nf_US = NumberFormat.getCurrencyInstance(Locale.US);
        String us = nf_US.format(payment);
        
        NumberFormat nf_in = NumberFormat.getCurrencyInstance(new Locale("en", "IN"));
        String in = nf_in.format(payment);
        
        NumberFormat nf_ch = NumberFormat.getCurrencyInstance(Locale.CHINA);
        String ch = nf_ch.format(payment);
        
        NumberFormat nf_fr = NumberFormat.getCurrencyInstance(Locale.FRANCE);
        String fr = nf_fr.format(payment);
        
        System.out.println("US: " + us);
        System.out.println("India: " + in);
        System.out.println("China: " + ch);
        System.out.println("France: " + fr);
        
    }
}
