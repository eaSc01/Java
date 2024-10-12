public class Sort012 {
    public static void main(String[] args) {
        int nums[] = { 2, 0, 2, 1, 1, 0 };
        sortColors(nums);

        for (int a : nums) {
            System.out.print(a + ", ");
        }
    }

    public static void sortColors(int[] nums) {
        int zeroes = 0;
        int ones = 0;
        int twos = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroes++;
            } else if (nums[i] == 1) {
                ones++;
            } else if (nums[i] == 2) {
                twos++;
            }
        }

        int i = 0;
        for (; i < zeroes; i++) {
            nums[i] = 0;
        }

        for (; i < ones + zeroes; i++) {
            nums[i] = 1;
        }
        
        for (; i < twos + zeroes + ones; i++) {
            nums[i] = 2;
        }

    }
}
