package com.youmu.maven.Algorithm.leetcode.study;

import com.youmu.maven.Algorithm.leetcode.model.TreeNode;
import org.junit.Test;

import java.util.List;

public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        if (start == end) {
            return new TreeNode(nums[start]);
        }
        int len = end - start + 1;
        int mid = start + len / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums, start, mid - 1);
        root.right = sortedArrayToBST(nums, mid + 1, end);
        return root;
    }

    @Test
    public void Test() throws Exception {
        TreeNode treeNode = sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
        List<List<Integer>> lists = new LevelOrder().levelOrder(treeNode);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
}
