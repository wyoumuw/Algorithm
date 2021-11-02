package com.youmu.maven.Algorithm.utils;

import java.util.stream.IntStream;

public class ArrayUtils {
    public static final void printArray(int[] arr) {
        System.out.print("[");
        IntStream.of(arr).forEach(i -> System.out.print(i + "，"));
        System.out.print("]");
    }

    public static final void printSquare(int[][] arr){
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt+" ");
            }
            System.out.println();
        }

    }
}
