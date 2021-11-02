package com.youmu.maven.Algorithm.leetcode.study;

import org.junit.Test;

public class VersionControl {

    private boolean[] g = new boolean[]{false, false, false, false, true, true};

    public int firstBadVersion(int n) {
        int start = 1, end = n;
        while (start < end) {
            int i = (end - start) / 2 + start;
            if (isBadVersion(i)) {
                end = i;
            } else {
                start = i + 1;
            }
        }
        return start;
    }


    boolean isBadVersion(int version) {
        return version == Integer.MAX_VALUE;
    }

    @Test
    public void Test() throws Exception {
        int n = 4, t = 5;
        g = new boolean[t + 1];
        for (int i = 1; i < g.length; i++) {
            g[i] = i >= n;
        }
        System.out.println(firstBadVersion(t));
    }
}
