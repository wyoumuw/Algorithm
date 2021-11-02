package com.youmu.maven.Algorithm.leetcode;

import com.youmu.maven.Algorithm.leetcode.model.ListNode;
import org.junit.Test;

import static com.youmu.maven.Algorithm.leetcode.utils.SupportUtils.asList;
import static com.youmu.maven.Algorithm.leetcode.utils.SupportUtils.printList;

public class S25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        int len = 0;
        ListNode l = head;
        while (l != null) {
            len++;
            l = l.next;
        }
        if (len == 1 || len < k) {
            return head;
        }
        ListNode soilder = new ListNode(0, head);

        int c = len / k, cInWhile = k;
        ListNode pre, cur, next;
        while (c > 0 && soilder != null) {
            pre = soilder;
            cur = pre.next;
            while (cInWhile > 0 && cur != null) {
                next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
                cInWhile--;
            }
            if (soilder.next != null) {
                soilder.next.next = cur;
            }
            ListNode t = soilder.next;
            soilder.next = pre;
            soilder = t;
            if (c == len / k) {
                head = pre;
            }
            c--;
            cInWhile = k;
        }
        return head;
    }

    ListNode reverse(ListNode listNode, int k, ListNode soilder) {
        if (k == 0) {
            soilder.next = listNode;
            return listNode;
        }
        ListNode pre = reverse(listNode.next, k - 1, soilder);
        pre.next = listNode;
        return listNode;
    }

    @Test
    public void Test() throws Exception {
        printList(reverseKGroup(asList("[1,2,3,4,5]"), 2));
    }

    @Test
    public void Test2() throws Exception {
        printList(reverseKGroup(asList("[1,2,3,4,5]"), 1));
    }
}
