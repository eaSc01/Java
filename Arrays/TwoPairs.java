public class TwoPairs {
    public static void main(String[] args) {
        int[] nums = { 2, 4, 6, 8, 10 };
        getPairs(nums);
    }

    private static void getPairs(int[] nums) {
        int totalPairs = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                totalPairs++;
                System.out.print("(" + nums[i] + ", " + nums[j] + ") ");
            }
            System.out.println();
        }
        System.out.println("Total Pairs: " + totalPairs);
    }
}
