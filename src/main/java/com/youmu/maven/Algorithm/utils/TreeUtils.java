package com.youmu.maven.Algorithm.utils;

import java.util.Arrays;
import java.util.OptionalInt;

/**
 * Created by wyoumuw on 2019/3/11.
 */
public final class TreeUtils {
    private TreeUtils(){}


    public static void printHeap(int[] arr){
        int high = (int) Math.ceil(Math.log(arr.length)/Math.log(2));
        int maxNum= (int) Math.pow(2,high-1);
        OptionalInt max = Arrays.stream(arr).max();

        //为了好看做的格式化
        if(!max.isPresent()){
            return;
        }
        StringBuilder stringBuilder=new StringBuilder();
        int maxLen=NumberUtils.getNumberLength(max.getAsInt());
        // 最大3位数进行格式化
        String format="% "+maxLen+"d";

        for (int i = 0,index=0; i < high; i++) {
            int curNum= (int) Math.pow(2,i);
            for (int j = 0; j <maxNum; j++) {
                if(maxNum-1-j>i){
                    System.out.print("*");
                }
            }
            //输出那层所有的数据并且处理一下非满二叉树的情况
            for (int j = 0; j < curNum && index<arr.length; j++,index++) {
                System.out.print(String.format(format, arr[index]));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int arr[] = {0,1,2,3,4,5,16};
        printHeap(arr);
    }
}
//-x+3=y
//
//** 1*
//* 1* 1*
// 1* 1* 1*

/*
*** 0
** 1 2
* 3 4 5 16
*/
