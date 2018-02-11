/*
 *  Copyright (C) 2018 Xiaoshuang LU
 *  All rights reserved.
 */

package root;

import java.util.Arrays;

// 有线性停车位，[0, n)
// 某些停车位上有汽车
// 求一个最小长度的顶，可以覆盖k个汽车
// array表示m个汽车的停车情况

public class CarPackLotRoof {
    private static int doDirtyWork(int[] array, int k) {
        if (array == null || array.length < k || k <= 0) {
            return -1;
        }
        Arrays.sort(array);
        int result = Integer.MAX_VALUE;
        for (int i = 0; i + k - 1 < array.length; ++ i) {
            int min = array[i];
            int max = array[i + k - 1];
            int length = max + 1 - min;
            if (length < result) {
                result = length;
            }
        }
        return result;
    }

    public static void main(String[] stringArray) {
        // 0 1 2 3 4 5 6 7 8 9
        // - + - - + + - - - +
        int[] array = new int[] { 1, 4, 5, 9 };
        int result = doDirtyWork(array, 3);
        System.out.print(result);
    }
}
