/*
 *  Copyright (C) 2018 Xiaoshuang LU
 *  All rights reserved.
 */

package root.dynamicprogramming;

// https://leetcode.com/problems/perfect-squares/
//
// 给定正整数n，找到若干个完全平方数（i.e. 1, 4, 9, 16, ...）使得他们的和等于n。
// 需要让组成和的完全平方数的个数最少。
//
// dp[j]表示和为j所需完全平方数最少的个数
// dp[0] = 0，剩余dp元素使用最大值赋值
// dp[j] = min { dp[j - squares[i]] + 1, dp[j] }, 0 <= i < length

public class PerfectSquares {
    private static int doDirtyWork(int[] array, int sum) {
        if (array == null || array.length < 1) {
            return -1;
        }
        if (sum < 0) {
            return -1;
        }
        int[] dp = new int[sum + 1];
        dp[0] = 0;
        for (int i = 1; i <= sum; ++ i) {
            dp[i] = Integer.MAX_VALUE;
        }
        for (int i = 1; i <= sum; ++ i) {
            for (int j = 0; j < array.length; ++ j) {
                int index = i - array[j];
                if (index >= 0 && dp[index] != Integer.MAX_VALUE) {
                    int value = dp[index] + 1;
                    if (value < dp[i]) {
                        dp[i] = value;
                    }
                }
            }
        }
        if (dp[sum] != Integer.MAX_VALUE) {
            return dp[sum];
        }
        return -1;
    }

    public static void main(String[] stringArray) {
        {
            int[] array = new int[] { 1, 4, 9, 16, 25, 36, 49, 64, 81, 100 };
            int result = doDirtyWork(array, 12);
            System.out.println(result);
        }
        {
            int[] array = new int[] { 1, 4, 9, 16, 25, 36, 49, 64, 81, 100 };
            int result = doDirtyWork(array, 13);
            System.out.println(result);
        }
    }
}
