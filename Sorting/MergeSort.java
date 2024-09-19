package Sorting;

public class MergeSort {
    public static void print(int[] arr, int s, int e) {
        System.out.println("S: " + s + " E: " + e);
        System.out.print("{ ");
        for (int i = s; i <= e; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.print(" }");
        System.out.println();
    }

    public static void mergeSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = start + (end - start) / 2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);
        merge(arr, start, mid, end);
    }

    public static void merge(int[] arr, int start, int mid, int end) {
        int size = end - start + 1;
        int[] temp = new int[size];

        int i = start;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= end && k < size) {
            if (arr[i] < arr[j]) {
                temp[k] = arr[i++];
            } else {
                temp[k] = arr[j++];
            }
            k++;
        }

        while (i <= mid && k < size) {
            temp[k++] = arr[i++];
        }

        while (j <= end && k < size) {
            temp[k++] = arr[j++];
        }

        for (k = 0, i = start; k<size; k++, i++) {
            arr[i] = arr[k];
        }

    }

    public static void main(String[] args) {
        int[] arr = {523, 734, 182, 928, 473, 291, 582, 492, 841, 392, 610, 765, 188, 973, 245, 104, 832, 991, 726, 620, 107, 824, 459, 109, 583, 482, 274, 560, 738, 917, 315, 675, 491, 710, 840, 296, 192, 611, 473, 391, 836, 629, 954, 283, 601, 740, 193, 563, 472, 810, 294, 631, 890, 472, 135, 621, 491, 265, 472, 811, 652, 930, 412, 590, 763, 293, 157, 831, 572, 364, 109, 914, 482, 621, 534, 819, 264, 729, 301, 189, 482, 735, 619, 493, 621, 582, 293, 175, 583, 472, 294, 620, 812, 745, 294, 103, 564, 472, 900, 628, 593, 174, 295, 478, 291, 536, 298, 103, 564, 721, 193, 764, 395, 281, 607, 473, 284, 193, 743, 501, 392, 650, 892, 472, 162, 835, 473, 620, 193, 581, 472, 183, 751, 294, 102, 681, 421, 592, 103, 784, 529, 201, 647, 392, 285, 763, 193, 485, 621, 374, 109, 481, 294, 903, 612, 295, 172, 738, 291, 485, 617, 738, 491, 193, 802, 472, 381, 205, 620, 103, 785, 493, 295, 392, 504, 384, 620, 193, 850, 472, 930, 483, 291, 745};


        // mergeSort(arr, 0, arr.length - 1);

        // print(arr, 0, arr.length - 1);
        System.out.println(arr.length);
    }
}