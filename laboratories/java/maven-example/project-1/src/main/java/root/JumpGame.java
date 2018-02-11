/*
 *  Copyright (C) 2018 Xiaoshuang LU
 *  All rights reserved.
 */

package root;

// https://leetcode.com/problems/jump-game/
//
// 数组的每个元素表示可以跳跃的步数，判断能否从第一个元素跳到最后一个元素

public class JumpGame {
    private static boolean doDirtyWork(int[] array) {
        if (array == null || array.length < 1) {
            return false;
        }
        if (array.length == 1) {
            return true;
        }
        int last = array.length - 1;
        for (int i = array.length - 2; i >= 0; -- i) {
            if (i + array[i] >= last) {
                // i可跳跃到i+1
                last = i;
            }
        }
        if (last == 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] stringArray) {
        int[] array = new int[] { 2, 3, 0, 1, 4 };
        boolean result = doDirtyWork(array);
        System.out.println(result);
    }
}
