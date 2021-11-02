package com.youmu.maven.Algorithm.leetcode.study;

import com.youmu.maven.Algorithm.leetcode.utils.SupportUtils;
import com.youmu.maven.Algorithm.leetcode.model.TreeNode;
import org.junit.Test;

public class IsValidBST {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left != null && root.left.val >= root.val) {
            return false;
        }
        if (root.right != null && root.right.val <= root.val) {
            return false;
        }
        return isValidBST(root.left, null, root.val) && isValidBST(root.right, root.val, null);
    }

    public boolean isValidBST(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }
        if ((max != null && root.val >= max) || (min != null && root.val <= min)) {
            return false;
        }
        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }

    @Test
    public void Test() throws Exception {
        System.out.println(isValidBST(SupportUtils.asTree("[2,1,3]")));
    }
}
