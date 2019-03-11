package com.youmu.maven.Algorithm.search;

import java.util.Arrays;

/**
 * Created by wyoumuw on 2017/4/26.
 */
public class BinarySearch {

    public int recurrenceFind(int[] a,int ele){
        return recurrenceFind(a,0,a.length-1,ele);
    }

    /**
     *
     * @param a
     * @param start
     * @param end included
     * @param ele
     * @return
     */
    private int recurrenceFind(int[] a,int start,int end,int ele){
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
    public int foreachFind(int[] a,int ele){
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
}
