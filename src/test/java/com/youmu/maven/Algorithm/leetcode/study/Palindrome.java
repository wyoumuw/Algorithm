package com.youmu.maven.Algorithm.leetcode.study;

public class Palindrome {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        char[] chars = s.toCharArray();
        int i = 0, j = s.length() - 1;
        while (i < j) {
            while (!((chars[i] >= '0' && chars[i] <= '9') || (chars[i] >= 'a' && chars[i] <= 'z')) && i < j) i++;
            while (!((chars[j] >= '0' && chars[j] <= '9') || (chars[j] >= 'a' && chars[j] <= 'z')) && i < j) j--;
            if (chars[i] != chars[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
