package com.youmu.maven.Algorithm.leetcode.study;

import com.youmu.maven.Algorithm.leetcode.utils.SupportUtils;
import com.youmu.maven.Algorithm.leetcode.model.TreeNode;
import org.junit.Test;

import java.util.*;

public class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null ^ t2 == null) {
            return false;
        }
        if (t1.val != t2.val) {
            return false;
        }
        return isSymmetric(t1.left, t2.right) && isSymmetric(t1.right, t2.left);
    }


    public boolean isSymmetric2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> d = new LinkedList<>();
        d.push(root);
        while (true) {
            boolean allNull = true;
            int size = d.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = d.poll();
                if (poll != null) {
                    if (poll.left != null || poll.right != null) {
                        allNull = false;
                    }
                    d.add(poll.left);
                    d.add(poll.right);
                    list.add(poll.val);
                } else {
                    d.add(null);
                    d.add(null);
                    list.add(null);
                }

            }
            if (allNull) {
                break;
            }
        }
        int level = 0;
        for (int i = 0; i < list.size(); ) {
            int count = 1 << level;
            if (!isSymmetric(list, i, i + count - 1)) {
                return false;
            }
            i += count;
            level++;
        }
        return true;
    }

    private boolean isSymmetric(List<Integer> list, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            if (!Objects.equals(list.get(i), (list.get(j)))) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void Test() throws Exception {
        TreeNode treeNode = SupportUtils.asTree("[1,2,2,null,3,null,3]");
        System.out.println(isSymmetric(treeNode));
    }
}
