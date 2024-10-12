public class RemoveDuplicatesFromSortedArr {
    public static void main(String[] args) {
        int[] arr = { 1, 1, 2, 2, 2, 3, 3, 4, 5, 6, 6 };
        System.out.println("K: " + removeDuplicates(arr));

        for (int a: arr) {
            System.out.print(a + ", ");
        }
    }

    public static int removeDuplicates(int[] nums) {
        int low = 0;
        int high = 1;

        while (high < nums.length) {
            if (nums[low] == nums[high]) {
                high++;

            } else {
                low++;
                nums[low] = nums[high];
                high++;
            }
        }

        return low + 1;
    }
}