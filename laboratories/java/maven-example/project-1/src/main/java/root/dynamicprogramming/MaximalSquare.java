/*
 *  Copyright (C) 2018 Xiaoshuang LU
 *  All rights reserved.
 */

package root.dynamicprogramming;

// https://leetcode.com/problems/maximal-square/
//
// 0和1构成的二维数组，求1构成的最大正方形边长

public class MaximalSquare {
    private static int doDirtyWork(int[][] matrix) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return 0;
        }
        int rows = matrix.length;
        int columns = matrix[0].length;
        // 以matrix[i][j]为右下角的最大正方形边长
        int[][] dp = new int[rows][columns];
        int max = 0;
        for (int i = 0; i < rows; ++ i) {
            if (matrix[i][0] == 1) {
                dp[i][0] = 1;
                max = 1;
            } else {
                dp[i][0] = 0;
            }
        }
        for (int j = 0; j < columns; ++ j) {
            if (matrix[0][j] == 1) {
                dp[0][j] = 1;
                max = 1;
            } else {
                dp[0][j] = 0;
            }
        }
        for (int i = 1; i < rows; ++ i) {
            for (int j = 1; j < columns; ++ j) {
                int a = dp[i - 1][j - 1];
                int b = dp[i - 1][j];
                int c = dp[i][j - 1];
                if (matrix[i][j] == 1) {
                    dp[i][j] = Math.min(Math.min(a, b), c) + 1;
//                    if (a < b) {
//                        dp[i][j] = a + 1;
//                    } else {
//                        dp[i][j] = b + 1;
//                    }
                } else {
                    dp[i][j] = 0;
                }
                if (max < dp[i][j]) {
                    max = dp[i][j];
                }
            }
        }
        for (int i = 0; i < rows; ++ i) {
            for (int j = 0; j < columns; ++ j) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        return max;
    }

    public static void main(String[] stringArray) {
        {
            int[][] matrix =
                new int[][] {
                    { 1, 0, 1, 0, 0 },
                    { 1, 0, 1, 1, 1 },
                    { 1, 1, 1, 1, 1 },
                    { 1, 0, 0, 1, 0 }
                };
            int result = doDirtyWork(matrix);
            System.out.println(result);
        }
        {
            int[][] matrix =
                new int[][] {
                    { 0, 1, 1, 1, 0 },
                    { 1, 1, 1, 1, 0 },
                    { 0, 1, 1, 1, 1 },
                    { 0, 1, 1, 1, 1 },
                    { 0, 0, 1, 1, 1 }
                };
            int result = doDirtyWork(matrix);
            System.out.println(result);
        }
    }
}
