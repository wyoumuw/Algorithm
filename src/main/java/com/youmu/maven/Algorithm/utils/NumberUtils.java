package com.youmu.maven.Algorithm.utils;

/**
 * Created by wyoumuw on 2019/3/12.
 */
public final class NumberUtils {

    private NumberUtils(){

    }
    public static int getNumberLength(int val){
        int len=0;
        do{
            len++;
        }
        while ((val/=10)!=0);
      return len;
    }
}
