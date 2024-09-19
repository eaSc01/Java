
import java.util.*;

class Solution {
    public int findMinDifference(List<String> timePoints) {
        int[] timeMinutes = new int[timePoints.size()];

        for (int i = 0; i<timeMinutes.length; i++) {
            String[] time = timePoints.get(i).split(":");
            int hours = Integer.parseInt(time[0]);
            int mins = Integer.parseInt(time[1]);
            int totalMins = mins + (hours * 60);
            timeMinutes[i] = totalMins;
        }

        Arrays.sort(timeMinutes);

        int ans = Integer.MAX_VALUE;

        for (int i = 1; i<timeMinutes.length; i++) {
            int diff = timeMinutes[i] - timeMinutes[i - 1];
            ans = Math.min(ans, diff);
        }

        return Math.min(
            ans,
            24 * 60 - timeMinutes[timeMinutes.length - 1] + timeMinutes[0]
        );
    }
}