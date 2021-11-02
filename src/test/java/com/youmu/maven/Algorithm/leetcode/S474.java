package com.youmu.maven.Algorithm.leetcode;

import org.junit.Test;

public class S474 {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][][] dp = new int[strs.length][m + 1][n + 1];
        int num1 = 0, num0 = 0;
        for (int i = 0; i < strs[0].length(); i++) {
            if (strs[0].charAt(i) == '1') {
                num1++;
            } else {
                num0++;
            }
        }
        for (int i = 0; i < dp[0].length; i++) {
            for (int j = 0; j < dp[0][i].length; j++) {
                if (i >= num0 && j >= num1) {
                    dp[0][i][j] = 1;
                }
            }
        }
        for (int i = 1; i < strs.length; i++) {
            //计算0和1的个数
            num1 = 0;
            num0 = 0;
            for (int x = 0; x < strs[i].length(); x++) {
                if (strs[i].charAt(x) == '1') {
                    num1++;
                } else {
                    num0++;
                }
            }
            for (int j = 0; j < dp[i].length; j++) {
                for (int k = 0; k < dp[i][j].length; k++) {
                    if (j < num0 || k < num1) {
                        dp[i][j][k] = dp[i - 1][j][k];
                    } else {
                        dp[i][j][k] = Math.max(dp[i - 1][j - num0][k - num1] + 1, dp[i - 1][j][k]);
                    }
                }
            }
        }
        return dp[strs.length - 1][m][n];
    }

    @Test
    public void Test() throws Exception {
        int maxForm = findMaxForm(new String[]{"10", "0001", "111001", "1", "0"}, 5, 3);
        System.out.println(maxForm);
    }
    @Test
    public void Tes2t() throws Exception {
        int maxForm = findMaxForm(new String[]{"10","0001","111001","1","0"}, 4, 3);
        System.out.println(maxForm);
    }

}
