package com.youmu.maven.Algorithm.leetcode;

import org.junit.Test;

import java.util.Arrays;

public class S215 {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }


    @Test
    public void Test() throws Exception {
        System.out.println(findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
    }
}
