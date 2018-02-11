/*
 *  Copyright (C) 2018 Xiaoshuang LU
 *  All rights reserved.
 */

package root.searching;

public class NthElement {
    private static int median(int a, int b, int c) {
        if (a < b) {
            if (b < c) {
                // a < b
                // b < c
                return b;
            } else if (a < c) {
                // a < b
                // c <= b
                // a < c
                return c;
            } else {
                // a < b
                // c <= b
                // c <= a
                return a;
            }
        } else {
            if (c < b) {
                // b <= a
                // c < b
                return b;
            } else if (a < c) {
                // b <= a
                // b <= c
                // a < c
                return a;
            } else {
                // b <= a
                // b <= c
                // c <= a
                return c;
            }
        }
    }

    private static int partition(int[] array, int begin, int end, int value) {
        while (begin < end) {
            while (array[begin] < value) {
                ++ begin;
            }
            -- end;
            while (value < array[end]) {
                -- end;
            }
            if (begin < end) {
                int temporary = array[begin];
                array[begin] = array[end];
                array[end] = temporary;
                ++ begin;
            } else {
                break;
            }
        }
        return begin;
    }

    public static void nthElement(int[] array, int ordinal) {
        if (array == null || array.length < 1) {
            return;
        }
        if (ordinal < 0 || array.length <= ordinal) {
            return;
        }
        int begin = 0;
        int end = array.length;
        while (1 < end - begin) {
            int value = median(array[begin], array[begin + (end - begin) / 2], array[end - 1]);
            int partition = partition(array, begin, end, value);
            if (ordinal < partition) {
                end = partition;
            } else {
                begin = partition;
            }
        }
    }

    public static void main(String[] stringArray) {
        int[] array = new int[] { 7, 6, 5, 4, 3, 2, 1, 0 };
        println(array);
        nthElement(array, 3);
        println(array);
    }

    private static void println(int[] array) {
        for (int i = 0; i < array.length; ++ i) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
