package com.youmu.maven.Algorithm.leetcode;

import org.junit.Test;

public class S1049 {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int i = 0; i < stones.length; i++) {
            int stone = stones[i];
            sum += stone;
        }
        int half = sum / 2;
        int[][] dp = new int[stones.length][half + 1];
        //初始化dp
        for (int i = 1; i <= half; i++) {
            dp[0][i] = (i >= stones[0] ? stones[0] : 0);
        }
        for (int i = 1; i < stones.length; i++) {
            for (int j = 1; j <= half; j++) {
                if (j < stones[i]) dp[i][j] = dp[i - 1][j];
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - stones[i]] + stones[i]);
            }
        }
        return sum - (dp[stones.length - 1][half] * 2);
    }

    @Test
    public void Test() throws Exception {
        int[] stones = {1,2};
        System.out.println(lastStoneWeightII(stones));
    }
}
