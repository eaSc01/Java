import java.util.ArrayList;
import java.util.Collections;

// Arraylist are arrays that are accessed as objects and can changed dynamically in size
// they are a part of Java Collections Framework


// Collections is a class, unlike Collection interface

public class intro {
    public static int maximum(ArrayList<Integer> list) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < list.size(); i++) {
            max = Math.max(max, list.get(i));
        }

        return max;
    }

    public static void swap(ArrayList<Integer> list, int idx1, int idx2) {
        int temp = list.get(idx1);
        list.set(idx1, list.get(idx2));
        list.set(idx1, temp);
    }
    
    public static void sortList(ArrayList<Integer> list, int idx1, int idx2) {
        Collections.sort(list); // asc order
        Collections.sort(list, Collections.reverseOrder()); // reverseOrder is a comparator, that defines the ordering of the elements
    }
    public static void main(String[] args) {

        // arraylist declaration
        // ArrayList <Non-Primitive Datatype> ObjectName = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();

        // Add method O(1)
        // -> list.add(element)
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        // Add on position O(n)
        // -> list.add(index, element)
        list.add(1, 10);

        // Get Method O(1)
        int element = list.get(2);
        // System.out.println(element);

        // Set Method
        list.set(2, 3);

        // remove method O(n)
        list.remove(2);

        // contains method O(n) - search
        // System.out.println(list.contains(10));
        // System.out.println(list.contains(100));

        // size method
        int size = list.size();
        // System.out.println(size);

        // for (int i = 0; i < list.size(); i++) {
        // System.out.print(i + " ");
        // }

        // System.out.println();

        // for (int i = list.size() - 1; i >= 0; i--) {
        // System.out.print(i + " ");
        // }

        // System.out.println(list);
        // System.out.println(maximum(list));

    }
}