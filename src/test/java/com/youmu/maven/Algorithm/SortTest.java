package com.youmu.maven.Algorithm;

import com.youmu.maven.Algorithm.sort.BubbleSort;
import com.youmu.maven.Algorithm.sort.HeapSort;
import com.youmu.maven.Algorithm.sort.MergeSort;
import com.youmu.maven.Algorithm.sort.QuickSort;
import org.junit.Test;

/**
 * Created by dehua.lai on 2017/5/22.
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
    public void mergeTest() throws Exception {
        long start = System.nanoTime();
        new MergeSort().sort(getA());
        print(getA());
    }
}
