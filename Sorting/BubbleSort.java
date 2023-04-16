public class BubbleSort {
    
    public static void BubbleSortAlgo(int array[]) {
        
        for (int turn=0 ; turn<array.length-1 ; turn++) {
            
            int swaps = 0; //Checks how many swaps are done in each inner iteration
            for (int currIndex = 0 ; currIndex<array.length-1-turn ; currIndex++) {
                if (array[currIndex] > array[currIndex+1]) {
                    int temp = array[currIndex];
                    array[currIndex] = array[currIndex + 1];
                    array[currIndex + 1] = temp;
                    swaps++;
                }

            } if (swaps == 0) {
                return;
            }
        }
    }

    public static void prrArray(int array[]) {
        for (int i=0 ; i<array.length; i++) {
            System.out.print(array[i] + "  ");
        }
    }

    //declare main and pre requisties
    public static void main(String args[]) {
        int nums[] = {4,1,2,5,3};
        BubbleSortAlgo(nums);
        prrArray(nums);
    }
}