public class SubArray {

    public static void getSubArray(int array[]) {
        for (int start = 0 ; start<array.length ; start++) {
            for (int end = start ; end<array.length ; end++) {
                System.out.println();
                for (int target = start ; target<=end ; target++) {
                    System.out.print(array[target] + ",");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void main(String args[]) {
        int numbers[] = {1,-2,4,6,-4};
        getSubArray(numbers);
    }
}