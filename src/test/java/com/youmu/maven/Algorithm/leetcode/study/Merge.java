package com.youmu.maven.Algorithm.leetcode.study;

public class Merge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i1 = 0, i2 = 0;
        while (i2 < n && i1 < m) {
            if (nums1[i1] >= nums2[i2]) {
                blanking(nums1, i1, m);
                nums1[i1] = nums2[i2];
                i1++;
                i2++;
                m++;
            } else {
                i1++;
            }
        }
        if (i2 < n) {
            for (int i = i2; i < n; i++, i1++) {
                nums1[i1] = nums2[i];
            }
        }
    }

    private void blanking(int[] nums1, int start, int len) {
        for (int i = len; i > start; i--) {
            nums1[i] = nums1[i - 1];
        }
    }
}
