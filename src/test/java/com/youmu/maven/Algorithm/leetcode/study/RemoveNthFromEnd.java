package com.youmu.maven.Algorithm.leetcode.study;

import com.youmu.maven.Algorithm.leetcode.model.ListNode;
import org.junit.Test;

public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode header = new ListNode(0, head);
        ListNode slow = head, fast = head, pre = header;
        int i;
        for (i = 0; i < n && fast != null; i++) {
            fast = fast.next;
        }
        //窗口大于实际列表数据认为是无删除
        if (i != n) {
            return head;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
            pre = pre.next;
        }
        pre.next = slow.next;
        return header.next;
    }

    @Test
    public void Test() throws Exception {
        System.out.println(removeNthFromEnd(new ListNode(0), 1));
    }
}
