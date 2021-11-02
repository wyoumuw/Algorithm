package com.youmu.maven.Algorithm.leetcode.study;

public class Stock2 {
    public int maxProfit(int[] prices) {
        boolean hasStock = false;
        int sum = 0, stock = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (hasStock && prices[i] > prices[i + 1]) {
                sum += (prices[i] - stock);
                hasStock = false;
            } else if (!hasStock && prices[i] < prices[i + 1]) {
                hasStock = true;
                stock = prices[i];
            }
        }
        if (hasStock) {
            sum += (prices[prices.length - 1] - stock);
        }
        return sum;
    }
}
