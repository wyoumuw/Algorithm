package com.youmu.maven.Algorithm;

import org.junit.Before;

import java.util.Random;

/**
 * Created by dehua.lai on 2017/6/15.
 */
public abstract class BaseSearchTest {
	public int[] a;
	@Before
	public void setUp(){
		a= getRandomArray(100);
		System.out.println("search arr");
		print(a);
		System.out.print("the first result:");
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
