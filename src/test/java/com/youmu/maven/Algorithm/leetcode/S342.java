package com.youmu.maven.Algorithm.leetcode;

public class S342 {
    public boolean isPowerOfFour(int n) {
        if(n<=0)return false;
        return ((n&(n-1))==0)&&((n&0x55555555)!=0);
    }

    public static void main(String[] args) {
        System.out.println(new S342().isPowerOfFour(20));
    }
}
