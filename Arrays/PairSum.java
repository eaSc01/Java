import java.util.ArrayList;

public class PairSum {

    public static boolean pairSum_SortedRotated_TwoPointer(ArrayList<Integer> list, int target) {

        int size = list.size();

        // finding the breaking point of arraylist
        int breakingPoint = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > list.get(i + 1)) {
                breakingPoint = i;
                break;
            }
        }

        int rightPtr = breakingPoint;
        int leftPtr = (breakingPoint + 1) % size;

        while (leftPtr != rightPtr) {

            if (list.get(leftPtr) + list.get(rightPtr) == target) {
                return true;

            } else if (list.get(leftPtr) + list.get(rightPtr) < target) {
                leftPtr = (leftPtr + 1) % size;

            } else {
                rightPtr = (rightPtr - 1 + size) % size;

            }
        }
        return false;
    }

    public static boolean pairSum_One_TwoPointer(ArrayList<Integer> list, int target) {

        // ArrayList is sorted
        int leftPtr = 0;
        int rightPtr = list.size() - 1;

        while (leftPtr < rightPtr) {

            if (list.get(leftPtr) + list.get(rightPtr) == target) {
                return true;

            } else if (list.get(leftPtr) + list.get(rightPtr) < target) {
                leftPtr++;

            } else {
                rightPtr--;

            }
        }

        return false;
    }

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(11);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);

        System.out.println(pairSum_SortedRotated_TwoPointer(list, 15));
    }
}
