public class StocksMaxProfit {

    public static int maxProfit(int prices[]) {
        
        int maxProfit = 0, buyPrice = Integer.MAX_VALUE;
        for (int day=0 ; day<prices.length ; day++) {       //day = current day
            //profitDay
            if (buyPrice < prices[day]) {
                int profitToday = prices[day] - buyPrice;
                maxProfit = Math.max(profitToday, maxProfit);
                
            //buying current stocks for the profit in future
            } else {
                buyPrice = prices[day];
            }
        }   return maxProfit;
    }
    public static void main(String args[]) {
        int stockPrices[] = {7, 6, 4, 3, 1};
        System.out.println(maxProfit(stockPrices));
    }
}