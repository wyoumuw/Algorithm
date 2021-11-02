package com.youmu.maven.Algorithm.leetcode.study;

import com.youmu.maven.Algorithm.leetcode.model.ListNode;

public class hasCycleList {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
