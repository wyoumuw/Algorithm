package com.youmu.maven.Algorithm.sort;

/**
 * @Author: YOUMU
 * @Description: 看算法上标记的时间复杂度得知，其时间复杂度是nlogn+nlogn=2nlogn=O(nlogn)
 * @Date: 2019/03/11
 */
public class HeapSort2 implements Sortable {
    @Override
    public void sort(int[] arr) {
        buildHeap(arr, arr.length);
        // printHeap(arr);
        int len = arr.length;
        // 这里也是O(logn)
        for (int i = 0; i < arr.length; i++) {
            // System.out.println("调整前");
            // printHeap(arr);
            Sortable.swap(arr, 0, arr.length - 1 - i);
            adjustHeap(arr, arr.length - i - 1, 0);
            // System.out.println("调整后");
            // printHeap(arr);
        }
    }

    // 自底向上建堆 O(nlogn)
    private void buildHeap(int[] arr, int len) {
        // 循环所有也不会出错
        // for (int i = len - 1; i >= 0; i--) {
        // 从最后一个有儿子的节点开始循环可以减少循环次数，最后一个有儿子的节点是(树总节点/2)，因为我下标是从0开始的就-1
        for (int i = len / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, len, i);
        }
    }

    // 这个方法只能用于子树是堆的情况
    // 遍历数的一条路径要O(logn)
    private void adjustHeap(int[] arr, int len, int root) {
        for (int i = root; i < len;) {
            int left = i * 2 + 1;
            int right = i * 2 + 2;
            // 找最大root和其下左右节点最大的出来，下标存到max下
            // 检查还有没有左节点
            int max = i;
            if (left < len && arr[left] > arr[i]) {
                max = left;
            }
            // 检查还有没有右节点
            if (right < len && arr[right] > arr[max]) {
                max = right;
            }
            // 如果max!=i 说明最大的不是跟节点需要交换
            if (max != i) {
                // 如果发生了交换的话，说明要做下级树的跳整，否则不需要调整
                // 这里还要特别说明一下，这个做交换是换最大的一个上去，也就是说如果做交换后只影响以这个节点为根的堆，而不影响另一只腿的堆(这个地方以前一直想也没用影响，现在解惑了
                Sortable.swap(arr, max, i);
                // 往交换了的子树进行调整
                i = max;
            } else {
                // 如果没发生交换说明都是正确的了就退出遍历
                break;
            }
        }
    }
}
