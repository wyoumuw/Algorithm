package com.youmu.maven.Algorithm.leetcode;

public class S477 {
    public int totalHammingDistance(int[] nums) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            int n1 = 0;
            for (int j = 0; j < nums.length; j++) {
                n1 += (nums[j] & 1);
                nums[j] = nums[j] >> 1;
            }
            count += ((nums.length - n1) * n1);
        }
        return count;
    }

    public int hammingDistance(int x, int y) {
        x = x ^ y;
        y = 0;
        while (x != 0) {
            if ((x & 1) == 1) {
                y++;
            }
            x = x >> 1;
        }
        return y;
    }


    public static void main(String[] args) {
        int i = new S477().totalHammingDistance(new int[]{4, 14, 2});
        System.out.println(i);
    }
}
