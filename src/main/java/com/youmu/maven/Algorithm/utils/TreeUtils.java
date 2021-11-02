package com.youmu.maven.Algorithm.utils;

import com.youmu.maven.Algorithm.struct.Tree;

import java.util.*;

/**
 * Created by wyoumuw on 2019/3/11.
 */
public final class TreeUtils {
    private TreeUtils() {
    }


    public static void printHeap(int[] arr) {
        int high = (int) Math.ceil(Math.log(arr.length) / Math.log(2));
        int maxNum = (int) Math.pow(2, high - 1);
        OptionalInt max = Arrays.stream(arr).max();

        //为了好看做的格式化
        if (!max.isPresent()) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        int maxLen = NumberUtils.getNumberLength(max.getAsInt());
        // 最大3位数进行格式化
        String format = "%" + maxLen + "d";

        for (int i = 0, index = 0; i < high; i++) {
            int curNum = (int) Math.pow(2, i);
            int afterBlank = 0;
            for (int j = 0; j < maxNum; j++) {
                if (maxNum - 1 - j > i) {
                    System.out.print("*");
                    afterBlank++;
                }
            }
            if (0 == afterBlank) {
                afterBlank = 1;
            }
            //输出那层所有的数据并且处理一下非满二叉树的情况
            for (int j = 0; j < curNum && index < arr.length; j++, index++) {
                System.out.print(StringUtils.repeat("*", afterBlank) + String.format(format, arr[index]));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
//        int arr[] = {0, 1, 2, 3, 4, 5, 6};
//        printHeap(arr);
//        System.out.println(Math.ceil(1.1));
//        System.out.println(Math.ceil(1.6));
//        System.out.println(Math.round(1.1));
//        System.out.println(Math.round(1.6));
//        System.out.println(Math.floor(1.1));
//        System.out.println(Math.floor(1.6));
//        System.out.println(String.format("%.5 s", "123"));
        System.out.println("##########".length());

    }


    public static <T> void printTree(Tree<T> tTree) {
        //1.获取值最长的值的长度V1
        //2.获取树高 Ht
        //3.算出格子长度=V1%2↑ 如果是基数那么格子长度要向上取整 Lb
        //4.计算每层的前后格子数。设层目为F 则格子数=Ht-F+1
        if (tTree.isEmpty()) {
            System.out.println("empty tree!!");
            return;
        }
        int maxValue = tTree.traversal(Tree.TraversalType.MID).stream().map(String::valueOf).mapToInt(String::length).max().orElse(0);
        maxValue = maxValue % 2 == 0 ? maxValue : maxValue + 1;
        if (maxValue == 0) {
            System.out.println("empty tree node value!!");
            return;
        }
        int ht = tTree.heightOfTree();
        int lb = maxValue / 2;
        Deque<Tree.TreeNode<T>> nodes = new LinkedList<>();
        nodes.offer(tTree.root);
        StringBuilder stringBuilder = new StringBuilder();
        printTreeLevel(nodes, 1, ht, maxValue, stringBuilder, ' ');
        System.out.println(stringBuilder.toString());
    }

    private static <T> int printTreeLevel(Deque<Tree.TreeNode<T>> nodes, int level, int ht, int maxLength, StringBuilder stringBuilder, char blankChar) {
        if (nodes.isEmpty() || level > ht) {
            return 0;
        }
        Deque<Tree.TreeNode<T>> curLevelNodes = new LinkedList<>();
        for (int i = nodes.size(); i > 0; i--) {
            Tree.TreeNode<T> node = nodes.poll();
            if (null == node) {
                nodes.offer(null);
                nodes.offer(null);
            } else {
                nodes.offer(node.left);
                nodes.offer(node.right);
            }
            curLevelNodes.offer(node);
        }
        int nextLb = printTreeLevel(nodes, level + 1, ht, maxLength, stringBuilder, blankChar);
        //前后占位
        String placeHolder = StringUtils.repeat(blankChar, level == ht ? 1 : (nextLb * 2 + maxLength));
        //空节点占位
        String emptyNodePlaceHolder = StringUtils.repeat(blankChar, maxLength);
        int l = Double.valueOf(Math.pow(2, level - 1)).intValue();
        StringBuilder line = new StringBuilder();
        StringBuilder linkLine = new StringBuilder();
        for (int i = l; i > 0; i--) {
            Tree.TreeNode<T> node = curLevelNodes.poll();
            //填充上一行的链接线的行
            linkLine.append(placeHolder);
            line.append(placeHolder);
            if (null == node) {
                line.append(emptyNodePlaceHolder);
                //填充上一行的链接线的行
                linkLine.append(emptyNodePlaceHolder);
            } else {
                String ele = String.valueOf(node.ele);
                appendAlignCenterStr(maxLength, ele, blankChar, line);
                //填充上一行的链接线的行
                String linkStr = (l - i) % 2 == 0 ? "/" : "\\";
                appendAlignCenterStr(maxLength, linkStr, blankChar, linkLine);
            }
            line.append(placeHolder);
            line.append(emptyNodePlaceHolder);
            //填充上一行的链接线的行
            linkLine.append(placeHolder);
            linkLine.append(emptyNodePlaceHolder);
        }
        linkLine.append("\n");
        line.append("\n");
        linkLine.append(line);
        stringBuilder.insert(0, linkLine);
        if (1 == level) {
            stringBuilder.delete(0, stringBuilder.indexOf("\n") + 1);
        }
        return placeHolder.length();
    }

    private static void appendAlignCenterStr(int maxLength, String target, char blankChar, StringBuilder sb) {
        if (null == target || target.length() == 0) {
            sb.append(StringUtils.repeat(blankChar, maxLength));
            return;
        }
        int padding2 = maxLength - target.length();
        if (padding2 <= 0) {
            sb.append(target);
            return;
        }
        int padding = padding2 / 2;
        sb.append(StringUtils.repeat(blankChar, padding)).append(target).append(StringUtils.repeat(blankChar, padding2 - padding));
    }
}
//-x+3=y
//
//** 1*
//* 1* 1*
// 1* 1* 1*

/*
 ***   0
 **  1  2
 * 3 4 5 16
 */
