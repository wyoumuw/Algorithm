package com.youmu.maven.Algorithm.leetcode.study;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class TwoPlus {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            Integer index = map.get(num);
            if (index != null) {
                return new int[]{i, index};
            }
            map.put(target - num, i);
        }
        return new int[0];
    }

    @Test
    public void Test() throws Exception {
        twoSum(new int[]{2, 7, 11, 15}, 9);
    }
}
