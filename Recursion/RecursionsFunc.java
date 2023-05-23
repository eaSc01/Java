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

    public static int exponent(int x, int n) { // O(n) TC
        if (n == 0) {
            return 1;
        } 

        return x * exponent(x, n-1);
    }

    public static int optiExpo(int x, int n) {  // TC O(logn)
        if (n == 0) {
            return 1;
        }

        int halfexpo = optiExpo(x, n/2);        // finds exponent of half n
        int halfExpoSq = halfexpo * halfexpo; // squaring half n of exponent

        // breaks x^n into x^(n/2), i.e, for 2^10, its 2^5 * 2^5, for odd n, its x * f(x) * f(x), for 2^10, its 2 * 2^5 * 2^5

        if (n%2 == 1) {
            halfExpoSq = x * halfExpoSq;
        }

        return halfExpoSq;
    }

    public static int tilingProb(int n) {

        // Given a "2 x n" floor and tiles of size "2 x 1", count the number of ways to tile the given board using the 2x1 tiles.

        // A tile can either be placed horiontally or vertically 
        
        if (n==0 || n==1) {

            // number of possible ways to put tiles, if length is 0 or 1, is 1
            return 1;
        } 

        // calculating number of vertical & horizontal ways separately,

        // vertical goes n - 1, because m (width) of floor matches width of tile
        // horizontal goes n - 2, because of analysis on the diagram

        // int vertical = tilingProb(n - 1);
        // int horizontal = tilingProb(n - 2);

        return tilingProb(n - 1) + tilingProb(n - 2);
    }

    public static void noDuplicatesStr(String Str, StringBuilder newStr, int i, boolean map[]) {    

        //iteration recursion, removes duplicate characters from string

        if (i == Str.length()) {        // traversed complete array
            System.out.println(newStr);
            return;
        } 

        char currchar = Str.charAt(i);  //stores current character

        if (map[currchar - 'a'] == false) {     // character never occured before
            map[currchar - 'a'] = true;
            noDuplicatesStr(Str, newStr.append(currchar), i+1, map);    
            // does same work for remaining string, but append the current character

        } else {    // character occured before
            noDuplicatesStr(Str, newStr, i+1, map);     // does same work for remaing string

        }
    }

    public static int nFriends(int n) {

        // Given n friends, each one can remain single or can be paired up with some other person, each friend can only be paired only once, find the total number of ways in which friends can remain single or can be paired up.

        if (n == 2 || n == 1) {
            return n;
        }

        // int single = nFriends(n-1);     // removes single person from n
        // int pair = (n-1) * nFriends(n-2);       // calculates the total possibilites for each pair

        return nFriends(n-1) + (n-1) * nFriends(n-2);       // addition thm
    }

    public static void binaryStrings(String str, int lastDigit, int n) {

        // decreaments n on each iteration/digit print
        if (n == 0) {
            System.out.println(str);
            return; 
        }

        // recalls itself and stores 0 in string
        binaryStrings(str+"0", 0, n - 1);

        // recalls itself after prev call, and replaces with 1 in string
        if (lastDigit == 0) {
            binaryStrings(str+"1", 1, n - 1);
        }
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

        // System.out.println(tilingProb(4));

        // boolean alphabetMap[] = new boolean[26];
        // String str = "aaaabebeeccccosaddeedddeoecba";
        // StringBuilder newStr = new StringBuilder("");
        // noDuplicatesStr(str, newStr, 0, alphabetMap);

        // System.out.println(nFriends(3));
        // binaryStrings("", 0, 4);
    }
}
