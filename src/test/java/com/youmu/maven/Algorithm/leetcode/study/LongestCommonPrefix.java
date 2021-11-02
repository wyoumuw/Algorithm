package com.youmu.maven.Algorithm.leetcode.study;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        int mixLength = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            String str = strs[i];
            if (mixLength > str.length()) {
                mixLength = str.length();
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < mixLength; i++) {
            char f = strs[0].charAt(i);
            for (int i1 = 1, i2 = strs.length - 1; i2 >= i1; i1++, i2--) {
                String str = strs[i1];
                String str2 = strs[i2];
                if (str.charAt(i) != f || str2.charAt(i) != f) {
                    return sb.toString();
                }
            }
            sb.append(f);
        }
        return sb.toString();
    }
}
