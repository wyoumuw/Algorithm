package com.youmu.maven.Algorithm.leetcode;

import com.youmu.maven.Algorithm.utils.ArrayUtils;

public class S416 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int[] dp = new int[10001];
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 == 1) return false;
        int target = sum / 2;
        // 开始 01背包
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
            ArrayUtils.printArray(dp);
        }
        // 集合中的元素正好可以凑成总和target
        if (dp[target] == target) return true;
        return false;
    }
}
