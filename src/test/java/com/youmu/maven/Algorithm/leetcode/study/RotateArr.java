package com.youmu.maven.Algorithm.leetcode.study;

public class RotateArr {
    public void rotate(int[] nums, int k) {
        int[] numsTemp = new int[nums.length];
        for (int i = 0; i < numsTemp.length; i++) {
            numsTemp[i] = nums[(i + numsTemp.length - k - 1) % numsTemp.length];
        }
        for (int i = 0; i < numsTemp.length; i++) {
            int i1 = numsTemp[i];
            nums[i] = i1;
        }
    }
}
