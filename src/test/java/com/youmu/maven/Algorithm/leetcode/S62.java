package com.youmu.maven.Algorithm.leetcode;

import org.junit.Test;

public class S62 {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[n][m];
        for (int i = 0; i < m; i++) {
            dp[0][i] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[n - 1][m - 1];
    }

    @Test
    public void Test() throws  Exception{
        System.out.println(uniquePaths(3,2));
    }
    @Test
    public void Test2() throws  Exception{
        System.out.println(uniquePaths(7,3));
    }
    @Test
    public void Test3() throws  Exception{
        System.out.println(uniquePaths(3,3));
    }
}
