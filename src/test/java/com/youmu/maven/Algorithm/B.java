package com.youmu.maven.Algorithm;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by wyoumuw on 2019/11/21.
 */
public class B {


    static List<Account> list = new ArrayList<>();

    static int c = 4;

    public static void sort(Account[] arr, Comparator<Account> cmp) {
        qsort(arr, 0, arr.length - 1, cmp);
    }

    public static void qsort(Account[] arr, int start, int end, Comparator<Account> cmp) {
        if (list.size() >= c) {
            return;
        }
        if (start >= end) {
            list.add(arr[start]);
            return;
        }
        Account base = arr[start];
        int first = start;
        int last = end;
        int r = 0;
        while (first < last) {
            //find first element that greater than {base} from right
            while (first < last && ((r = cmp.compare(base, arr[last])) > 0 || r == 0)) last--;
            //swap
            arr[first] = arr[last];
            //find first element that lower than {base} from left
            while (first < last && ((r = cmp.compare(base, arr[first])) < 0 || r == 0)) first++;
            arr[last] = arr[first];
        }
        arr[first] = base;
        qsort(arr, start, first - 1, cmp);
        qsort(arr, first + 1, end, cmp);
    }


    public static void main(String[] args) {
        Account[] accounts = new Account[]{
                of(1, 1, 203),
                of(2, 2, 401),
                of(3, 3, 106),
                of(4, 4, 204),
                of(5, 7, 500),
                of(6, 7, 500),
                of(8, 7, 500),
                of(10, 7, 500),
                of(22, 22, 204),
                of(23, 23, 204),
                of(25, 25, 204),
        };

        sort(accounts, Comparator.comparing(Account::getMoney));
        for (Account account : accounts) {
            System.out.println(account);
        }

        System.out.println("----------------------");
        System.out.println(list);


    }

    static class Account {
        int id;
        int acc;
        int money;

        public int getId() {
            return id;
        }

        public int getAcc() {
            return acc;
        }

        public int getMoney() {
            return money;
        }

        @Override
        public String toString() {
            return "Account{" +
                    "id=" + id +
                    ", acc=" + acc +
                    ", money=" + money +
                    '}';
        }
    }

    static Account of(int id, int acc, int money) {
        Account a = new Account();
        a.id = id;
        a.acc = acc;
        a.money = money;
        return a;
    }
}
