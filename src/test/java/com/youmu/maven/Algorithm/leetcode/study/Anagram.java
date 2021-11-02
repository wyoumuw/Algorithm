package com.youmu.maven.Algorithm.leetcode.study;

import java.util.Arrays;

public class Anagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] sa = s.toCharArray();
        char[] ta = t.toCharArray();
        Arrays.sort(sa);
        Arrays.sort(ta);
        for (int i = 0; i < ta.length; i++) {
            if (sa[i] != ta[i]) {
                return false;
            }

        }
        return true;
    }
}
