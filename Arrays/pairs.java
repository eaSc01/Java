public class pairs {
    public static void getPairs(int array[]) {

        for (int i = 0 ; i<array.length ; i++) {
            System.out.println();
            for (int j = i + 1 ; j<array.length ; j++) {
                System.out.print("(" + array[i] + ", " + array[j] + ")");
            }
        }
    }

    public static void main(String args[]) {

        int numbers[] = {2,3,4,5,6,7};

        getPairs(numbers);
    }
}
