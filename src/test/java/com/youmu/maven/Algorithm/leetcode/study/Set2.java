package com.youmu.maven.Algorithm.leetcode.study;

import org.junit.Test;

import java.util.*;

public class Set2 {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>(Math.min(nums1.length, nums2.length));
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            Integer integer = map.get(i);
            if (integer == null) {
                integer = 0;
            }
            map.put(i, ++integer);
        }
        for (int i : nums2) {
            Integer integer = map.get(i);
            if (integer != null) {
                if (--integer >= 0) {
                    map.put(i, integer);
                    list.add(i);
                }
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
        Arrays.stream(intersect(new int[]{1,2,2,1}, new int[]{2,2})).forEach(System.out::println);
    }
}
