package com.youmu.maven.Algorithm;

import com.youmu.maven.Algorithm.sort.BubbleSort;
import com.youmu.maven.Algorithm.sort.RangedBucketSort;
import com.youmu.maven.Algorithm.sort.TenBucketSort;
import com.youmu.maven.Algorithm.sort.HeapSort;
import com.youmu.maven.Algorithm.sort.HeapSort2;
import com.youmu.maven.Algorithm.sort.MergeSort;
import com.youmu.maven.Algorithm.sort.QuickSort;
import org.junit.Test;

/**
 * Created by YOUMU on 2017/5/22.
 */
public class SortTest extends BaseSortTest {

    @Test
    public void bubbleTest() throws Exception {
        new BubbleSort().sort(getA());
        print(getA());
    }

    @Test
    public void quickTest() throws Exception {
        long start = System.nanoTime();
        new QuickSort().sort(getA());
        print(getA());
    }

    @Test
    public void heapTest() throws Exception {
        long start = System.nanoTime();
        new HeapSort().sort(getA());
        print(getA());
    }

    @Test
    public void heap2Test() throws Exception {
        long start = System.nanoTime();
        new HeapSort2().sort(getA());
        print(getA());
    }

    @Test
    public void mergeTest() throws Exception {
        long start = System.nanoTime();
        new MergeSort().sort(getA());
        print(getA());
    }

    @Test
    public void bucketTest() throws Exception {
        long start = System.nanoTime();
        new TenBucketSort().sort(getA());
        print(getA());
    }

    @Test
    public void rangeBucketTest() throws Exception {
        long start = System.nanoTime();
        new RangedBucketSort().sort(getA());
        print(getA());
    }
}
