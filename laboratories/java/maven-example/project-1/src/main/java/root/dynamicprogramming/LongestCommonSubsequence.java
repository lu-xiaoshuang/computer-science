/*
 *  Copyright (C) 2018 Xiaoshuang LU
 *  All rights reserved.
 */

package root.dynamicprogramming;

// dp[i][j]表示array1[0,i)和array2[0,j)的最长公共子序列的长度
// dp[0][*] = 0
// dp[*][0] = 0
// dp[i][j]
// case 1: dp[i - 1][j - 1] + 1, array1[i] == array2[j]
// case 2: max { dp[i - 1][j], dp[i][j - 1] }, array1[i] != array2[j]

public class LongestCommonSubsequence {
    private static int doDirtyWork(String[] array1, String[] array2) {
        if (array1 == null || array1.length < 1 || array2 == null || array2.length < 1) {
            return 0;
        }
        int length1 = array1.length;
        int length2 = array2.length;
        int[][] dp = new int[length1 + 1][length2 + 1];
        for (int i = 0; i < length1 + 1; ++ i) {
            dp[i][0] = 0;
        }
        for (int j = 0; j < length2 + 1; ++ j) {
            dp[0][j] = 0;
        }
        int max = 0;
        for (int i = 1; i < length1 + 1; ++ i) {
            for (int j = 1; j < length2 + 1; ++ j) {
                if (array1[i - 1].equals(array2[j - 1])) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else{
                    int value1 = dp[i - 1][j];
                    int value2 = dp[i][j - 1];
                    dp[i][j] = value1 < value2 ? value2 : value1;
                }
                if (max < dp[i][j]) {
                    max = dp[i][j];
                }
            }
        }
        return max;
    }

    public static void main(String[] stringArray) {
        {
            String[] array1 = new String[] { "0", "1", "0", "1" };
            String[] array2 = new String[] { "1", "0", "2", "0" };
            System.out.println(doDirtyWork(array1, array2));
        }
        {
            String[] array1 = new String[] { "a", "b", "c", "d", "e" };
            String[] array2 = new String[] { "a", "c", "e" };
            System.out.println(doDirtyWork(array1, array2));
        }
        {
            String[] array1 = new String[] { "z", "x", "y", "x", "y", "z" };
            String[] array2 = new String[] { "x", "y", "y", "z", "x" };
            System.out.println(doDirtyWork(array1, array2));
        }
    }
}
