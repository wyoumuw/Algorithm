package com.youmu.maven.Algorithm.leetcode;

import org.junit.Test;

public class S343 {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i - 1; j++) {
                dp[i] = Math.max(Math.max(j * dp[i - j], dp[i]), (i - j) * j);
            }
        }
        return dp[n];
    }

    @Test
    public void Test() throws Exception {
        System.out.println("x:" + integerBreak(20));
    }
}
