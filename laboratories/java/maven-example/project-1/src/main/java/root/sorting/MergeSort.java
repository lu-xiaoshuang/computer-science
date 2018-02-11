/*
 *  Copyright (C) 2018 Xiaoshuang LU
 *  All rights reserved.
 */

package root.sorting;

public class MergeSort {
    private static void doMerge(
        int[] input,
        int begin,
        int middle,
        int end,
        int[] buffer,
        int index) {
        int begin1 = begin;
        int end1 = middle;
        int begin2 = middle;
        int end2 = end;
        int i = index;
        while (begin1 < end1 && begin2 < end2) {
            if (! (input[begin2] < input[begin1])) {
                buffer[index ++] = input[begin1 ++];
            } else {
                buffer[index ++] = input[begin2 ++];
            }
        }
        while (begin1 < end1) {
            buffer[index ++] = input[begin1 ++];
        }
        while (begin2 < end2) {
            buffer[index ++] = input[begin2 ++];
        }
        while (begin < end) {
            input[begin ++] = buffer[i ++];
        }
    }

    private static void doMergeSort(
        int[] array,
        int begin,
        int end,
        int[] buffer,
        int index) {
        if (end - begin < 2) {
            return;
        }
        int length = end - begin;
        doMergeSort(array, begin, begin + length / 2, buffer, begin);
        doMergeSort(array, begin + length / 2, end, buffer, begin + length / 2);
        doMerge(array, begin, begin + length / 2, end, buffer, begin);
    }

    public static void mergeSort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        int[] buffer = new int[array.length];
        doMergeSort(array, 0, array.length, buffer, 0);
    }

    public static void main(String[] stringArray) {
        int[] array = new int[] { 7, 6, 5, 4, 3, 2, 1, 0 };
        mergeSort(array);
        for (int i = 0; i < array.length; ++ i) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
