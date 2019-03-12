package com.youmu.maven.Algorithm;

import org.junit.Before;

import java.util.Random;

/**
 * Created by YOUMU on 2017/5/22.
 */
public class BaseSortTest  {
    public int[] a;
    @Before
    public void setUp(){
        int arrLen=new Random().nextInt(20);
        a= getRandomArray(arrLen);
        System.out.println("before sort");
        print(a);
        System.out.println("after sort");
    }
    public static void print(int[] arr){
        for (int i : arr) {
            System.out.print(i+" ");
        }
        System.out.println();
    }
    private int[] getRandomArray(int length){
        int[] arr=new int[length];
        Random r=new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i]=r.nextInt(16);
        }
        return arr;
    }

    public int[] getA() {
        return a;
    }
}
