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

    public static int fibo(int n) {

        //nth fibonacci number
        if (n == 0 || n == 1) {
            return n;
        }
        
        return fibo(n - 1) + fibo(n - 2);   
        //n is the sequence number

        // in multiple recursive call functions, it makes a virtual tree like structure in stack
        // space com: O(n), time com: O(2^n)
    }

    public static boolean isSorted(int arr[], int i) {
        if (i == arr.length - 1) {
            return true;
        }

        if (arr[i] > arr[i+1]) {
            return false;
        }

        return isSorted(arr, i+1);
    }

    public static int firstOccur(int arr[], int key, int i) {

        // first occurence in an array
        if (i == arr.length - 1) {
            if (arr[i] == key) {
                return i;
            } else {
                return -1;
            }
        }

        if (arr[i] == key) {
            return i;
        }

        return firstOccur(arr, key, i+1);
    }

    public static int lastOccur(int arr[], int key, int i) {

        //last occurence in an array

        //base case
        if (i == arr.length) {
            return -1;
        }

        int isFound = lastOccur(arr, key, i+1);     // checks remaining portion of array first

        // triggers only if the previously checked portion of array doesnt have the element but the element is present on i pos
        if(isFound == -1 && arr[i] == key) {    
            return i;
        }

        return isFound; 
    }


    public static void main(String args[]) {
        
        // System.out.println(reverseNum(10));
        // System.out.println();
        // printDec(50);
        // ascNum(10);
        
        // System.out.println(fact(6));
        // System.out.println(sumOfN(50));
        // System.out.println(fibo(50));

        // int arr[] = {1,2,34,1,2,1,34};
        // System.out.println(isSorted(arr, 0));
        // System.out.println(lastOccur(arr, 34, 0));

    }
}
