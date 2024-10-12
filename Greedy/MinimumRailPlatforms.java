//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            String str[] = read.readLine().trim().split(" ");
            int n = Integer.parseInt(str[0]);
            
            int arr[] = new int[n];
            int dep[] = new int[n];
            
            str = read.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
              arr[i] = Integer.parseInt(str[i]);
            str = read.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
                dep[i] = Integer.parseInt(str[i]);
                
            System.out.println(new Solution().findPlatform(arr, dep, n));
        }
    }
    
    
}



// } Driver Code Ends

class Solution
{
    // Function to find the minimum number of platforms required at the
    // railway station such that no train waits.
    int findPlatform(int arr[], int dep[], int n)
    {
        // Initialize pointers for arrivals and departures
        int i = 0, j = 0;
        
        // Initialize the count of platforms needed and the maximum platforms needed
        int platforms = 0;
        int maxPlatforms = 0;
        
        // Process all events
        while (i < n && j < n) {
            // If next event is arrival, increment platform count
            if (arr[i] <= dep[j]) {
                platforms++;
                i++;
                
                // Update maximum platforms needed
                maxPlatforms = Math.max(maxPlatforms, platforms);
            } 
            // If next event is departure, decrement platform count
            else {
                platforms--;
                j++;
            }
        }
        
        return maxPlatforms;
    }
}

