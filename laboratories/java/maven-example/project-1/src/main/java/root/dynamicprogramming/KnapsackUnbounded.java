/*
 *  Copyright (C) 2018 Xiaoshuang LU
 *  All rights reserved.
 */

package root.dynamicprogramming;

// 有n件物品和一个最多能背重量为w的背包
// 第i件物品的重量是weight[i]，价值是value[i]
// 每件物品可以使用无限次，计算将哪些物品装入背包里物品价值总和最大。
//
// dp[i][j]表示从[0,i]中挑选一些物品放入最大重量为j的背包所能获得的最大价值
// dp[0][j] = array[0] < j ? array[0] : 0
// dp[i][0] = 0
// dp[i][j]
// case 1：dp[i - 1][j]，不选array[i]
// case 2：dp[i][j - weight[i]] + value[i]，选array[i]
// dp[i][j] = max { dp[i - 1][j], dp[i][j - weight[i]] + value[i] }
// 从上面可以看出第i行的dp只会依赖第i-1行的dp
// dp可以改为2行
// dp可以改为1行，遍历不需要从大到小

public class KnapsackUnbounded {
    private static int doDirtyWork1(int[] weight, int[] value, int limit) {
        if (weight == null || weight.length < 1 || value == null || value.length < 1) {
            return 0;
        }
        if (weight.length != value.length) {
            return 0;
        }
        if (limit < 0) {
            return 0;
        }
        int[][] dp = new int[weight.length][limit + 1];
        for (int i = 0; i < weight.length; ++ i) {
            dp[i][0] = 0;
        }
        for (int j = 0; j <= limit; ++ j) {
            for (int count = 0; weight[0] * count <= j; ++ count) {
                dp[0][j] = value[0] * count;
            }
        }
        for (int i = 1; i < weight.length; ++ i) {
            for (int j = 1; j <= limit; ++ j) {
                int value1 = dp[i - 1][j];
                int value2 = 0;
                if (weight[i] < j) {
                    value2 = dp[i][j - weight[i]] + value[i];
                }
                if (value1 < value2) {
                    dp[i][j] = value2;
                } else {
                    dp[i][j] = value1;
                }
            }
        }
        return dp[weight.length - 1][limit];
    }

    private static int doDirtyWork2(int[] weight, int[] value, int limit) {
        if (weight == null || weight.length < 1 || value == null || value.length < 1) {
            return 0;
        }
        if (weight.length != value.length) {
            return 0;
        }
        if (limit < 0) {
            return 0;
        }
        int[][] dp = new int[2][limit + 1];
        for (int i = 0; i < 2; ++ i) {
            dp[i][0] = 0;
        }
        for (int j = 0; j <= limit; ++ j) {
            for (int count = 0; weight[0] * count <= j; ++ count) {
                dp[0][j] = value[0] * count;
            }
        }
        int index1 = 0; // row[i - 1]
        int index2 = 1; // row[i]
        for (int i = 1; i < weight.length; ++ i) {
            for (int j = 1; j <= limit; ++ j) {
                int value1 = dp[index1][j];
                int value2 = 0;
                if (weight[i] < j) {
                    value2 = dp[index2][j - weight[i]] + value[i];
                }
                if (value1 < value2) {
                    dp[index2][j] = value2;
                } else {
                    dp[index2][j] = value1;
                }
            }
            index1 = (index1 + 1) % 2;
            index2 = (index2 + 1) % 2;
        }
        return dp[index2][limit];
    }

    private static int doDirtyWork3(int[] weight, int[] value, int limit) {
        if (weight == null || weight.length < 1 || value == null || value.length < 1) {
            return 0;
        }
        if (weight.length != value.length) {
            return 0;
        }
        if (limit < 0) {
            return 0;
        }
        int[] dp = new int[limit + 1];
        for (int j = 0; j <= limit; ++ j) {
            for (int count = 0; weight[0] * count <= j; ++ count) {
                dp[j] = value[0] * count;
            }
        }
        for (int i = 1; i < weight.length; ++ i) {
            for (int j = 1; j <= limit; ++ j) {
                int value1 = dp[j];
                int value2 = 0;
                if (weight[i] < j) {
                    value2 = dp[j - weight[i]] + value[i];
                }
                if (value1 < value2) {
                    dp[j] = value2;
                } else {
                    dp[j] = value1;
                }
            }
        }
        return dp[limit];
    }

    public static void main(String[] stringArray) {
        int[] weight = new int[] { 1, 3, 4 };
        int[] value = new int[] { 15, 20, 30 };
        System.out.println(doDirtyWork1(weight, value, 4));
        System.out.println(doDirtyWork2(weight, value, 4));
        System.out.println(doDirtyWork3(weight, value, 4));
    }
}
