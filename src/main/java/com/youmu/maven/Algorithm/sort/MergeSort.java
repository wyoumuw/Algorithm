package com.youmu.maven.Algorithm.sort;

/**
 * @Author: YOUMU
 * @Description:
 * @Date: 2019/03/08
 */
public class MergeSort implements Sortable {

    @Override
    public void sort(int[] arr) {
        sort(arr, 0, arr.length / 2, arr.length / 2 + 1, arr.length - 1);
    }

    /**
     * @param arr
     * @param lstart
     * @param lend
     * @param rstart
     * @param rend lastIndex
     */
    public void sort(int[] arr, int lstart, int lend, int rstart, int rend) {
        if ((lend - lstart) <= 1) {
            return;
        }
        sort(arr, lstart, lend / 2, lend / 2 + 1, lend);

        if ((rend - rstart) <= 1) {
            return;
        }
        sort(arr, rstart, rend / 2, rend / 2 + 1, rend);

        int li = lstart;
        int ri = rstart;
        while (li < lend && ri < rend) {
            int tmp;
            if (arr[li] > arr[ri]) {
                tmp = arr[li];
                arr[li] = arr[ri];
                arr[ri] = tmp;

            }
            li++;
        }
    }

    /**
     * 把数组的连续的两个子数组进行归并
     * @param arr 主数组
     * @param start 子数组1的头(包含)
     * @param mid 子数组1的尾(不包含),子数组2的头(包含)
     * @param end 子数组2的尾(不包含)
     */
    private void merge(int[] arr, int start, int mid, int end) {
        int i1 = start, i2 = mid, len1 = mid - start, len2 = end - mid;
        while (i1 < len1 && i2 < len2) {
            if (arr[i1] < arr[i2]) {

            }
        }
    }

}
