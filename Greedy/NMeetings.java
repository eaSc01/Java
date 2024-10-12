//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);

            int start[] = new int[n];
            int end[] = new int[n];

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) start[i] = Integer.parseInt(inputLine[i]);

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) end[i] = Integer.parseInt(inputLine[i]);

            int ans = new Solution().maxMeetings(n, start, end);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    class Pair {
        private int start;
        private int end;
        
        public Pair(int s, int e) {
            this.start = s;
            this.end = e;
        }
        
        public int getStart() {
            return this.start;
        }
        
        public int getEnd() {
            return this.end;
        }
    }
    
    public int maxMeetings(int n, int start[], int end[]) {
        List<Pair> meetings = new ArrayList<>();
        
        for (int i = 0; i<n; i++) {
            meetings.add(new Pair(start[i], end[i]));
        }
        
        meetings.sort(Comparator.comparingInt(Pair::getEnd));
        
        int count = 1;
        int lastMeet = meetings.get(0).getEnd();
        
        for (int i = 1; i<n; i++) {
            int startTime = meetings.get(i).getStart();
            int endTime = meetings.get(i).getEnd();
            
            if (startTime > lastMeet) {
                count++;
                lastMeet = endTime;
            }
        }
        
        return count;
    }
}
