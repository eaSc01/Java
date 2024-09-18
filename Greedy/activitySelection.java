import java.util.ArrayList;

public class ActivitySelection {

    public static void actSelect(int startTime[], int endTime[]) {
        int maxAct = 0;
        ArrayList<Integer> selected = new ArrayList<>(); // stores selected activities index
        int lastAct = 0; // stores index of last selected activity

        // selecting first activity as selected, because activities are sorted according
        // to endTime[]
        maxAct++;
        selected.add(0);
        lastAct = endTime[0];

        for (int i = 1; i < startTime.length; i++) {
            if (lastAct <= startTime[i]) {
                maxAct++;
                selected.add(i);
                lastAct = endTime[i];
            }
        }

        System.out.println(selected);
        System.out.println(maxAct);
    }

    public static void main(String[] args) {
        int startTime[] = {1,3,0,5,8,5};
        int endTime[] = {2,4,6,7,9,9};
        actSelect(startTime, endTime);
    }
}
