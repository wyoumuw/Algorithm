package com.youmu.maven.Algorithm.leetcode;

import java.util.HashMap;

public class S560 {

    public int subarraySum(int[] nums, int k) {
        int count = 0, pre = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (mp.containsKey(pre - k)) {
                count += mp.get(pre - k);
            }
            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int i = new S560().subarraySum(new int[]{-44, 4, 7}, 7);
        System.out.println(i);
    }
}
