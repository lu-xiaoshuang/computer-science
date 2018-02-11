/*
 *  Copyright (C) 2018 Xiaoshuang LU
 *  All rights reserved.
 */

package root.depthfirstsearch;

// https://leetcode.com/problems/max-area-of-island/

public class Island2 {
    private static void depthFirstSearch(int[][] matrix, int[][] flag, int rows, int columns, int i, int j, int[] area) {
        if (i < 0 || i >= rows || j < 0 || j >= columns) {
            return;
        }
        if (matrix[i][j] == 0) {
            return;
        }
        if (flag[i][j] == 1) {
            return;
        }
        flag[i][j] = 1;
        area[0] = area[0] + 1;
        depthFirstSearch(matrix, flag, rows, columns, i - 1, j, area);
        depthFirstSearch(matrix, flag, rows, columns, i, j + 1, area);
        depthFirstSearch(matrix, flag, rows, columns, i + 1, j, area);
        depthFirstSearch(matrix, flag, rows, columns, i, j - 1, area);
    }

    private static int doDirtyWork(int[][] matrix) {
        if (matrix == null || matrix.length < 1 || matrix[0] == null || matrix[0].length < 1) {
            return 0;
        }
        int rows = matrix.length;
        int columns = matrix[0].length;
        int[][] flag = new int[rows][columns];
        for (int i = 0; i < rows; ++ i) {
            for (int j = 0; j < columns; ++ j) {
                flag[i][j] = 0;
            }
        }
        int maxArea = 0;
        int[] area = new int[1];
        for (int i = 0; i < rows; ++ i) {
            for (int j = 0; j < columns; ++ j) {
                if (matrix[i][j] == 1 && flag[i][j] == 0) {
                    area[0] = 0;
                    depthFirstSearch(matrix, flag, rows, columns, i, j, area);
                    if (maxArea < area[0]) {
                        maxArea = area[0];
                    }
                }
            }
        }
        return maxArea;
    }

    public static void main(String[] stringArray) {
        int[][] matrix =
            new int[][] {
                { 1, 1, 1, 1, 0 },
                { 1, 1, 0, 0, 0 },
                { 1, 1, 0, 1, 0 },
                { 0, 0, 1, 0, 1 }
            };
        int result = doDirtyWork(matrix);
        System.out.println(result);
    }
}
