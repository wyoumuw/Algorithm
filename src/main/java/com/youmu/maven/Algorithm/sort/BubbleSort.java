package com.youmu.maven.Algorithm.sort;

public class BubbleSort implements Sortable{

	public static void main(String[] args) {
		int[] arr = { 3, 2, 4, 5, 6, 2, 5, 6, 8, 1, 7 };
		new BubbleSort().sort(arr);
		for (int i : arr) {
			System.out.print(i + " ");
		}

	}

	public void swap(int[] raw, int i, int j) {
		int bak = raw[i];
		raw[i] = raw[j];
		raw[j] = bak;
	}

	public void sort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 1; j < arr.length - i; j++) {
				if (arr[j]<arr[j - 1])
					swap(arr, j, j - 1);
			}
		}
	}
}
