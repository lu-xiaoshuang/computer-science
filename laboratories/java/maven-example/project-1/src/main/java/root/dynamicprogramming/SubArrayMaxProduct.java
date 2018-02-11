/*
 *  Copyright (C) 2018 Xiaoshuang LU
 *  All rights reserved.
 */

package root.dynamicprogramming;

// https://leetcode.com/problems/maximum-product-subarray/
//
// 当array[i] > 0，以array[i - 1]结尾的子数组乘积越大越好
// 当array[i] < 0，以array[i - 1]结尾的子数组乘积越小越好
// dp1[i]表示以array[i]结尾的子数组最大乘积
// dp2[i]表示以array[i]结尾的子数组最小乘积
// dp1[0] = array[0]
// dp2[0] = array[0]

public class SubArrayMaxProduct {
    private static int doDirtyWork(int[] array) {
        if (array == null || array.length < 1) {
            return 0;
        }
        int[] dp1 = new int[array.length];
        int[] dp2 = new int[array.length];
        dp1[0] = array[0];
        dp2[0] = array[0];
        int max = array[0];
        for (int i = 1; i < array.length; ++ i) {
            int value1 = dp1[i - 1] * array[i];
            int value2 = dp2[i - 1] * array[i];
            dp1[i] = Math.max(Math.max(value1, value2), array[i]);
            dp2[i] = Math.min(Math.min(value1, value2), array[i]);
            if (max < dp1[i]) {
                max = dp1[i];
            }
        }
        return max;
    }

    public static void main(String[] stringArray) {
        {
            int[] array = new int[] { 2, 3, -2, 4 };
            int result = doDirtyWork(array);
            System.out.println(result);
        }
        {
            int[] array = new int[] { -2, 0, -1 };
            int result = doDirtyWork(array);
            System.out.println(result);
        }
    }
}
