package com.youmu.maven.Algorithm.sort;

/**
 * Created by wyoumuw on 2017/4/26.
 */
public class QuickSort implements Sortable {
    public void sort(int[] arr, Operator op) {
        qsort(arr,0,arr.length-1,op);
    }

    public void qsort(int[] arr,int start,int end, Operator op){
        if(start>=end){
            return;
        }
        int base=arr[start];
        int first=start;
        int last=end;
        while(first<last) {
            while (first < last&&(Operator.compare(base,arr[last],op)||base==arr[last])) last--;
            arr[first]=arr[last];
            while (first < last&&!(Operator.compare(base,arr[first],op)||base==arr[first])) first++;
            arr[last]=arr[first];
        }
        arr[first]=base;
        qsort(arr,start,first-1,op);
        qsort(arr,first+1,end,op);
    }


    public static void main(String[] args) {
        int[] arr = { 3, 2, 4, 5, 6, 2, 5, 6, 8, 1, 7 };
        new QuickSort().sort(arr,Operator.LOW);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
