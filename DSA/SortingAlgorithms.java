public class SortingAlgorithms {

    public static void BubbleSort(int array[]) {
        
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

    public static void SelectionSort(int array[]) {
        
        for (int elementTracker=0 ; elementTracker<array.length - 1 ; elementTracker++) {
            int minPos = elementTracker;
            
            for (int j = elementTracker+1 ; j<array.length ; j++) { //finds the minimum element 
                if (array[j] < array[minPos]) {                     //in the range of (i+1) to '\0'
                    minPos = j;
                }
            }   
            //swap time
            int temp = array[elementTracker];
            array[elementTracker] = array[minPos];
            array[minPos] = temp;
        }
    }

    public static void insertionSort(int array[]) {
        //loop on unsorted array
        for (int i=1 ; i<array.length ; i++) {
            int curr = array[i];
            int prev = i - 1;
            //pushing elements and finding prev position
            while (prev>=0 && curr < array[prev]) {
                array[prev + 1] = array[prev];
                prev--;
            }
            //insertion
            array[prev + 1] = curr;
        }
    }
    
    public static void countingSort(int array[]) {
        int largest = Integer.MIN_VALUE;
        for (int i=0 ; i<array.length ; i++) {
            largest = Math.max(largest, array[i]);
        }    

        //count frequencies
        int count[] = new int[largest + 1];
        for (int i=0 ; i<array.length ; i++) {
            count[array[i]]++;
        }

        for (int i=0, j=0 ; i<count.length ; i++) {
            while (count[i] > 0) {
                array[j] = i;
                j++;
                count[i]--;
            }
        }
    }

    public static void prrArray(int array[]) {
        for (int i=0 ; i<array.length; i++) {
            System.out.print(array[i] + "  ");
        }
    }

    public static void main(String args[]) {
        int nums[] = {3,1,4,2,5};
        // BubbleSort(nums);
        // SelectionSort(nums);
        // insertionSort(nums);
        countingSort(nums);
        prrArray(nums);
    }
}