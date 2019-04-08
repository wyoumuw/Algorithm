package com.youmu.maven.Algorithm.struct;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by wyoumuw on 2019/3/30.
 */
public class Tree<T> {

    public enum TraversalType {
        MID, PRE, TAIL, LEVEL
    }

    public TreeNode<T> root;

    public List<T> traversal(TraversalType type) {
        List<T> result = new LinkedList<T>();
        switch (type) {
            case PRE:
                preTraversal0(result, root);
                break;
            case MID:
                midTraversal0(result, root);
                break;
            case TAIL:
                tailTraversal0(result, root);
                break;
            case LEVEL:
                levelTraversal0(result, root);
                break;
        }
        return result;
    }

    private void levelTraversal0(List<T> result, TreeNode<T> root) {
        if (null == root) {
            return;
        }
        Queue<TreeNode<T>> queue = new ArrayDeque<>();
        queue.offer(root);
        levelTraversal1(result, queue, root);
    }

    private void levelTraversal1(List<T> result, Queue<TreeNode<T>> queue, TreeNode<T> root) {
        // 记录当前队列大小
        int size = queue.size();
        if (0 == size) {
            return;
        }
        for (int i = 0; i < size; i++) {
            TreeNode<T> tTreeNode = queue.poll();
            if (null != tTreeNode.left) {
                queue.offer(tTreeNode.left);
            }
            if (null != tTreeNode.right) {
                queue.offer(tTreeNode.right);
            }
            result.add(tTreeNode.ele);
        }
        levelTraversal1(result, queue, root);
    }

    /**
     * mid->left->right
     *
     * @param result
     * @param root
     */
    private void midTraversal0(List<T> result, TreeNode<T> root) {
        if (null == root) {
            return;
        }
        midTraversal0(result, root.left);
        result.add(root.ele);
        midTraversal0(result, root.right);
    }

    /**
     * left->right->mid
     *
     * @param result
     * @param root
     */
    private void tailTraversal0(List<T> result, TreeNode<T> root) {
        if (null == root) {
            return;
        }
        tailTraversal0(result, root.left);
        tailTraversal0(result, root.right);
        result.add(root.ele);
    }

    /**
     * left->mid->right
     *
     * @param result
     * @param node
     */
    private void preTraversal0(List<T> result, TreeNode<T> node) {
        if (null == node) {
            return;
        }
        result.add(node.ele);
        preTraversal0(result, node.left);
        preTraversal0(result, node.right);
    }

    public static class TreeNode<T> {
        public T ele;
        public TreeNode<T> left;
        public TreeNode<T> right;

        public TreeNode(T ele) {
            this.ele = ele;
        }

        public TreeNode() {
        }
    }
}
