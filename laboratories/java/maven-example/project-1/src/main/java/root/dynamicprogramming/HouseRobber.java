/*
 *  Copyright (C) 2018 Xiaoshuang LU
 *  All rights reserved.
 */

package root.dynamicprogramming;

// https://leetcode.com/problems/house-robber/
//
// 小偷计划偷窃相连的房屋，每间房屋内都藏有一定的现金。
// 如果任意两个相邻的房屋同时被偷，会触发报警。
// 求小偷能够偷窃到的最高金额。
//
// dp[i]表示偷窃前i间房屋获得的最大金额
// dp[0] = array[0]
// case 1：dp[i - 2] + array[i], 偷array[i]
// case 2：dp[i - 1]，不偷array[i]
// dp[i] = max { dp[i - 2] + array[i], dp[i - 1] }

public class HouseRobber {
    private static int doDirtyWork(int[] array) {
        if (array == null || array.length < 1) {
            return 0;
        }
        int[] dp = new int[array.length];
        //int[] flag = new int[array.length];
        dp[0] = array[0];
        //flag[0] = 1;
        for (int i = 1; i < array.length; ++ i) {
            int value1 = 0;
            int value2 = 0;
            if (i >= 2) {
                value1 = dp[i - 2] + array[i];
                value2 = dp[i - 1];
            } else {
                value1 = dp[i - 1];
                value2 = dp[i - 1];
            }
            if (value1 < value2) {
                dp[i] = value2;
            } else {
                dp[i] = value1;
            }
        }
        return dp[array.length - 1];
    }

    public static void main(String[] stringArray) {
        {
            int[] array = new int[] { 1, 2, 3, 1 };
            int result = doDirtyWork(array);
            System.out.println(result);
        }
        {
            int[] array = new int[] { 2, 7, 9, 3, 1 };
            int result = doDirtyWork(array);
            System.out.println(result);
        }
    }
}
