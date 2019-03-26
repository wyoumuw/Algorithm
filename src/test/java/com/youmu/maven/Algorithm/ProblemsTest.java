package com.youmu.maven.Algorithm;

import org.junit.Test;

/**
 * @Author: YOUMU
 * @Description:
 * @Date: 2019/03/25
 */
public class ProblemsTest {

    /**
     * 我们有一个数字序列包含 n 个不同的数字，如何求出这个序列中的最长递增子序列长度? 比如 2, 9, 3, 6, 5, 1, 7
     * 这样一组数字序列，它的最长递增子序列就是 2, 3, 5, 7， 所以最长递增子序列的长度是 4。
     */
    @Test
    public void test1() {
        int[] arr = new int[] { 9, 2, 3, 6, 5, 1, 7 };
        int maxLen = 0;
        for (int i = 0; i < arr.length; i++) {
			int len=test1_0(arr,i);
			if(len>maxLen){
				maxLen=len;
			}
        }
        System.out.println(maxLen);
    }

    // 从index点开始找下一个最长的顺序子串
    private int test1_0(int[] arr, int index) {
        if (index >= arr.length) {
            return 0;
        }
        int maxLen = 1;// index本身就算一个数
        for (int i = index + 1; i < arr.length; i++) {
            int len = 1;
            if (arr[index] < arr[i]) {
                len += test1_0(arr, i);
            }
            if (len > maxLen) {
                maxLen = len;
            }
        }
        return maxLen;
    }
}
