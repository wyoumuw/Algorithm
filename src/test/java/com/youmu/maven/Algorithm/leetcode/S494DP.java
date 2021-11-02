package com.youmu.maven.Algorithm.leetcode;

import com.youmu.maven.Algorithm.leetcode.utils.SupportUtils;
import org.junit.Test;

public class S494DP {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        //设x位从nums中选的一部分数的和，那么x>=0
        //x-(sum-x)=target
        //x=(target+sum)/2
        for (int num : nums) {
            sum += num;
        }
        if ((sum + target) % 2 != 0) {
            return 0;
        }
        int t = (sum + target) / 2;
        if (t < 0) {
            return 0;
        }
        int[][] dp = new int[nums.length + 1][t + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j <= t; j++) {
                if (j < nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[nums.length][t];
    }

    @Test
    public void Test() throws Exception {
        System.out.println(findTargetSumWays(SupportUtils.asIntArr("[0,0,0,0,0,0,0,0,1]"), 1));
    }
}
