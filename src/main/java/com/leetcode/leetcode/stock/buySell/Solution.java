package com.leetcode.leetcode.stock.buySell;


public class Solution {


    public int maxProfit(int[] prices) {

        int maxProfit = 0;
        int minPrice = 99999999;

        for (int i = 0; i < prices.length; i ++){
            if (prices[i] < minPrice){
                minPrice = prices[i];
            }
            else{
                int profit = prices[i] - minPrice;
                maxProfit = Math.max(maxProfit, profit);
            }
        }
        return maxProfit;
        
    }
}
