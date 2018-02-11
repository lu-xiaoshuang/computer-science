/*
 *  Copyright (C) 2018 Xiaoshuang LU
 *  All rights reserved.
 */

package root.dynamicprogramming;

// 二维数组，求一个从左上角到右下角所有路径的数目（只能向右或者向下）
//
// dp[i][j]表示从[0][0]到[i][j]所有的路径数目
// dp[0][0] = 1
// dp[0][*] = 1
// dp[*][0] = 1
// dp[i][j] = dp[i - 1][j] + dp[i][j - 1]

public class MatrixPath1 {
    private static int doDirtyWork(int rows, int columns) {
        int[][] dp = new int[rows][columns];
        for (int i = 0; i < rows; ++ i) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < columns; ++ j) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < rows; ++ i) {
            for (int j = 1; j < columns; ++ j) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[rows - 1][columns - 1];
    }

    public static void main(String[] stringArray) {
        System.out.println(doDirtyWork(3, 7));
    }
}