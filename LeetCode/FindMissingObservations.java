package LeetCode;

public class FindMissingObservations {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int totalSum = mean * (m + n);
        int missingSum = 0;

        for (int roll: rolls) {
            missingSum += roll;
        }

        missingSum = totalSum - missingSum;

        if (missingSum < n || missingSum > n * 6) {
            return new int[0];
        }

        int base = missingSum / n;
        int remainder = missingSum % n;
        int[] missing = new int[n];

        for (int i = 0; i<n; i++) {
            missing[i] = base + (i < remainder ? 1 : 0);
        }

        return missing;
    }
}