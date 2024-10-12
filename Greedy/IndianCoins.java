//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int v = sc.nextInt();
            int m = sc.nextInt();
            int coins[] = new int[m];
            for (int i = 0; i < m; i++)
                coins[i] = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.minCoins(coins, m, v));
        }
    }
}
// } Driver Code Ends

class Solution {

    public int minCoins(int arr[], int M, int sum) {
        Arrays.sort(arr);

        int i = M - 1;
        int count = 0;

        while (sum > 0 && i >= 0) {
            while (arr[i] <= sum) {
                count++;
                sum = sum - arr[i];
            }

            i--;
        }

        if (sum > 0) {
            return -1;
        }

        return count;
    }
}