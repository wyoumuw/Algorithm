package com.youmu.maven.Algorithm;

/**
 * Created by wyoumuw on 2019/4/17.
 */
public class Computer {

    /**
     * add a and b without '+' operation
     *
     * @param a
     * @param b
     * @return
     */
    public int add(int a, int b) {
        int c = 0, result = 0;
        do {
            result = a ^ b;
            c = a & b;
            a = result;
            b = c << 1;
        } while (c != 0);
        return result;
    }


    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
//        for (int i = 1; i < 10000; i++) {
//            list.add(i + "");
//        }
//        list.sort(String::compareTo);
//        for (String s : list) {
//            System.out.println(s);
//        }
        for (int i = 1; i < 10; i++) {
            bit(i, 2);
        }
    }


    public static void bit(int before, int bit) {
        for (int i = -1; i < 10; i++) {
            if (i == -1) {
                System.out.println(before);
            } else if (bit == 4) {
                System.out.println(before * 10 + i);
            } else {
                bit(before * 10 + i, bit + 1);
            }
        }
    }
}
