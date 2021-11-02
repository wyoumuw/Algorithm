package com.youmu.maven.Algorithm.leetcode.study;

import com.youmu.maven.Algorithm.leetcode.model.ListNode;

public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode header = new ListNode();
        ListNode m = header;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                m.next = l2;
                l2 = l2.next;
            } else {
                m.next = l1;
                l1 = l1.next;
            }
            m = m.next;
        }
        while (l1 != null) {
            m.next = l1;
            m = m.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            m.next = l2;
            m = m.next;
            l2 = l2.next;
        }
        return header.next;
    }
}
