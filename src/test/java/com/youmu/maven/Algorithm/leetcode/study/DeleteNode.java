package com.youmu.maven.Algorithm.leetcode.study;


import com.youmu.maven.Algorithm.leetcode.model.ListNode;

public class DeleteNode {
    public void deleteNode(ListNode node) {
        node.val=node.next.val;
        node.next=node.next.next;
    }
}
