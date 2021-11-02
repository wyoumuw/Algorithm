package com.youmu.maven.Algorithm.leetcode;

public class S5 {
    public String longestPalindrome(String s) {
        int start = 0, end = 0;
        int len = 1;
        for (int i = 0; i < s.length() && s.length() - i > len; i++) {
            for (int j = s.length() - 1; j >= i; j--) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (isPalindrome(s, i, j) && (j - i + 1) > len) {
                        start = i;
                        end = j;
                        len = end - start + 1;
                        break;
                    }
                }
            }
        }
        return new String(s.toCharArray(), start, end - start + 1);
    }

    boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
