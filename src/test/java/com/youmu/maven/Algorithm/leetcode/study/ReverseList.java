package com.youmu.maven.Algorithm.leetcode.study;

import com.youmu.maven.Algorithm.leetcode.model.ListNode;

public class ReverseList {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = head, cur = pre.next;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            if (pre == head) {
                pre.next = null;
            }
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
