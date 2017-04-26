package com.youmu.maven.Algorithm.sort;

/**
 * Created by wyoumuw on 2017/4/26.
 */
public interface Sortable {
    enum Operator{
        GREAT,
        LOW;
       public static boolean compare(int a,int b,Operator op){
            if(op.equals(Operator.GREAT)){
                return a<b;
            }else{
                return a>=b;
            }
        }
    }
    void sort(int[] arr,Operator op);
}
