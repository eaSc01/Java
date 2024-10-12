public class BestTimeToBuyStocks {
    public static void main(String[] args) {
        int[] prices = { 7, 1, 5, 3, 6, 4 };
        int maxProfit = maxProfitStocks(prices);
        System.out.println(maxProfit);
    }

    public static int maxProfitStocks(int[] prices) {
        int maxProfit = 0;
        int buyingPrice = Integer.MAX_VALUE;

        for (int i = 0; i<prices.length; i++) {
            buyingPrice = Math.min(buyingPrice, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - buyingPrice);
        }

        return maxProfit;
    }
}
