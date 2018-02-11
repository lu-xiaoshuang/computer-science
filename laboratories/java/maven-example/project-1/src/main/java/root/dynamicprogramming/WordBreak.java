/*
 *  Copyright (C) 2018 Xiaoshuang LU
 *  All rights reserved.
 */

package root.dynamicprogramming;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/word-break/
//
// dp[i]表示是否能将string[0,i)分割成词典中的词
// dp[0] = true
// dp[i] = dp[j] && set.contains(string[j,i]), 0 <= j < i

public class WordBreak {
    private static boolean doDirtyWork1(Set<String> set, String string, int index) {
        if (string == null || string.length() < 1) {
            return true;
        }
        if (index == string.length()) {
            return true;
        }
        for (int i = index; i <= string.length(); ++ i) {
            String temp = string.substring(index, i);
            if (set.contains(temp)) {
                boolean flag = doDirtyWork1(set, string, i);
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean doDirtyWork2(Set<String> set, String string) {
        if (string == null || string.length() < 1) {
            return true;
        }
        boolean[] dp = new boolean[string.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= string.length(); ++ i) {
            boolean flag = false;
            for (int j = 0; j < i; ++ j) {
                String temp = string.substring(j, i);
                if (dp[j] && set.contains(temp)) {
                    flag = true;
                    break;
                }
            }
            dp[i] = flag;
        }
        return dp[string.length()];
    }

    public static void main(String[] stringArray) {
        {
            Set<String> set =
                new HashSet<String>() {
                    {
                        add("leet");
                        add("code");
                    }
                };
            System.out.println(doDirtyWork1(set, "leetcode", 0));
            System.out.println(doDirtyWork2(set, "leetcode"));
        }
        {
            Set<String> set =
                new HashSet<String>() {
                    {
                        add("apple");
                        add("pen");
                    }
                };
            System.out.println(doDirtyWork1(set, "applepenapple", 0));
            System.out.println(doDirtyWork2(set, "applepenapple"));
        }
        {
            Set<String> set =
                new HashSet<String>() {
                    {
                        add("cats");
                        add("dog");
                        add("sand");
                        add("and");
                        add("cat");
                    }
                };
            System.out.println(doDirtyWork1(set, "catsandog", 0));
            System.out.println(doDirtyWork2(set, "catsandog"));
        }
    }
}
