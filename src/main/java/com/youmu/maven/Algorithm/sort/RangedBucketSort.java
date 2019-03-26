package com.youmu.maven.Algorithm.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: YOUMU
 * @Description: 范围桶排序算法。 主要思路: 将总数据按照一定规则划分成许多小块，然后对所有小块进行排序算法，再合并其结果。
 *               这里拆数据的时间复杂度是O(n)对于一个数据来说找到他的位置是O(1)。所以桶排序的时间复杂度是O(n*k)
 *               k为其排序算法的时间复杂度 对于同排序来说其时间复杂度与空间复杂度是根据桶的数目来决定的，
 *               如果桶的数目=数据量大小的话就变成了“基数排序”但是空间复杂度就很高 时间复杂度为O(n) 除法的含义:
 *               在这个算法里除法含义既是-给出来的数据D给出桶的范围R,那么D/R既是数据D跨过D/R个范围R，也就是跨过多少个桶。其余数既是跨过D/R个整桶后下个桶（一定是下个桶）的桶内某处
 * @Date: 2019/03/25
 */
public class RangedBucketSort implements Sortable {

    // 桶容量，在创建桶堆的时候根据数据量和桶容量计算桶的数目。(并不代表桶只会装bucketCap个数据，只是为了竟可能合理分配桶数目
    // 只有dynamicBucketCap=false才生效
    private int bucketCap = 5;

    // 动态计算桶大小开关，使用bucketCapFactor和数据量去计算每个桶的容量，bucketCap=数据量*bucketCapFactor。相当于间接设置桶数量，和只有bucketCap一样不是绝对的桶容量
    // 只有dynamicBucketCap=true才生效
    private boolean dynamicBucketCap = false;
    // 只有dynamicBucketCap=true才生效
    private double bucketCapFactor = 0.1;

    @Override
    public void sort(int[] arr) {
        int len = arr.length;
        if (0 == len) {
            return;
        }
        int max = max(arr);
        int min = min(arr);
        int bucketCount = bucketCount(len);// 计算桶的个数，其实没必要，直接写死即可
        List<List<Integer>> buckets = createBuckets(bucketCount);// 初始化桶
        int range = (max + bucketCount - min) / bucketCount;// range是桶里能放的数据的跨度，max-min是为了做数据对齐，让数据从0开始。
        // 对于 0 1 2 3 4 5 6 7 8 这个数据如果分成2个桶则就变成了0 1 2 3|4 5 6 7 8
        // 这里发生了桶溢出，也就是说桶原本容量是4(8/2)多了一个应该到第3个桶的。为了消除这里的判断就扩大一个桶的数据量使得一个桶融入更多数据，消除判断
        range = 0 == range ? 1 : range;// 防止除0
        // O(n*n)其实不完全，最坏的情况既是只有一个桶，所有数据都放入一个桶的时候。最好的情况是每个桶只有1个数据，时间复杂度是O(n*1)
        for (int i = 0; i < arr.length; i++) {
            int ele = arr[i];
            insertOrder(buckets.get((ele - min) / range), ele); // 计算存放的桶，并且放入
        }
        // 按顺序从桶里吧数据全部取出既是顺序数据
        // O(n)
        int i = 0;
        for (List<Integer> bucket : buckets) {
            for (Integer integer : bucket) {
                arr[i++] = integer;
            }
        }
    }

    /**
     * 按照顺序插入数据，如果是顺序的数据就是On如果是倒序的数据就是O1
     * @param list
     * @param ele
     * @tc O(n)
     */
    private void insertOrder(List<Integer> list, int ele) {
        int i;
        for (i = 0; i < list.size(); i++) {
            Integer integer = list.get(i);
            if (ele < integer) {
                break;
            }
        }
        list.add(i, ele);
    }

    /**
     * 创建桶
     * @param len 桶的数目
     * @return
     * @tc O(n)
     */
    private List<List<Integer>> createBuckets(int len) {
        List<List<Integer>> buckets = new ArrayList<>(len);
        for (int i = 0; i < len; i++) {
            buckets.add(new ArrayList<>());
        }
        return buckets;
    }

    /**
     * 获取数组最大值
     * @tc O(n)
     */
    private int max(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int i1 = arr[i];
            if (i1 > max) {
                max = i1;
            }
        }
        return max;
    }

    /**
     * 获取数组最小值
     * @tc O(n)
     */
    private int min(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int i1 = arr[i];
            if (i1 < min) {
                min = i1;
            }
        }
        return min;
    }

    // -----------------下面的方法纯属扯淡------------------//
    /**
     * 计算桶的个数
     * @param len 数据量大小
     * @return
     * @tc O(1)
     */
    private int bucketCount(int len) {
        int count = len / getBucketCap(len);
        return 0 == count ? 1 : count;
    }

    /**
     * 桶的容量
     * @param len 数据量大小
     * @return
     * @tc O(1)
     */
    private int getBucketCap(int len) {
        if (dynamicBucketCap) {
            return (int) Math.ceil(len * bucketCapFactor);
        }
        return bucketCap;
    }
}
