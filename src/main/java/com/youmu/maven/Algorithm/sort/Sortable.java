package com.youmu.maven.Algorithm.sort;

/**
 * Created by wyoumuw on 2017/4/26.
 */
public interface Sortable {
    void sort(int[] arr);

    static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int i1 = arr[i];
            System.out.print(i1);
            System.out.print(" ");
        }
    }
}
