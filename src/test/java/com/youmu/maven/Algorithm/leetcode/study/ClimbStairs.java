package com.youmu.maven.Algorithm.leetcode.study;

import org.junit.Test;

public class ClimbStairs {

    public int climbStairs(int n) {
        if (n <= 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int a = 1, b = 2;
        for (int i = 2; i < n; i++) {
            int t = b;
            b = a + b;
            a = t;
        }
        return b;
    }

    @Test
    public void Test() throws Exception {
        System.out.println(climbStairs(2));
        System.out.println(climbStairs(3));
    }
}
