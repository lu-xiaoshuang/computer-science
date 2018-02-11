/*
 *  Copyright (C) 2018 Xiaoshuang LU
 *  All rights reserved.
 */

package root;

// 从数组中找出周长最长的三角形三条边

public class TriangleLongest {
    private static int doDirtyWork(int[] array) {
        if (array == null || array.length < 3) {
            return -1;
        }
        int begin = -1;
        int end = array.length - 1;
        while (begin + 2 < end) {
            if (array[end - 2] + array[end - 1] > array[end]) {
                return 1;
            }
            -- end;
        }
        return -1;
    }

    public static void main(String[] stringArray) {
        int[] array = new int[] { 2, 3, 3, 6 };
        int result = doDirtyWork(array);
        System.out.println(result);
    }
}
