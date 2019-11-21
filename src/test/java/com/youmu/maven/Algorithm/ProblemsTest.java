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
        int[] arr = new int[]{9, 2, 3, 6, 5, 1, 7};
        int maxLen = 0;
        for (int i = 0; i < arr.length; i++) {
            int len = test1_0(arr, i);
            if (len > maxLen) {
                maxLen = len;
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

    public static void main(String[] args) {
        System.out.println(new Solution().convert("LEETCODEISHIRING", 4));
    }


    static class Solution {
        public String convert(String s, int numRows) {
            char[] chars = s.toCharArray();
            char[] results=new char[chars.length];
            int gap = numRows*2 - 2;
            if (0 == numRows) {
                return "";
            }
            if (1 == numRows) {
                return s;
            }
            for (int row = 0,ri=0; row < numRows; row++) {
                for (int i = row,m=0; i < chars.length; i ++) {
                    if((i-row)%gap==0)  {
                        m++;
                        results[ri++]=chars[i];
                        continue;
                    }
                    if(numRows-1!=row&&i==m*gap-row){
                        results[ri++]=chars[i];
                    }
                }
            }
            return String.valueOf(results);
        }
    }

    //[start,end] start<=end
    private boolean isReverse(char[] chars, int start, int end) {
        int start1 = start, end1 = end;
        while (start1 <= end1) {
            if (chars[start1++] != chars[end1--]) {
                return false;
            }
        }
        return true;
    }
}
