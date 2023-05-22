
public class RecursionsFunc {

    public static int reverseNum(int n) {

        //prints numbers in descending
        if (n == 1) {
            return 1;
        }
        System.out.println(n);      
        return reverseNum(n-1);
    }

    public static void printDec(int n) {
        
        //reverseNum using void return type
        if (n == 1) {
            System.out.println(n);
            return;
        }

        System.out.println(n);
        printDec(n-1);
    }

    public static int ascendingNumbers(int end, int n) {

        //printing numbers in ascending order
        if (n == end) {
            return n;
        }
        System.out.println(n);
        return ascendingNumbers(end, n + 1);
    }

    public static void ascNum(int n) {

        //printing numbers in ascending order
        if (n == 1) {
            System.out.println(n);
            return;
        }

        ascNum(n - 1);          // new function instance but on N - 1, note that it doesnt return anything
        System.out.println(n);  //i.e, n will be differ for each instance of function
    }

    public static int factorial (int n) {

        // self made factorial rec
        if (n == 0) {
            return 1;
        }

        return n * factorial(n - 1);
    }

    public static int fact(int n) {

        //factorial
        if (n == 0) {
            return 1;
        }

        int x = fact(n - 1);        // calculates f(n-1) first, then multiplies it by n
        int y = n * x;

        return y;
    }
    
    public static int sumOfN(int n) {

        // self made sum of first N natural numbers
        if (n == 1) {
            return 1;
        }
        int x = sumOfN(n - 1);
        return n + x;
    }
    
    public static void main(String args[]) {
        
        // System.out.println(reverseNum(10));
        // System.out.println();
        // printDec(50);
        // ascNum(10);
        // System.out.println(fact(6));
        // System.out.println(sumOfN(50));
    }
}
