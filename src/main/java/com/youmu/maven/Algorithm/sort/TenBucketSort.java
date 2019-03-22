package com.youmu.maven.Algorithm.sort;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * @Author: YOUMU
 * @Description: 标准10桶排序 这个桶排序需要10个桶，因为是按10进制数的位数进行循环排序，每次都需要10个桶 排序思路：
 *               输入数组为arr，给10个桶分别是0~9编号，这里的编号表示数组每个数在每一次排序中对应位数上的数字
 *               先取出arr中最大的数字，获取到其最大位数，循环0到最大位数
 *               每次循环对arr中每一个数获取其对应位数(i)上的数字，直接放入桶中，然后循环把桶里的数据放入原数组arr中，此时完成一次排序
 *               上面做完一次循环arr的数据会变得有序一点，位数少的会在前面，位数多的在后面。位数小的在前面，位数大的在后面
 *               个位-十位-百位....一次循环位数上的数变得有顺序，虽然后面的循环会破坏其原有顺序，不过他们"其实内部已经有序了"
 *               时间复杂度 ？？？？？？？？？？？？？？？？？ <br >
 *               ps:这个方法排序负数会有问题
 * @Date: 2019/03/22
 */
public class TenBucketSort implements Sortable {
    @Override
    public void sort(int[] arr) {
        int len = arr.length;
        // 创建10个桶，为了防止运算时候所有数据都进入一个桶，所以桶大小为数据长度
        int[][] buckets = new int[10][len];
        // 记录每个桶里装有多少大小
        int[] bucketContent = new int[10];
        // 初始化桶的内容
        Arrays.fill(bucketContent, -1);
        int maxIndex = indexOfMax(arr);
        int maxLen = numberLenInBase(arr[maxIndex]);
        for (int i = 0; i < maxLen; i++) {
            for (int j = 0; j < len; j++) {
                int numberBitInBase = getNumberBitInBase(arr[j], i + 1);
                buckets[numberBitInBase][++bucketContent[numberBitInBase]] = arr[j];
            }
            int bc = 0;
            for (int j = 0; j < len; j++) {
                if (-1 == bucketContent[bc]) {
                    // 是空桶
                    // 走下一个桶
                    bc++;
                    // 还原一下场景
                    j--;
                    continue;
                }
                arr[j] = buckets[bc][bucketContent[bc]--];
            }
        }
    }

    /**
     * 获取十进制数number的第bit位上的数字
     * @param number 十进制数
     * @param bit 从右到左第几位 从1开始
     * @return bit位上的十进制数(0~9),bit 不存在时返回0
     */
    private static int getNumberBitInBase(final int number, final int bit) {
        int tmpn = number;
        if (tmpn <= 0) {
            return 0;
        }
        int tmpBit = bit - 1;
        while (0 < tmpBit--) {
            tmpn /= 10;
        }
        return tmpn % 10;
    }

    public static void main(String[] args) {
        System.out.println(getNumberBitInBase(123456, 1));
    }

    private static int indexOfMax(int[] arr) {
        if (0 == arr.length) {
            return -1;
        }
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > arr[max]) {
                max = i;
            }
        }
        return max;
    }

    // 获取10进制数的位数
    private static int numberLenInBase(final int number) {
        final int base = 10;
        int len = 1;
        int tmp = number;
        while (0 != (tmp /= base)) {
            len++;
        }
        return len;
    }

    public static void basket(int data[])// data为待排序数组
    {
        int n = data.length;
        int bask[][] = new int[10][n];
        int index[] = new int[10];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = max > (Integer.toString(data[i]).length()) ? max
                    : (Integer.toString(data[i]).length());
        }
        String str;
        for (int i = max - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                str = "";
                if (Integer.toString(data[j]).length() < max) {
                    for (int k = 0; k < max - Integer.toString(data[j]).length(); k++)
                        str += "0";
                }
                str += Integer.toString(data[j]);
                bask[str.charAt(i) - '0'][index[str.charAt(i) - '0']++] = data[j];
            }
            int pos = 0;
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < index[j]; k++) {
                    data[pos++] = bask[j][k];
                }
            }
            for (int x = 0; x < 10; x++)
                index[x] = 0;
        }
    }
}
