/*
 *  Copyright (C) 2018 Xiaoshuang LU
 *  All rights reserved.
 */

package root.searching;

public class Bound {
    public static int lowerBound(int[] array, int value) {
        if (array == null || array.length < 1) {
            return -1;
        }
        int begin = 0;
        int end = array.length;
        while (begin < end) {
            int length = end - begin;
            int middle = begin + (length / 2);
            if (array[middle] < value) {
                begin = middle + 1;
            } else {
                end = middle;
            }
        }
        return end;
    }

    public static int upperBound(int[] array, int value) {
        if (array == null || array.length < 1) {
            return -1;
        }
        int begin = 0;
        int end = array.length;
        while (begin < end) {
            int length = end - begin;
            int middle = begin + (length / 2);
            if (array[middle] <= value) {
                begin = middle + 1;
            } else {
                end = middle;
            }
        }
        return end;
    }

    public static void main(String[] stringArray) {
        {
            int[] array = new int[] { 0, 1, 2, 2, 2, 2, 6, 7 };
            System.out.println(lowerBound(array, -1));
            System.out.println(lowerBound(array, 2));
            System.out.println(upperBound(array, -1));
            System.out.println(upperBound(array, 2));
        }
    }
}
