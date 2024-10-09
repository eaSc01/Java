package BinarySearch;

public class SortedRotatedArraySearch {
    public int search(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high)/2;

            if (arr[mid] == target) {
                // standing on target
                return mid;

            } 

            if (arr[low] <= arr[mid]) { // left is sorted
                if (target >= arr[low] && target <= arr[mid]) { 
                    // target lies in left
                    high = mid - 1;

                } else {
                    // target lies in right
                    low = mid + 1;
                }
            } else { // right is sorted
                if (target >= arr[mid] && target <= arr[high]) {
                    // target lies in right
                    low = mid + 1;
                } else {
                    // target lies in left
                    high = mid - 1;
                }
            }
        }
        
        return -1;
    }
}