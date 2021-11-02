package com.youmu.maven.Algorithm.leetcode.study;

import com.youmu.maven.Algorithm.utils.ArrayUtils;
import org.junit.Test;

public class Plus1 {
    public int[] plusOne(int[] digits) {
        int in = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int digit = digits[i];
            if (digit + in == 10) {
                digits[i] = 0;
            } else {
                digits[i] = digit + in;
                in = 0;
                break;
            }
        }
        if (in == 1) {
            int[] temp = new int[digits.length + 1];
            System.arraycopy(digits, 0, temp, 1, digits.length);
            temp[0] = 1;
            digits = temp;
        }
        return digits;
    }

    @Test
    public void Test() throws Exception {
        ArrayUtils.printArray(plusOne(new int[]{1, 2, 3}));
    }
    @Test
    public void Test2() throws Exception {
        ArrayUtils.printArray(plusOne(new int[]{9}));
    }
}
