package com.youmu.maven.Algorithm;

import com.sun.xml.internal.messaging.saaj.util.Base64;
import com.youmu.maven.Algorithm.sort.BubbleSort;
import com.youmu.maven.Algorithm.sort.HeapSort;
import com.youmu.maven.Algorithm.sort.HeapSort2;
import com.youmu.maven.Algorithm.sort.MergeSort;
import com.youmu.maven.Algorithm.sort.QuickSort;
import org.junit.Test;

import java.util.Random;

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
}
