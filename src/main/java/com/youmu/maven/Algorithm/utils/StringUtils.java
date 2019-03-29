package com.youmu.maven.Algorithm.utils;

/**
 * Created by wyoumuw on 2019/3/23.
 */
public final class StringUtils {
    private StringUtils() {
    }

    public static String repeat(String str, int repeat) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < repeat; i++) {
            stringBuilder.append(str);
        }
        return stringBuilder.toString();
    }
}
