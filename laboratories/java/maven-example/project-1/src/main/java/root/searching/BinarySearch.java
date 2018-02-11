/*
 *  Copyright (C) 2018 Xiaoshuang LU
 *  All rights reserved.
 */

package root.searching;

public class BinarySearch {
    public static int binarySearch(int[] array, int value) {
        if (array == null || array.length < 1) {
            return -1;
        }
        int begin = 0;
        int end = array.length;
        while (begin < end) {
            int length = end - begin;
            int middle = begin + (length / 2);
            if (value == array[middle]) {
                return middle;
            } else if (value < array[middle]) {
                // value < array[middle];
                end = middle;
            } else {
                // middle < value;
                if (begin == middle) {
                    break;
                }
                begin = middle;
            }
        }
        return -1;
    }

    public static void main(String[] stringArray) {
        {
            int[] array = new int[] { 0, 1, 2, 3, 4, 5, 6, 7 };
            System.out.println(binarySearch(array, -1));
            System.out.println(binarySearch(array, 8));
            for (int i = 0; i < array.length; ++ i) {
                System.out.println(binarySearch(array, array[i]));
            }
        }
    }
}
