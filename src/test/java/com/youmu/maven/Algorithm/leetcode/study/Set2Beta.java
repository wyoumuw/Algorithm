package com.youmu.maven.Algorithm.leetcode.study;

import org.junit.Test;

import java.util.*;

public class Set2Beta {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>(Math.min(nums1.length, nums2.length));
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        for (int i = 0, j = 0; i < nums1.length && j < nums2.length; ) {
            if (nums1[i] == nums2[j]) {
                list.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                i++;
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }


    @Test
    public void Test() throws Exception {
        Arrays.stream(intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})).forEach(System.out::println);
    }

    @Test
    public void Test2() throws Exception {
        Arrays.stream(intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2})).forEach(System.out::println);
    }
}
