package com.youmu.maven.Algorithm;

import java.io.Closeable;

/**
 * Unit test for simple App.
 */
public class A
{
    Object t;

    public A(Object t) {
        this.t = t;
    }

    public void close() throws Exception{
        ((Closeable)t).close();
    }

    public static void main(String[] args) throws Exception {
        A a=new A(new Integer(1));
        a.close();
    }
static class B{

        static int i;
}
}
