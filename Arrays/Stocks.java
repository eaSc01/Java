package Arrays;

public class Stocks {

    public static int BuySellPrice(int prices[]) {  
        int buyPrice = Integer.MAX_VALUE;                   //logical algorithm
        int maxProfit = 0;

        for (int today=0 ; today<prices.length ; today++) {
            if (buyPrice < prices[today]) {
                int CurrProfit = prices[today] - buyPrice;
                maxProfit = Math.max(maxProfit, CurrProfit);
            } else {
                buyPrice = prices[today];
            }
        }   return maxProfit;
    }

    public static int stockProfit(int value[]) {        //Bruteforce, TC: (O)n^2
        int maxProfit = Integer.MIN_VALUE;
        int cost = 0;

        for (int buyPrice=0 ; buyPrice<value.length ; buyPrice++) {
            for (int sellPrice = buyPrice + 1 ; sellPrice<value.length ; sellPrice++) {
                cost = (value[sellPrice] - value[buyPrice]);
                // System.out.println("COST: " + (value[sellPrice] - value[buyPrice]));
                maxProfit = Math.max(cost, maxProfit);
            }
        }
        return maxProfit;
    }
    public static void main(String args[]) {
        int stockValue[] = {7,1,5,3,6,4};
        System.out.println("MAX PROFIT: " + BuySellPrice(stockValue));
    }
}