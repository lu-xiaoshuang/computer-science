/*
 *  Copyright (C) 2018 Xiaoshuang LU
 *  All rights reserved.
 */

package root.dynamicprogramming;

// 二维数组，求一个从左上角到右下角的路径使得路径中元素的和最小（只能向右或者向下）
//
// dp[i][j]表示从[0][0]到[i][j]的路径的最小和
// dp[0][0] = matrix[0][0]
// dp[0][*] = sum { matrix[0][*] }
// dp[*][0] = sum { matrix[*][0] }
// dp[i][j] = min { dp[i - 1][j], dp[i][j - 1] } + matrix[i][j]

public class MatrixPath2 {
    private static int doDirtyWork(int[][] matrix) {
        if (matrix == null || matrix.length < 1 || matrix[0] == null || matrix[0].length < 1) {
            return 0;
        }
        int rows = matrix.length;
        int columns = matrix[0].length;
        int[][] dp = new int[rows][columns];
        dp[0][0] = 0;
        for (int i = 1; i < rows; ++ i) {
            dp[i][0] = dp[i - 1][0] + matrix[i][0];
        }
        for (int j = 1; j < columns; ++ j) {
            dp[0][j] = dp[0][j - 1] + matrix[0][j];
        }
        for (int i = 1; i < rows; ++ i) {
            for (int j = 1; j < columns; ++ j) {
                if (dp[i - 1][j] < dp[i][j - 1]) {
                    dp[i][j] = dp[i - 1][j] + matrix[i][j];
                } else {
                    dp[i][j] = dp[i][j - 1] + matrix[i][j];
                }
            }
        }
        return dp[rows - 1][columns - 1];
    }

    public static void main(String[] stringArray) {
        int[][] matrix =
            new int[][] {
                { 1, 3, 1 },
                { 1, 5, 1 },
                { 4, 2, 1 }
            };
        System.out.println(doDirtyWork(matrix));
    }
}
