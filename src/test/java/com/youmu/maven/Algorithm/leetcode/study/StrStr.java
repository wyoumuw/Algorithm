package com.youmu.maven.Algorithm.leetcode.study;

import org.junit.Test;

public class StrStr {
    public int strStr(String haystack, String needle) {
        char[] origin = haystack.toCharArray();
        char[] find = needle.toCharArray();
        if (find.length == 0) {
            return 0;
        }
        for (int i = 0; i < origin.length - find.length + 1; i++) {
            if (equals(origin, i, find)) {
                return i;
            }
        }
        return -1;
    }

    boolean equals(char[] origin, int start, char[] find) {
        for (int i = 0, j = find.length - 1; i <= j; i++, j--) {
            char c = find[i];
            char e = find[j];
            if (origin[start + i] != c || origin[start + j] != e) {
                return false;
            }
        }
        return true;
    }


    @Test
    public void Test() throws Exception {
        new StrStr().strStr("hello", "ll");
    }
}
