/*
 *  Copyright (C) 2018 Xiaoshuang LU
 *  All rights reserved.
 */

package root;

public class LexicographicalCompare {
    private static boolean doDirtyWork(int[] array1, int[] array2) {
        if (array1 == null) {
            if (array2 == null) {
                return true;
            } else {
                return true;
            }
        } else {
            if (array2 == null) {
                return false;
            }
        }
        int begin1 = 0;
        int end1 = array1.length;
        int begin2 = 0;
        int end2 = array2.length;
        while (begin1 < end1 && begin2 < end2) {
            if (array1[begin1] < array2[begin2]) {
                return true;
            } else if (array2[begin2] < array1[begin1]) {
                return false;
            }
            ++ begin1;
            ++ begin2;
        }
        return begin1 == end1 && begin2 != end2;
    }

    public static void main(String[] stringArray) {
        int[] array1 = new int[] { 0, 1, 2, 3, 4 };
        int[] array2 = new int[] { 0, 1, 2, 4, 3 };
        boolean result;
        result = doDirtyWork(array1, array2);
        System.out.println(result);
        result = doDirtyWork(array2, array1);
        System.out.println(result);
    }
}
