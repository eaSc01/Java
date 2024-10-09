package Arrays;

public class RotatedBinarySearch {
    public static int search(int[] arr, int target) {
        int si = 0;
        int ei = arr.length - 1;

        while (si <= ei) {
            int mid = si + (ei - si) / 2;

            if (arr[mid] == target) {
                return mid;
                
            // line 1
            } else if (arr[si] <= arr[mid]) {
                // line 1 - left of mid
                if (arr[si] <= target && target <= arr[mid]) {
                    ei = mid - 1;

                } else { // right of mid (whole)
                    si = mid + 1;
                }

            // line 2
            } else {    // line 2 - right
                if (arr[mid] <= target && target <= arr[ei]) {
                    si = mid + 1;

                } else {  // left of mid (whole)
                    ei = mid - 1;
                }

            }
        }

        return -1;
    }
}
