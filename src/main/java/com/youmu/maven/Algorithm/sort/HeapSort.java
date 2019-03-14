package com.youmu.maven.Algorithm.sort;

public class HeapSort implements Sortable {

    static void print(int[] arr){
        for (int i : arr) {
            System.out.print(i+" ");
        }

    }

    public static void main(String[] args) {
        int arr[] = {2,34,5,131,5,23,43,35,23,413,24,52,34324,233,4,235,2,423,4};
        print(arr);
        new HeapSort().sort(arr);
        System.out.println();
        print(arr);
    }

    public void sort(int[] arr){
        heapify(arr,arr.length,0);
        int len=arr.length;
        while(len>0){
            swap(arr,0,len-1);
            len--;
            heapify(arr,len,0);
        }
    }

    void heapify(int[] arr,int len,int root){
        if(root>len-1){
            return;
        }
        int left=root*2+1,right=(root+1)*2;
        int max=-1;
        if(left<len&&arr[root]<arr[left]){
            max=left;
        }
        if(right<len&&arr[root]<arr[right]){
            max=right;
        }
        if(-1!=max){
            Sortable.swap(arr, max, root);
            up(arr,root);
        }
        heapify(arr,len,left);
        heapify(arr,len,right);
    }
    void up(int[] arr,int adj){
        if(adj<=0){
            //root
            return;
        }
        int root = (adj-1)/2;
        if(arr[adj]>arr[root]){
            swap(arr,root,adj);
            up(arr,root);
        }

    }

    void swap(int[] arr,int f,int n){
        int t=arr[f];
        arr[f]=arr[n];
        arr[n]=t;
    }

}
