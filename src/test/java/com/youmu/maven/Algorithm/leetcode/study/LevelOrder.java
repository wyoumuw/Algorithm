package com.youmu.maven.Algorithm.leetcode.study;

import com.youmu.maven.Algorithm.leetcode.utils.SupportUtils;
import com.youmu.maven.Algorithm.leetcode.model.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            List<Integer> list = new LinkedList<>();
            int size = q.size();
            while (size-- > 0) {
                TreeNode tr = q.poll();
                if (null == tr) {
                    break;
                }
                list.add(tr.val);
                if (tr.left != null) {
                    q.add(tr.left);
                }
                if (tr.right != null) {
                    q.add(tr.right);
                }
            }
            if (!list.isEmpty()) {
                res.add(list);
            }
        }
        return res;
    }

    @Test
    public void Test() throws Exception {
        System.out.println(levelOrder(SupportUtils.asTree("[3,9,20,null,null,15,7]")));
    }
}
