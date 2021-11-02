package com.youmu.maven.Algorithm.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class S869 {
    static Map<Integer, List<int[]>> map = new HashMap<>();

    static {
        int i = 1;
        while (i <= 1000000000) {
            int[] bits = new int[10];
            List<int[]> integers = map.computeIfAbsent(len(i, bits), k -> new ArrayList<>());
            integers.add(bits);
            i <<= 1;
        }
    }

    static int len(int n, int[] bits) {
        int c = 0;
        while (n > 0) {
            c++;
            bits[n % 10]++;
            n /= 10;
        }
        return c;
    }

    public boolean reorderedPowerOf2(int n) {
        int[] bits = new int[10];
        int len = len(n, bits);
        List<int[]> ints = map.get(len);
        if (ints.isEmpty()) {
            return false;
        }
        for (int[] anInt : ints) {
            boolean same = true;
            for (int i = 0; i < 10; i++) {
                if (anInt[i] != bits[i]) {
                    same = false;
                    break;
                }
            }
            if (same) {
                return true;
            }
        }
        return false;
    }

    @Test
    public void Test() throws Exception {
        System.out.println(reorderedPowerOf2(1));
    }
    @Test
    public void Test2() throws Exception {
        System.out.println(reorderedPowerOf2(10));
    }
    @Test
    public void Test3() throws Exception {
        System.out.println(reorderedPowerOf2(16));
    }
    @Test
    public void Test4() throws Exception {
        System.out.println(reorderedPowerOf2(24));
    }
    @Test
    public void Test5() throws Exception {
        System.out.println(reorderedPowerOf2(46));
    }
    @Test
    public void Test6() throws Exception {
        System.out.println(reorderedPowerOf2(1));
    }
}
