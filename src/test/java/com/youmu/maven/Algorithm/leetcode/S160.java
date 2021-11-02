package com.youmu.maven.Algorithm.leetcode;

import com.youmu.maven.Algorithm.leetcode.model.ListNode;
import org.junit.Test;

public class S160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA, b;
        while (a != null) {
            b = headB;
            while (b != null) {
                if (a == b) {
                    return a;
                }
                b = b.next;
            }
            a = a.next;
        }
        return null;
    }

    @Test
    public void Test() throws Exception {

    }
}


