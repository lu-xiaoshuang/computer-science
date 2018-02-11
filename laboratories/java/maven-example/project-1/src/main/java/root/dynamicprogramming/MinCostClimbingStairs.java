/*
 *  Copyright (C) 2018 Xiaoshuang LU
 *  All rights reserved.
 */

package root.dynamicprogramming;

// https://leetcode.com/problems/min-cost-climbing-stairs/
//
// 给定一个整数数组cost，每个元素表示从当前台阶向上爬需要支付的费用
// 可以选择向上爬一个台阶或者两个台阶，可以选择从下标为0或者下标为1的台阶开始爬楼梯
// 计算到达楼梯顶部的最低花费
//
// dp[i]表示到达台阶i需要的最低花费
// dp[0] = 0
// dp[1] = 0
// dp[i] = min { dp[i - 1] + array[i - 1], dp[i - 2] + array[i - 2] }

public class MinCostClimbingStairs {
    private static int doDirtyWork(int[] array) {
        if (array == null || array.length < 3) {
            return 0;
        }
        int[] dp = new int[array.length + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i < array.length + 1; ++ i) {
            int value1 = dp[i - 1] + array[i - 1];
            int value2 = dp[i - 2] + array[i - 2];
            if (value1 < value2) {
                dp[i] = value1;
            } else {
                dp[i] = value2;
            }
        }
        return dp[array.length];
    }

    public static void main(String[] stringArray) {
        {
            int[] array = new int[] { 10, 15, 20 };
            int result = doDirtyWork(array);
            System.out.println(result);
        }
        {
            int[] array = new int[] { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 };
            int result = doDirtyWork(array);
            System.out.println(result);
        }
    }
}
