package com.youmu.maven.Algorithm.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        if (n == 0 || n == 1) {
            return true;
        }
        Set<Integer> s = new HashSet<>();
        for (int i : leftChild) {
            if ((s.contains(i) || i == 0) && i != -1) {
                return false;
            }
            s.add(i);
        }
        for (int i : rightChild) {
            if ((s.contains(i) || i == 0) && i != -1) {
                return false;
            }
            s.add(i);
        }
        int[] mark = new int[n];
        mark[0] = 1;
        validateBinaryTreeNode(0, leftChild, rightChild, mark);
        for (int i : mark) {
            if (i == 0) {
                return false;
            }
        }
        return true;

    }

    public void validateBinaryTreeNode(int n, int[] leftChild, int[] rightChild, int[] mark) {
        if (n == -1) {
            return;
        }
        mark[n] = 1;
        validateBinaryTreeNode(leftChild[n], leftChild, rightChild, mark);
        validateBinaryTreeNode(rightChild[n], leftChild, rightChild, mark);
    }
}
