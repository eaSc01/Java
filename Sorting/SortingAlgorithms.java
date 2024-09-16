package Sorting;

public class SortingAlgorithms {

    private static int swaps;

    static {
        swaps = 0;
    }

    public static void main(String[] args) {
        int[] nums = { 1000, 500, 213, 752, 600, 2999, 2000, 200, 250, 70 };
        countingSort(nums);

        for (int a : nums) {
            System.out.print(a + ", ");
        }
    }

    public static void bubbleSort(int[] arr) {

        for (int turn = 0; turn <= arr.length - 2; turn++) {
            for (int curr = 0; curr <= arr.length - 2 - turn; curr++) {
                if (arr[curr] > arr[curr + 1]) {
                    swap(arr, curr, curr + 1);
                    swaps++;
                }
            }
        }

        System.out.println("Total swaps = " + swaps);
        swaps = 0;
    }

    public static void selectionSort(int[] arr) {

        for (int turn = 0; turn < arr.length - 1; turn++) {
            int minPos = turn;

            for (int i = turn + 1; i < arr.length; i++) {
                if (arr[minPos] > arr[i]) {
                    minPos = i;
                }
            }

            swap(arr, minPos, turn);
            swaps++;
        }

        System.out.println("Total swaps = " + swaps);
        swaps = 0;
    }

    public static void insertionSort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i]; // picked element from unsorted
            int j = i - 1;

            // push element to its destination, i.e, push element to the right, if its
            // greater than temp,
            while (j >= 0 && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = temp;
        }

    }

    public static void countingSort(int[] arr) {
        int largest = Integer.MIN_VALUE;

        for (int a : arr) {
            largest = Math.max(a, largest);
        }

        int[] freq = new int[largest + 1];

        for (int i = 0; i<arr.length; i++) {
            int curr = arr[i];
            freq[curr]++;
        }

        for (int i = 0, j = 0; i<arr.length; ) {
            while (freq[j] > 0) {
                arr[i++] = j;
                freq[j]--;
            }
            j++;
        }
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
