package com.youmu.maven.Algorithm.leetcode;

import com.youmu.maven.Algorithm.leetcode.utils.SupportUtils;
import com.youmu.maven.Algorithm.utils.ArrayUtils;
import org.junit.Test;

public class S746 {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }
        ArrayUtils.printArray(dp);
        return Math.min(dp[cost.length - 1], dp[cost.length - 2]);
    }
    @Test
    public void Test() throws  Exception{
        System.out.println(minCostClimbingStairs(SupportUtils.asIntArr("[10, 15, 20]")));
    }
    @Test
    public void Test2() throws  Exception{
        System.out.println(minCostClimbingStairs(SupportUtils.asIntArr("[1, 100, 1, 1, 1, 100, 1, 1, 100, 1]")));
    }
}
