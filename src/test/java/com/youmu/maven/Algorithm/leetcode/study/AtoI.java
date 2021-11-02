package com.youmu.maven.Algorithm.leetcode.study;

import org.junit.Test;

public class AtoI {
    public int myAtoi(String s) {
        int res = 0;
        int op = 1;
        boolean started = false;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == ' ' && !started) {
            } else if (c == '-' && !started) {
                started = true;
                op = -1;
            } else if (c == '+' && !started) {
                started = true;
                op = 1;
            } else if (c >= '0' && c <= '9') {
                //start
                started = true;
                //calc
                res *= 10;
                if (res % 10 != 0) {
                    if (op == 1) {
                        return Integer.MAX_VALUE;
                    } else {
                        return Integer.MIN_VALUE;
                    }
                }
                res += (c - '0');
                if (res < 0) {
                    if (op == 1) {
                        return Integer.MAX_VALUE;
                    } else {
                        return Integer.MIN_VALUE;
                    }
                }
            } else {
                break;
            }
        }
        return res * op;
    }

    @Test
    public void Test() throws Exception {
        System.out.println(new AtoI().myAtoi("42"));
        System.out.println(new AtoI().myAtoi("   -42"));
        System.out.println(new AtoI().myAtoi("4193 with words"));
        System.out.println(new AtoI().myAtoi("words and 987"));
        System.out.println(new AtoI().myAtoi("91283472332"));
        System.out.println(new AtoI().myAtoi("9223372036854775808"));
    }

    /**
     * 91283472332
     * 1089159116
     * 2147483647
     *
     * @throws Exception
     */
    @Test
    public void Test2() throws Exception {
        System.out.println(Integer.MAX_VALUE * 10);
        System.out.println(912834723 * 10);
    }
}
