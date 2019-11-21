package com.youmu.maven.Algorithm;

import org.junit.Test;

/**
 * Created by wyoumuw on 2019/4/17.
 */
public class ComputeTest {

    @Test
    public void add() {
        Computer computer = new Computer();
        long end;
        long start = System.nanoTime();
        for (int i = 0; i < 20000000; i++) {
            computer.add(7, 7);
        }
        end = System.nanoTime();
        System.out.println(" compute add :" + (end - start));
        start = System.nanoTime();
        for (int i = 0; i < 20000000; i++) {
            result(7, 7);
        }
        end = System.nanoTime();
        System.out.println("       +     :" + (end - start));
    }

    public static int result(int a, int b) {
        return a + b;
    }
}
