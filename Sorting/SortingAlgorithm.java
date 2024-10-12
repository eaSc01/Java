package Sorting;

public class SortingAlgorithm {

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i<arr.length - 1; i++) {
            int minPos = i;

            for (int j = i + 1; j<arr.length; j++) {
                if (arr[j] < arr[minPos]) {
                    minPos = j;
                }
            }

            int temp = arr[minPos];
            arr[minPos] = arr[i];
            arr[i] = temp;
        }
    }

    public static void insertionSort(int[] arr) {
        for (int i = 0; i<arr.length; i++) {
            int temp = arr[i];
            int prev = i - 1;

            while (prev >= 0 && arr[prev] > temp) {
                arr[prev + 1] = arr[prev];
                prev--;
            }
            
            arr[prev + 1] = temp;
        }
    }

    public static void countingSort(int[] arr) {
        int largest = Integer.MIN_VALUE;
        
        for (int i = 0; i<arr.length; i++) {
            largest = Math.max(largest, arr[i]);
        }

        int[] count = new int[largest + 1];

        for (int a: arr) {
            count[a]++;
        }

        int j = 0;
        for (int i = 0; i<count.length; i++) {
            while (count[i] > 0) {
                arr[j] = i;
                j++;
                count[i]--;
            }
        }
    }

    public static void prrArray(int array[]) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "  ");
        }
    }

    public static void main(String args[]) {
        int nums[] = { 3, 1, 4, 2, 5 };
        // bubbleSort(nums);
        // selectionSort(nums);
        // insertionSort(nums);
        countingSort(nums);
        prrArray(nums);
    }
}