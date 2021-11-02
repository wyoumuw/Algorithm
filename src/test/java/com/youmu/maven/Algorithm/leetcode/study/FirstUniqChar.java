package com.youmu.maven.Algorithm.leetcode.study;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqChar {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {
                map.put(chars[i], -1);
            } else {
                map.put(chars[i], i);
            }
        }
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if (-1 != map.get(aChar)) {
                return i;
            }
        }
        return -1;
    }
}
