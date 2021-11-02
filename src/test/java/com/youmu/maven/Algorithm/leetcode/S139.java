package com.youmu.maven.Algorithm.leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class S139 {


    public boolean wordBreak(String s, List<String> wordDict) {
        int[] dp = new int[s.length() + 1];
        Arrays.fill(dp, -1);
        //-1:null 0:false 1:true
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < wordDict.size(); j++) {
                String s1 = wordDict.get(j);
                if (i - s1.length() >= 0 && s1.equals(s.substring(i - s1.length(), i))) {
                    dp[i] = Math.max(dp[i - s1.length()], dp[i]);
                }
            }
        }
        return dp[s.length()] == 1;
    }

    public boolean wordBreak_r(String s, List<String> wordDict) {
        return reduce(s, wordDict, 0, new Boolean[s.length()]);
    }


    private boolean reduce(String s, List<String> wordDict, int start, Boolean[] mem) {
        if (s.length() <= start) {
            return true;
        }
        if (null != mem[start]) {
            return mem[start];
        }
        for (int i = start; i < s.length(); i++) {
            if (wordDict.contains(s.substring(start, i + 1)) && reduce(s, wordDict, i + 1, mem)) {
                mem[start] = true;
                return true;
            }
        }
        mem[start] = false;
        return false;
    }

    @Test
    public void Test() throws Exception {
        System.out.println(wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
    }

    @Test
    public void Test2() throws Exception {
        System.out.println(wordBreak("leetcode", Arrays.asList("leet", "code")));
    }

}
