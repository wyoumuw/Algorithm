package com.youmu.maven.Algorithm.leetcode.model;

public class ListNode {
    public int val;
    public ListNode next;


    public ListNode() {
    }

    public ListNode(int x) {
        val = x;
        next = null;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return val + "";
    }
}