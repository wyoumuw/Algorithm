package com.youmu.maven.Algorithm.structure;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * Created by wyoumuw on 2019/5/31.
 *
 * @UnsafeThreads
 */
public class AVLTreeMap<K extends Comparable<K>, V> implements Map<K, V> {


    private int size = 0;

    private AVLEntry<K, V> root;

    /**
     * 左旋
     *
     * @param ptr
     */
    private void rotateLeft(AVLEntry<K, V> ptr) {
        if (null == ptr) {
            return;
        }
        AVLEntry<K, V> right = ptr.right;
        if (null == right) {
            return;
        }
        ptr.right = right.left;
        if (null != ptr.right) {
            ptr.right.parent = ptr;
        }
        if (null == ptr.parent) {
            root = right;
        } else if (ptr.parent.left == ptr) {
            ptr.parent.left = right;
        } else {
            ptr.parent.right = right;
        }
        ptr.parent = right;
        right.left = ptr;
    }

    /**
     * 右旋
     * <p>
     * 旋转节点设为ptr，那么ptr.left就会转到ptr的位置，
     * 原ptr的left=原ptr的原left的right，然后原ptr的left的right=原ptr
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1
     * &nbsp;&nbsp;2&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;5
     * 3&nbsp;4
     * 按照1转
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2
     * &nbsp;&nbsp;3&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;4&nbsp;5
     *
     * @param ptr
     */
    private void rotateRight(AVLEntry<K, V> ptr) {
        if (null == ptr) {
            return;
        }
        AVLEntry<K, V> left = ptr.left;
        if (null == left) {
            return;
        }
        ptr.left = left.right;
        if (null != ptr.left) {
            ptr.left.parent = ptr;
        }
        if (null == ptr.parent) {
            root = left;
        } else if (ptr.parent.left == ptr) {
            ptr.parent.left = left;
        } else {
            ptr.parent.right = left;
        }
        ptr.parent = left;
        left.right = ptr;
    }


    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public V get(Object key) {
        return null;
    }

    @Override
    public V put(K key, V value) {
        return null;
    }

    @Override
    public V remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set<K> keySet() {
        return null;
    }

    @Override
    public Collection<V> values() {
        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }

    static class AVLEntry<KEY extends Comparable<KEY>, VAL> implements Map.Entry<KEY, VAL> {
        private AVLEntry<KEY, VAL> parent;
        private AVLEntry<KEY, VAL> left;
        private AVLEntry<KEY, VAL> right;
        private VAL val;
        private KEY key;

        public AVLEntry() {
        }

        public AVLEntry(AVLEntry<KEY, VAL> parent, AVLEntry<KEY, VAL> left, AVLEntry<KEY, VAL> right, VAL val, KEY key) {
            this.parent = parent;
            this.left = left;
            this.right = right;
            this.val = val;
            this.key = key;
        }

        @Override
        public KEY getKey() {
            return key;
        }

        @Override
        public VAL getValue() {
            return val;
        }

        @Override
        public VAL setValue(VAL value) {
            VAL v = this.val;
            this.val = value;
            return v;
        }
    }
}
