/*
 *  Copyright (C) 2018 Xiaoshuang LU
 *  All rights reserved.
 */

package root.dynamicprogramming;

// dp[i]表示以array[i]结尾的最长的递增子序列长度
// dp[0] = 1
// dp[i] = max { dp[j] + 1 }, 0 <= j < i, array[j] < array[i]

public class LongestIncreasingSubsequence {
    private static int doDirtyWork(int[] array) {
        if (array == null || array.length < 1) {
            return 0;
        }
        int[] dp = new int[array.length];
        dp[0] = 1;
        for (int i = 1; i < array.length; ++ i) {
            int max = 1;
            for (int j = 0; j < i; ++ j) {
                if (array[j] < array[i]) {
                    if (max < dp[j] + 1) {
                        max = dp[j] + 1;
                    }
                }
                dp[i] = max;
            }
        }
        int max = dp[0];
        for (int i = 1; i < array.length; ++ i) {
            if (max < dp[i]) {
                max = dp[i];
            }
        }
        return max;
    }

    public static void main(String[] stringArray) {
        System.out.println(doDirtyWork(new int[] { 1, 7, 3, 5, 9, 4, 8 }));
        System.out.println(doDirtyWork(new int[] { 2, 7, 1, 5, 6, 4, 3, 8, 9 }));
        System.out.println(doDirtyWork(new int[] { 1, 7, 3, 5, 9, 4, 8 }));
    }
}
