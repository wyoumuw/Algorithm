package com.youmu.maven.Algorithm.leetcode.utils;

import com.youmu.maven.Algorithm.leetcode.model.ListNode;
import com.youmu.maven.Algorithm.leetcode.model.TreeNode;
import com.youmu.maven.Algorithm.utils.ArrayUtils;
import org.junit.Test;

import java.util.LinkedList;

public class SupportUtils {

    public static TreeNode asTree(String s) {
        String s1 = s.replaceAll("[\\[\\]]", "");
        String[] split = s1.split(",");
        int i = 1;
        LinkedList<TreeNode> list = new LinkedList<>();
        if (split.length == 0 || split[0].equals("null")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(split[0]));
        list.addLast(root);
        while (i < split.length) {
            int size = list.size();
            for (int j = 0; j < size && i < split.length; j++) {
                TreeNode treeNode = list.pollFirst();
                if (treeNode == null) {
                    i++;
                    i++;
                    list.addLast(null);
                    list.addLast(null);
                    continue;
                }
                String left = split[i++];
                String right = split[i++];
                if (!left.equals("null")) {
                    treeNode.left = new TreeNode(Integer.parseInt(left));
                    list.addLast(treeNode.left);
                } else {
                    list.addLast(null);
                }
                if (!right.equals("null")) {
                    treeNode.right = new TreeNode(Integer.parseInt(right));
                    list.addLast(treeNode.right);
                } else {
                    list.addLast(null);
                }
            }
        }
        return root;
    }

    public static int[] asIntArr(String str) {
        String[] split = str.replaceAll("[\\[\\]\\s]", "").split(",");
        int[] res = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            String s = split[i];
            res[i] = Integer.parseInt(s);
        }
        return res;
    }

    public static int[][] asIntArrs(String str) {
        int[][] res = null;
        String[] split1 = str.split("],\\[");
        for (int i = 0; i < split1.length; i++) {
            String s = split1[i];
            String[] split = s.replaceAll("[\\[\\]\\s]", "").split(",");
            if (null == res) {
                res = new int[split1.length][split.length];
            }
            for (int i1 = 0; i1 < split.length; i1++) {
                String s1 = split[i1];
                res[i][i1] = Integer.parseInt(s1);
            }
        }
        return res;
    }

    public static ListNode asList(String str) {
        String[] split = str.replaceAll("[\\[\\]\\s]", "").split(",");
        ListNode soilder = new ListNode(), pre = soilder;
        for (int i = 0; i < split.length; i++) {
            String s = split[i];
            int v = Integer.parseInt(s);
            pre.next = new ListNode(v);
            pre = pre.next;
        }
        return soilder.next;
    }


    public static void printList(ListNode listNode) {
        while (listNode != null) {
            System.out.print(listNode.val);
            if (listNode.next != null) {
                System.out.print(" -> ");
            }
            listNode = listNode.next;
        }
    }

    @Test
    public void listTest() throws Exception {
        printList(asList("[1,2,3,4,5]"));

    }

    @Test
    public void Test2() throws Exception {
        ArrayUtils.printArray(asIntArr("[10, 15, 20]"));
    }

    @Test
    public void Test() throws Exception {
        TreeNode treeNode = asTree("[1,2,2,null,3,null,3]");
        System.out.println();
    }

    @Test
    public void Test3() throws Exception {

        System.out.println(asIntArrs("[[0,0,0],[0,1,0],[0,0,0]]"));
    }

    @Test
    public void Test4() throws Exception {
        int[][] ints = asIntArrs("[[0,0,0],[0,1,0],[0,0,0]]");
        for (int[] anInt : ints) {
            for (int i : anInt) {
                System.out.print(i + ",");
            }
            System.out.println();
        }
    }
}
