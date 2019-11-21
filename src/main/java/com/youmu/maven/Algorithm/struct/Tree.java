package com.youmu.maven.Algorithm.struct;

import java.util.*;

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

    public void minMemTraversal(List<T> result) {
        // create a stack
        Deque<TreeNode<T>> stack = new ArrayDeque<TreeNode<T>>();
        addLeftChildren(root, stack);
        while (!stack.isEmpty()) {
            TreeNode<T> node = stack.pop();
            result.add(node.ele);
            if (null != node.right) {
                addLeftChildren(node.right, stack);
            }
        }
    }

    private void addLeftChildren(TreeNode<T> root, Deque<TreeNode<T>> stack) {
        if (null == root) {
            return;
        }
        stack.push(root);
        addLeftChildren(root.left, stack);
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
        while (!queue.isEmpty()) {
            TreeNode<T> tTreeNode = queue.poll();
            if (null != tTreeNode.left) {
                queue.offer(tTreeNode.left);
            }
            if (null != tTreeNode.right) {
                queue.offer(tTreeNode.right);
            }
            result.add(tTreeNode.ele);
        }
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
