package com.youmu.maven.Algorithm.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class S146 {

    static class LRUCache {
        ListNode[] map;
        ListNode tail;
        ListNode head;
        int capacity;
        int size = 0;


        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.map = new ListNode[10000];
            ListNode tail = new ListNode(-1, -1, null, null);
            ListNode head = new ListNode(-1, -1, null, null);
            head.next = tail;
            tail.pre = head;
            this.tail = tail;
            this.head = head;
        }

        public int get(int key) {
            ListNode listNode = map[key];
            if (null != listNode) {
                remove(listNode);
                addToFirst(listNode);
                return listNode.val;
            }
            return -1;
        }

        public void put(int key, int value) {
            ListNode listNode = map[key];
            if (listNode == null) {
                if (capacity < size + 1) {
                    listNode = map[tail.pre.key];
                    map[tail.pre.key] = null;
                    listNode.key = key;
                    listNode.val = value;
                    remove(tail.pre);
                } else {
                    listNode = new ListNode(key, value, null, null);
                }
                addToFirst(listNode);
                size++;
                map[key] = listNode;
            } else {
                remove(listNode);
                addToFirst(listNode);
                listNode.val = value;
            }
        }

        public void remove(ListNode listNode) {
            if (listNode != tail && listNode != head) {
                ListNode next = listNode.next;
                ListNode pre = listNode.pre;
                next.pre = pre;
                pre.next = next;
            }
        }

        public void addToFirst(ListNode listNode) {
            listNode.pre = head;
            listNode.next = head.next;
            head.next.pre = listNode;
            head.next = listNode;
        }
    }


    static class ListNode {
        int key;
        int val;
        ListNode next;
        ListNode pre;

        public ListNode(int key, int val, ListNode next, ListNode pre) {
            this.key = key;
            this.val = val;
            this.next = next;
            this.pre = pre;
        }
    }


    @Test
    public void Test() throws Exception {
        String[] oper = {"put", "put", "get", "put", "get", "put", "get", "get", "get"};
        String valstr = "[[1, 1],[2, 2],[1],[3, 3],[2],[4, 4],[1],[3],[4]]";
        valstr = valstr.replaceAll("\\],\\[", "|").replaceAll("[\\[\\] ]", "");
        String[] split = valstr.split("\\|");
        LRUCache2 lruCache = new LRUCache2(2);
        for (int i = 0; i < oper.length; i++) {
            String s = oper[i];
            String vals = split[i];
            if (s.equals("put")) {
                String[] split1 = vals.split(",");
                lruCache.put(Integer.parseInt(split1[0]), Integer.parseInt(split1[1]));
                System.out.println("null");
            } else if (s.equals("get")) {
                System.out.println(lruCache.get(Integer.parseInt(vals)));
            }

        }

    }

    class LRUCache2 {
        LinkedHashMap<Integer, Integer> map;

        public LRUCache2(int capacity) {
            map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
                @Override
                protected boolean removeEldestEntry(Map.Entry eldest) {
                    return size() > capacity;
                }
            };
        }

        public int get(int key) {
            Integer integer = map.get(key);
            return null == integer ? -1 : integer;
        }

        public void put(int key, int value) {
            map.put(key, value);
        }
    }


    static class LRUCache0 {
        Map<Integer, ListNode> map;
        ListNode tail;
        ListNode head;
        int capacity;


        public LRUCache0(int capacity) {
            this.capacity = capacity;
            this.map = new HashMap<>(capacity);
            ListNode tail = new ListNode(-1, -1, null, null);
            ListNode head = new ListNode(-1, -1, null, null);
            head.next = tail;
            tail.pre = head;
            this.tail = tail;
            this.head = head;
        }

        public int get(int key) {
            ListNode listNode = map.get(key);
            if (null != listNode) {
                remove(listNode);
                addToFirst(listNode);
                return listNode.val;
            }
            return -1;
        }

        public void put(int key, int value) {
            ListNode listNode = map.get(key);
            if (listNode == null) {
                listNode = new ListNode(key, value, null, null);
                if (capacity < map.size() + 1) {
                    map.remove(tail.pre.key);
                    remove(tail.pre);
                }
                addToFirst(listNode);
                map.put(key, listNode);
            } else {
                remove(listNode);
                addToFirst(listNode);
                listNode.val = value;
            }
        }

        public void remove(ListNode listNode) {
            if (listNode != tail && listNode != head) {
                ListNode next = listNode.next;
                ListNode pre = listNode.pre;
                next.pre = pre;
                pre.next = next;
            }
        }

        public void addToFirst(ListNode listNode) {
            listNode.pre = head;
            listNode.next = head.next;
            head.next.pre = listNode;
            head.next = listNode;
        }
    }
}
