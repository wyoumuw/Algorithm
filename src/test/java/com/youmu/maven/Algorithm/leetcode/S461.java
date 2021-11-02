package com.youmu.maven.Algorithm.leetcode;

public class S461 {

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
        System.out.println(new S461().hammingDistance(1, 4));
    }
}
