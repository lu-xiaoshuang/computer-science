/*
 *  Copyright (C) 2018 Xiaoshuang LU
 *  All rights reserved.
 */

package root.sorting;

public class QuickSort {
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

    private static int partition(int[] array, int begin, int end) {
        int length = end - begin;
        if (length < 2) {
            return begin;
        }
        int median = median(array[begin], array[begin + length / 2], array[end - 1]);
        while (begin < end) {
            while (array[begin] < median) {
                ++ begin;
            }
            -- end;
            while (median < array[end]) {
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
//        while (begin < end) {
//            while (array[begin] < median) {
//                ++ begin;
//            }
//            while (median < array[end - 1]) {
//                -- end;
//            }
//            int swap = array[begin];
//            array[begin] = array[end - 1];
//            array[end - 1] = swap;
//            -- end;
//        }
//        return end;
    }

    private static void doQuickSort(int[] array, int begin, int end) {
        if (end - begin < 2) {
            return;
        }
        int partition = partition(array, begin, end);
        doQuickSort(array, begin, partition);
        doQuickSort(array, partition, end);
    }

    public static void quickSort(int[] array) {
        doQuickSort(array, 0, array.length);
    }

    public static void main(String[] stringArray) {
        int[] array = new int[] { 7, 6, 5, 4, 3, 2, 1, 0 };
        quickSort(array);
        for (int i = 0; i < array.length; ++ i) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
