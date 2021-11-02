package com.youmu.maven.Algorithm.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class S525 {

    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int pre = 0;
        int maxLength = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            pre += (num == 0 ? -1 : 1);
            if (map.containsKey(pre)) {
                Integer index = map.get(pre);
                if ((i - index) > maxLength) {
                    maxLength = i - index;
                }
            } else {
                map.put(pre, i);
            }
        }
        return maxLength;
    }

    @Test
    public void Test() throws Exception {
        int[] nums = {0, 1};
        System.out.println(findMaxLength(nums));
    }


    @Test
    public void Test1() throws Exception {
        int[] nums = {0, 1, 0, 1, 1, 1, 0};
        System.out.println(findMaxLength(nums));
    }
}
