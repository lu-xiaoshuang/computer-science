/*
 *  Copyright (C) 2018 Xiaoshuang LU
 *  All rights reserved.
 */

package root.dynamicprogramming;

// https://leetcode.com/problems/maximum-subarray/
//
// dp[i]表示以array[i]结尾的子数组最大和
// dp[0] = array[0]
// dp[i]
// case 1: dp[i - 1] + array[i], dp[i - 1] > 0
// case 2: array[i]， dp[i - 1] < 0

public class SubArrayMaxSum {
    private static int doDirtyWork(int[] array) {
        if (array == null || array.length < 1) {
            return 0;
        }
        int[] dp = new int[array.length];
        dp[0] = array[0];
        int max = array[0];
        for (int i = 1; i < array.length; ++ i) {
            if (dp[i - 1] < 0) {
                dp[i] = array[i];
            } else {
                dp[i] = dp[i - 1] + array[i];
            }
            if (max < dp[i]) {
                max = dp[i];
            }
        }
        return max;
    }

    public static void main(String[] stringArray) {
        {
            int[] array = new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
            int result = doDirtyWork(array);
            System.out.println(result);
        }
    }
}
