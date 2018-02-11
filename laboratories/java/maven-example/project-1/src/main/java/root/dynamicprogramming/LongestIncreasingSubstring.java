/*
 *  Copyright (C) 2018 Xiaoshuang LU
 *  All rights reserved.
 */

package root.dynamicprogramming;

public class LongestIncreasingSubstring {
    private static int doDirtyWork(int[] array) {
        if (array == null || array.length < 1) {
            return 0;
        }
        int max = 0;
        int i = 0;
        int j = i + 1;
        while (i < array.length) {
            j = i + 1;
            while (j < array.length) {
                if (array[j - 1] < array[j]) {
                    ++ j;
                } else {
                    break;
                }
            }
            if (max < j - i) {
                max = j - i;
            }
            i = j;
        }
        return max;
    }

    public static void main(String[] stringArray) {
        {
            int[] array = new int[] { 1, 7, 3, 5, 9, 4, 8 };
            int result = doDirtyWork(array);
            System.out.println(result);
        }
        {
            int[] array = new int[] { 2, 7, 1, 5, 6, 4, 3, 8, 9 };
            int result = doDirtyWork(array);
            System.out.println(result);
        }
    }
}
