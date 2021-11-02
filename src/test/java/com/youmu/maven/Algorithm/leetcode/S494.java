package com.youmu.maven.Algorithm.leetcode;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

public class S494 {
    Deque<Integer> temp = new LinkedList<>();

    public int findTargetSumWays(int[] nums, int target) {
        return reduce(nums, 0, 0, target);
    }

    private int reduce(int[] nums, int total, int nextIndex, int target) {
        if (nextIndex == nums.length) {
            return total == target ? 1 : 0;
        }
        int i = reduce(nums, total + nums[nextIndex], nextIndex + 1, target);
        i += reduce(nums, total - nums[nextIndex], nextIndex + 1, target);
        return i;
    }

    private void print() {
        for (Integer integer : temp) {
            if (integer >= 0) {
                System.out.print("+" + integer);
            } else {
                System.out.print(integer);
            }
        }
        System.out.println();
    }

    @Test
    public void Test() throws Exception {
        int[] nums = {};
        int target = 0;
        System.out.println(findTargetSumWays(nums, target));
    }

    @Test
    public void Test2() throws Exception {
        int[] nums = {1, 1, 1, 1, 1};
        int target = 3;
        System.out.println(findTargetSumWays(nums, target));
    }
}
