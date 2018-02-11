/*
 *  Copyright (C) 2018 Xiaoshuang LU
 *  All rights reserved.
 */

package root.depthfirstsearch;

public class PowerSet1 {
    private static void doDirtyWork(String[] array, int index, boolean[] flag) {
        if (index == array.length) {
            for (int i = 0; i < array.length; ++ i) {
                if (flag[i]) {
                    System.out.print(array[i] + " ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
            return;
        }
        flag[index] = false;
        doDirtyWork(array, index + 1, flag);
        flag[index] = true;
        doDirtyWork(array, index + 1, flag);
    }

    public static void main(String[] stringArray) {
        String[] array = new String[] { "a", "b", "c", "d" };
        boolean[] flag = new boolean[4];
        doDirtyWork(array, 0, flag);
    }
}
