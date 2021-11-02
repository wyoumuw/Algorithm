package com.youmu.maven.Algorithm.leetcode;

public class S1190 {
    public String reverseParentheses(String s) {
        char[] stack = new char[s.length()];
        int top = 0;
        for (int x = 0; x < s.length(); x++) {
            char c = s.charAt(x);
            if (c != ')') {
                stack[top++] = c;
            } else {
                for (int i = top - 1; i < top && i >= 0; i--) {
                    if (stack[i] == '(') {
                        //找到第一个(
                        //翻转后退栈一个元素，这个元素将是(
                        reverse(stack, i, top);
                        top--;
                        break;
                    }
                }
            }
        }
        return new String(stack, 0, top);
    }

    private void reverse(char[] arr, int start, /*exclusive*/int end) {
        for (int i = start, j = end - 1; i < j; i++, j--) {
            char t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
        }
    }

    public static void main(String[] args) {
        S1190 s1190 = new S1190();
        System.out.println(s1190.reverseParentheses("(abcd)"));
        System.out.println(s1190.reverseParentheses("(u(love)i)"));
        System.out.println(s1190.reverseParentheses("(ed(et(oc))el)"));
        System.out.println(s1190.reverseParentheses("a(bcdefghijkl(mno)p)q"));
        System.out.println(s1190.reverseParentheses("ta()usw((((a))))"));
//        char[] chars = "ta()usw((((a))))".toCharArray();
//        s1190.reverse(chars, 0, chars.length);
//        System.out.println(chars);
    }
}
