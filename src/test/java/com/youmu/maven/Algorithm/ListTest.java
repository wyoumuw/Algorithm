package com.youmu.maven.Algorithm;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by wyoumuw on 2019/3/16.
 */
public class ListTest {

    private SinglyList<Integer> singlyList = new SinglyList<>();

    @Before
    public void before() {
        for (int i = 0; i < 10; i++) {
            singlyList.add(i);
        }
    }

    //判断链表是否有环
    @Test
    public void testListCycleExits() {
        Node node = singlyList.header.next.next.next.next;
        singlyList.add(node);
        // 快慢指针
        Node ptr1 = singlyList.header.next;
        Node ptr2 = singlyList.header.next;
        while (true) {
            if (null == ptr2 || null == ptr1) {
                System.out.println("无环");
                break;
            }
            // 走两个格
            ptr2 = ptr2.next;
            ptr2 = ptr2.next;
            ptr1 = ptr1.next;
            if (ptr2 == ptr1) {
                System.out.println("有环");
                break;
            }
        }
    }

    @Test
    public void testListCyclicPoint() {
        Node node = singlyList.header.next.next.next.next;
        // 我让最后一个节点指向第4个节点
        singlyList.add(node);
        //假设从链表头到环节点的长度为L
        //假设从链表环节点到快慢指针第一次相遇点长度为S(指慢指针在走链表的时候从环节点走到相遇点的长度)
        //假设环的长度为R
        //假设slow为慢指针走过的路径slow=L+S
        //假设fast为快指针走过的路径fast=2*slow=L+nR+S
        //带入计算2L+2S=L+nR+S
        // L+S=nR (L,S>0 所以n,R > 0 必须成环才成立，而且快指针肯定是至少一圈走完后才会遇到慢指针)
        // L=nR-s=(n-1)*R+(R-S)，这里我们看到R-S是什么呢？是相遇点后到环节点的距离我们记做S'  我们简化一下公式L= nR+S'
        // 这结果就出来了，如果我们让指针Ptr1从链表头开始走，并且再让一个指针Ptr2从相遇节点开始走，当Ptr2走到环节点的时候刚好就是S'，
        // 接下来他从环节点开始转N圈当刚好回到环节点的时候刚好是Ptr1走到环节点的时候，也就是说Ptr1和Ptr2会在环节点相遇。那么就找到了环节点
        // 快慢指针
        Node ptr1 = singlyList.header.next;
        Node ptr2 = singlyList.header.next;
        Node cyclicPoint;
        Node meetingPoint = null;
        //先找到第一次相遇节点
        while (true) {
            if (null == ptr2 || null == ptr1) {

                break;
            }
            // 走两个格
            ptr2 = ptr2.next;
            ptr2 = ptr2.next;
            ptr1 = ptr1.next;
            if (ptr2 == ptr1) {
                meetingPoint = ptr1;
                break;
            }
        }
        if (null == meetingPoint) {
            System.out.println("无环");
            return;
        }
        ptr1 = singlyList.header.next;//这是从头节点走
        ptr2 = meetingPoint;//从相遇节点走

        while (true) {
            if (ptr1 == ptr2) {
                cyclicPoint = ptr1;
                break;
            }
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        // 这里所指的环节点是链上的节点，而不是(链表不循环的)最后一个节点.如果想找最后一个节点只需要再遍历一遍环即可
        System.out.println("环节点是否正确？:" + (node == cyclicPoint));
        System.out.println("环节点为：" + cyclicPoint);
    }

    //单向链表 header不存数据
    class SinglyList<T> {
        private Node header = new Node();

        public void add(T ele) {
            Node node = new Node();
            node.data = ele;
            node.next = null;
            Node it = header;
            while (null != it.next) {
                it = it.next;
            }
            it.next = node;
        }

        public void add(Node ele) {
            Node it = header;
            while (null != it.next) {
                it = it.next;
            }
            it.next = ele;
        }

        public void remove(T ele) {
            Node it = header;
            while (null != it) {
                Node tt = it.next;
                if (null != tt && ele == tt.data) {
                    it.next = it.next.next;
                }
            }
        }

    }

    static class Node<T> {
        T data;
        Node next;

        @Override
        public String toString() {
            return "" + data;
        }
    }
}
