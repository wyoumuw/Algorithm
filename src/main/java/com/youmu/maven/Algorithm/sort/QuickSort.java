package com.youmu.maven.Algorithm.sort;

/**
 * Created by wyoumuw on 2017/4/26.
 */
public class QuickSort implements Sortable {
    public void sort(int[] arr) {
        qsort(arr,0,arr.length-1);
    }

    public void qsort(int[] arr,int start,int end){
        if(start>=end){
            return;
        }
        int base=arr[start];
        int first=start;
        int last=end;
        while(first<last) {
            //find first element that greater than {base} from right
            while (first < last&&base<=arr[last]) last--;
            //swap
            arr[first]=arr[last];
            //find first element that lower than {base} from left
            while (first < last&&base>=arr[first]) first++;
            arr[last]=arr[first];
        }
        arr[first]=base;
        qsort(arr,start,first-1);
        qsort(arr,first+1,end);
    }


    public static void main(String[] args) {
        int[] arr = { 3, 2, 4, 5, 6, 2, 5, 6, 8, 1, 7 };
        new QuickSort().sort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
