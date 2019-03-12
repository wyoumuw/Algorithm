package com.youmu.maven.Algorithm;

import com.youmu.maven.Algorithm.search.BinarySearch;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by YOUMU on 2017/6/15.
 */
public class SearchTest extends BaseSearchTest{
	@Test
	public void brsearch(){
		Arrays.sort(a);
		int find=8;
		BinarySearch binarySearch=new BinarySearch();
		long start=System.nanoTime();
		int re=binarySearch.recurrenceFind(a,find);
		System.out.println("used:"+(System.nanoTime()-start));
		System.out.println(a[re]);
	}
	@Test
	public void bfsearch(){
		Arrays.sort(a);
		int find=8;
		BinarySearch binarySearch=new BinarySearch();
		long start=System.nanoTime();
		int re=binarySearch.foreachFind(a,find);
		System.out.println("used:"+(System.nanoTime()-start));
		System.out.println(a[re]);
	}
}
