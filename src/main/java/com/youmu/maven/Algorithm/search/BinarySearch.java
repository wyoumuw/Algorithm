package com.youmu.maven.Algorithm.search;

import java.util.Arrays;

/**
 * Created by wyoumuw on 2017/4/26.
 */
public class BinarySearch {


    public static int recurrenceFind(int[] a,int start,int end,int ele){
        int len=end-start+1;
        if(len<=0){
            return -1;
        }
        int element=a[start+len/2];
        if(element>ele) return recurrenceFind(a,start,start+len/2-1,ele);
        else if(element<ele) return recurrenceFind(a,start+len/2,end,ele);
        else {
            return start+len/2;
        }
    }


    public static void main(String[] args) {
        int[] arr = { 3, 2, 4, 5, 6, 2, 5, 6, 8, 1, 7 };
        Arrays.sort(arr);
        printArr( arr);

        int find=8;
        int re=recurrenceFind(arr,0,arr.length-1,find);
        System.out.println("recurrenceFind find:"+find+" index:"+re+" ele:"+arr[re]);
        re=foreachFind(arr,find);
        System.out.println("foreachFind find:"+find+" index:"+re+" ele:"+arr[re]);

    }



    public static int foreachFind(int[] a,int ele){
       int start=0;
       int end=a.length-1;
       int len=0;
       while((len=end-start)>0){
           int offset=len/2;
           int element=a[start+offset];
           if(element>ele) {
               end=start+offset-1;
           }else if(element<ele){
               start=start+offset;
           }else {
               return start+offset;
           }
       }
       return -1;
    }

    public static void printArr(int[] arr){
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
