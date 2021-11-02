package com.youmu.maven.Algorithm.leetcode.mutithread;

public class Main {
    public static void main(String[] args) {
        Foo foo = new Foo();
        new Thread(() -> {
            try {
                foo.second(() -> System.out.println("second"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                foo.first(() -> System.out.println("first"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                foo.third(() -> System.out.println("third"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}

class Foo {

    public Foo() {
    }

    private volatile int i = 0;

    public synchronized void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        i++;
        notifyAll();
    }

    public synchronized void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        while (i != 1) {
            wait();
        }
        printSecond.run();
        i++;
        notifyAll();
    }

    public synchronized void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        while (i != 2) {
            wait();
        }
        printThird.run();
        notifyAll();
    }
}