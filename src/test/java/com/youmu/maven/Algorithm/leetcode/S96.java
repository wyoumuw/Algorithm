package com.youmu.maven.Algorithm.leetcode;

import org.junit.Test;

public class S96 {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[i - j] * dp[j - 1];
            }
//            System.out.printf("dp[%d]=%d\n", i, dp[i]);
        }
        return dp[n];
    }

    @Test
    public void Test() throws Exception {
        System.out.println(numTrees(10));
    }
}
