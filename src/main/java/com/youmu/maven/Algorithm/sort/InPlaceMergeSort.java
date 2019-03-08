package com.youmu.maven.Algorithm.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by wyoumuw on 2019/3/8.
 */
public class InPlaceMergeSort implements Sortable {
    public void sort(int[] arr, Operator op) {
        mainMergeSort(arr, 0, arr.length / 2 + 1, arr.length);
    }

    public void mainMergeSort(int[] arr, int lstart, int rstart, int rend) {
        if (lstart >= rstart) {
            return;
        }
        mainMergeSort(arr, lstart, ((rstart - lstart)) / 2 + lstart, rstart);
        mainMergeSort(arr, rstart, ((rend - rstart)) / 2 + rstart, rend);
        System.out.println("before");
        Sortable.print(Arrays.copyOfRange(arr, lstart, rend));
        System.out.println();
        mergeSort(arr, lstart, rstart, rend);
        System.out.println("end");
        Sortable.print(Arrays.copyOfRange(arr, lstart, rend));
        System.out.println();
    }

    public void mergeSort(int[] arr, int lstart, int rstart, int length) {
        int li = lstart;
        int ri = rstart;
        if (ri <= li || ri >= length) {
            return;
        }
        while (li < rstart && arr[li] < arr[ri]) li++;
        while (ri < length && arr[li] >= arr[ri]) ri++;
        reverse(arr, li, ri, rstart);
        while (li < ri && ri < length && arr[ri] > arr[li]) li++;
        mergeSort(arr, li, ri, length);
    }

    // 10 20 25 30 50 60 80 55 65 73
    //                li    ri
    //
    //
    public void reverse(int[] arr, int start, int length, int mid) {
        reverse(arr, start, mid);
        reverse(arr, mid, length);
        reverse(arr, start, length);
    }

    public void reverse(int[] arr, int start, int length) {
        int li = start;
        int ri = length - 1;
        while (li < ri) {
            Sortable.swap(arr, li, ri);
            li++;
            ri--;
        }
    }

    public static void main(String[] args) {
//        int a[] = {10, 30, 50, 60, 80, 20, 25, 55, 65, 73};
        int a[] = generateData(21);
        Sortable.print(a);
        System.out.println();
//        int a[] = {80, 20, 30};
        new InPlaceMergeSort().sort(a, null);
        Sortable.print(a);
        System.out.println();
        Arrays.sort(a);
        System.out.println("cur");
        Sortable.print(a);
    }

    public static int[] generateData(int len) {
        int[] a = new int[len];
        Random random = new Random();
        for (int i = 0; i < len; i++) {
            a[i] = random.nextInt(1000);
        }
        return a;
    }

}
