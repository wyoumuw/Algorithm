package com.youmu.maven.Algorithm.leetcode.study;

import com.youmu.maven.Algorithm.utils.ArrayUtils;
import org.junit.Test;

public class MoveZero {
    public void moveZeroes(int[] nums) {
        int noZeroIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num != 0) {
                nums[noZeroIndex++] = num;
            }
        }
        for (int i = noZeroIndex; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    @Test
    public void Test() throws Exception {
        int[] n = new int[]{0,1,0,3,12};
        moveZeroes(n);
        ArrayUtils.printArray(n);
    }
}
