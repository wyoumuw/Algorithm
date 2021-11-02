package com.youmu.maven.Algorithm.leetcode.study;

import com.youmu.maven.Algorithm.leetcode.model.ListNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class IsPalindromeList {
    public boolean isPalindrome1(ListNode head) {
        ListNode l = head;
        int c = 0;
        while (null != l) {
            c++;
            l = l.next;
        }
        if (c == 0 || c == 1) {
            return true;
        }
        return reverseList(head, c);
    }

    private boolean reverseList(ListNode head, int total) {
        if (head == null) {
            return true;
        }
        ListNode pre = head, cur = pre.next;
        int len = total / 2;
        while (len > 1) {
            ListNode next = cur.next;
            cur.next = pre;
            if (pre == head) {
                pre.next = null;
            }
            pre = cur;
            cur = next;
            len--;
        }
        if (total % 2 != 0) {
            cur = cur.next;
        }
        while (cur != null) {
            if (cur.val != pre.val) {
                return false;
            }
            cur = cur.next;
            pre = pre.next;
        }
        return true;
    }

    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (null != head) {
            list.add(head.val);
            head = head.next;
        }
        for (int i = 0, j = list.size() - 1; i < j; i++, j--) {
            if (!list.get(i).equals(list.get(j))) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void Test() throws Exception {
        System.out.println(isPalindrome(new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))))));

    }
}
