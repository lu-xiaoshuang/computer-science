/*
 *  Copyright (C) 2018 Xiaoshuang LU
 *  All rights reserved.
 */

package root.dynamicprogramming;

// https://leetcode.com/problems/longest-palindromic-substring/
//
// dp[i][j]表示以i开始以j结束的回文子串的最长长度
// dp[i][i] = 1, 0 <= i < length
// dp[i][j]
// case 1: dp[i + 1][j - 1] + 2, array[i] == array[j]
// case 2: max { dp[i + 1][j], dp[i][j + 1] }, array[i] != array[j]

public class LongestPalindromicSubstring {
    private static int doDirtyWork(String[] array) {
        if (array == null || array.length < 1) {
            return 0;
        }
        int[][] dp = new int[array.length][array.length];
        for (int i = 0; i < array.length; ++ i) {
            dp[i][i] = 1;
        }
        for (int i = 0; i < array.length; ++ i) {
            for (int j = i + 1; j < array.length; ++ j) {
                if (array[i].equals(array[j])) {
                    dp[j][i] = dp[j + 1][i - 1] + 1;
                } else {

                }
            }
        }
        return 0;
    }

    public static void main(String[] stringArray) {
        String[] array = new String[] { "a", "b", "a" };
        int result = doDirtyWork(array);
        System.out.println(result);
    }
}
