package LeetCode;

public class KthSmallestLexicographicalNumber {
    public int findKthNumber(int n, int k) {
        // Start with the first number in lexicographical order
        int curr = 1;
        k--; // Decrement k since we start counting from 1

        // Continue until we have found the k-th number
        while (k > 0) {
            // Count the number of children for the current number
            long steps = countChildren(n, curr);

            // If the number of steps is less than or equal to k,
            // we move to the next sibling
            if (steps <= k) {
                curr = curr + 1; // Move to the next sibling
                k -= steps; // Decrease k by the number of steps we skipped
            } else {
                // If steps are greater than k, go down to the first child
                curr = curr * 10; // Move to the next level (first child)
                k--; // We are moving down one level, so decrement k
            }
        }

        // Return the k-th number in lexicographical order
        return curr;
    }

    public long countChildren(int n, long curr) {
        long count = 0; // Initialize count of children
        long neighbour = curr + 1; // Set the next sibling (curr + 1)

        // Count how many numbers are in the range from curr to n
        while (curr <= n) {
            // Add the count of valid children in the current range
            count += Math.min(n + 1, neighbour) - curr;
            curr = curr * 10; // Move to the next level (first child)
            neighbour = neighbour * 10; // Move the neighbour down a level
        }

        // Return the total count of children found
        return count;
    }
}
