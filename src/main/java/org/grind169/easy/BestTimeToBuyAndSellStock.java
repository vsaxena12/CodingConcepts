package org.grind169.easy;

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int profit = 0;

        for(int i=0, j=0; i<prices.length; i++) {
            if(prices[i] <= prices[j]) {
                j=i;
            }
            else {
                profit = Math.max(profit, prices[i]-prices[j]);
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock stock = new BestTimeToBuyAndSellStock();
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(stock.maxProfit(prices)); // Output: 5
    }

    // Brute force approach
    // Time complexity: O(n^2)
    // Space complexity: O(1)
    public int maxProfitUsingBruteForce(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] - prices[i] > maxProfit) {
                    maxProfit = prices[j] - prices[i];
                }
            }
        }
        return maxProfit;
    }
    
}
