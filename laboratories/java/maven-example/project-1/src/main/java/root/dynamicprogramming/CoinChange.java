/*
 *  Copyright (C) 2018 Xiaoshuang LU
 *  All rights reserved.
 */

package root.dynamicprogramming;

// https://leetcode.com/problems/coin-change/
//
// 给定一个整数数组coins，表示不同面额的硬币；以及一个整数amount，表示总金额。
// 计算可以凑成总金额所需的最少的硬币个数，如果没有任何一种硬币组合能够组成总金额，返回-1。
// 每种硬币的数量是无限的。
//
// dp[j]表示凑成总金额为j所需硬币的最少个数
// dp[0] = 0，其他dp数组元素使用最大值赋值
// dp[j] = min { dp[j - coins[i]] + 1, dp[j] }, 0 <= i < length

public class CoinChange {
    private static int doDirtyWork(int[] array, int amount) {
        if (array == null || array.length < 1) {
            return -1;
        }
        if (amount < 0) {
            return -1;
        }
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; ++ i) {
            dp[i] = Integer.MAX_VALUE;
        }
        for (int i = 1; i <= amount; ++ i) {
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
        if (dp[amount] != Integer.MAX_VALUE) {
            return dp[amount];
        }
        return -1;
    }

    public static void main(String[] stringArray) {
        {
            int[] array = new int[] { 5, 2, 3 };
            int result = doDirtyWork(array, 20);
            System.out.println(result);
        }
        {
            int[] array = new int[] { 5, 2, 3 };
            int result = doDirtyWork(array, 1);
            System.out.println(result);
        }
    }
}
