import java.util.*;

public class GreedyAlgo {

    static class Jobs {
        int id;
        int deadline;
        int profit;

        Jobs(int id, int deadline, int profit) {
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }
    }

    public static int fractionalKnapsack(int weightOfItem[], int valueOfItem[], int remainingCapacity) {

        ArrayList<Double> ratio = new ArrayList<>();
        int maxValue = 0;

        // calculating ratio of items
        for (int i = 0; i < valueOfItem.length; i++) {
            ratio.add(valueOfItem[i] / (double) weightOfItem[i]);
        }

        // calculation maxValue
        for (int i = 0; i < ratio.size(); i++) {
            if (remainingCapacity >= weightOfItem[i]) {
                remainingCapacity -= weightOfItem[i];
                maxValue += valueOfItem[i];

            } else {
                maxValue = (int) (maxValue + (remainingCapacity * ratio.get(i)));
                break;
            }
        }

        return maxValue;
    }

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

    public static int maxLengthChain(int chainPairs[][]) {
        Arrays.sort(chainPairs, Comparator.comparingDouble(o -> o[1])); // multi dimensional sorting

        // init first pair (including it to chain)
        int maxLen = 1;
        int chainEnd = chainPairs[0][1];

        // for the rest of pairs
        for (int i = 1; i < chainPairs.length; i++) {
            if (chainEnd < chainPairs[i][0]) {
                maxLen++;
                chainEnd = chainPairs[i][1];
            }
        }
        return maxLen;
    }

    public static int indianCoins(int coins[], int amount) {
        int count = 0;
        Arrays.sort(coins);
        ArrayList<Integer> rupees = new ArrayList<>();

        for (int i = coins.length - 1; i >= 0; i--) {
            if (coins[i] <= amount) {
                while (coins[i] <= amount) {
                    count++;
                    amount -= coins[i];
                    rupees.add(coins[i]);
                }
            }
        }
        System.out.println(rupees);
        return count;
    }

    public static int jobSequence(int jobs[][]) {

        // Arraylist to store job info in form of objects
        ArrayList<Jobs> JobList = new ArrayList<>();

        // transfering array items into arraylist (creating their objects
        // simentaneously)
        for (int i = 0; i < jobs.length; i++) {
            JobList.add(new Jobs(i, jobs[i][0], jobs[i][1]));
        }

        // sorting arraylist items/objects
        Collections.sort(JobList, (a, b) -> b.profit - a.profit);

        // Job sequencing
        int time = 0;
        ArrayList<Integer> selectedJobs = new ArrayList<>(); // stores selected job indexes

        for (int i = 0; i < JobList.size(); i++) {
            Jobs currentJob = JobList.get(i);
            if (currentJob.deadline > time) {
                time++;
                selectedJobs.add(currentJob.id);
            }
        }

        System.out.println(selectedJobs);
        return selectedJobs.size();
    }

    public static int chocola(Integer[] horizontalCost, Integer[] verticalCost) {
        // Chocola Problem/ Min cost to get smallest unit of chocolate/board, if each
        // hor/ver cut has a cost.

        int totalCost = 0;
        int currHorIdx = 0, currVerIdx = 0; // tracks current index, both arrays
        int horizontalPieces = 1, verticalPieces = 1; // tracks count of hor/ver pieces, increases by 1 on each cut

        // sorting cost in descending order for greedy approach, less cost
        Arrays.sort(horizontalCost, Comparator.reverseOrder());
        Arrays.sort(verticalCost, Comparator.reverseOrder());

        while (currHorIdx < horizontalCost.length && currVerIdx < verticalCost.length) {

            if (horizontalCost[currHorIdx] >= verticalCost[currVerIdx]) {
                // cost of horizontal cut is greater
                totalCost += (horizontalCost[currHorIdx] * verticalPieces);
                horizontalPieces++;
                currHorIdx++;

            } else {
                // cost of vertical is greater
                totalCost += (verticalCost[currVerIdx] * horizontalPieces);
                verticalPieces++;
                currVerIdx++;
            }
        }

        // looping for remaining array cuts, horizontal cuts
        while (currHorIdx < horizontalCost.length) {
            totalCost += (horizontalCost[currHorIdx] * verticalPieces);
            horizontalPieces++;
            currHorIdx++;
        }

        // remaining vertical cuts
        while (currVerIdx < verticalCost.length) {
            totalCost += (verticalCost[currVerIdx] * horizontalPieces);
            verticalPieces++;
            currVerIdx++;
        }

        return totalCost;
    }

    public static void main(String[] args) {
        int startTime[] = { 1, 3, 0, 5, 8, 5 };
        int endTime[] = { 2, 4, 6, 7, 9, 9 };
        // actSelect(startTime, endTime);

        int weightOfItem[] = { 10, 20, 30 };
        int valueOfItem[] = { 60, 100, 120 };
        int maxCapacity = 50;
        // System.out.println(fractionalKnapsack(weightOfItem, valueOfItem,
        // maxCapacity));

        int pairs[][] = { { 5, 24 }, { 39, 60 }, { 5, 28 }, { 27, 40 }, { 50, 90 } };
        // System.out.println("Max Length: " + maxLengthChain(pairs));

        int indianR[] = { 1, 2, 5, 10, 20, 50, 100, 500, 2000 };
        // System.out.println("Coins: " + indianCoins(indianR, 551));

        int jobs[][] = { { 4, 20 }, { 1, 10 }, { 1, 40 }, { 1, 30 } };
        System.out.println(jobSequence(jobs));

        Integer v_cost[] = { 2, 1, 4, 1, 3 };
        Integer h_cost[] = { 1, 4, 2 };
        // System.out.println("Min Cost: " + chocola(v_cost, h_cost));

    }
}
