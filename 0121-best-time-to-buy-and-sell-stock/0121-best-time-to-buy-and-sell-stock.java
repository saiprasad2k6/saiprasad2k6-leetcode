class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minBuyingPrice = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length; i++) {
            minBuyingPrice = Math.min(minBuyingPrice, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minBuyingPrice);
        }

        return maxProfit;
    }
}