package com.youmu.maven.Algorithm.leetcode.study;

import com.youmu.maven.Algorithm.leetcode.model.TreeNode;

public class MaxDepth {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxLeft = maxDepth(root.left);
        int maxRight = maxDepth(root.right);

        return Math.max(maxLeft, maxRight) + 1;
    }
}
