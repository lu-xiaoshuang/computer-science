/*
 *  Copyright (C) 2018 Xiaoshuang LU
 *  All rights reserved.
 */

package root.sorting;

public class BubbleSort {
    private static void bubbleSort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        for (int i = 0; i < array.length; ++ i) {
            for (int j = 0; j < array.length - i - 1; ++ j) {
                if (! (array[j] < array[j + 1])) {
                    int temporary = array[i];
                    array[j] = array[j + 1];
                    array[j + 1] = temporary;
                }
            }
        }
    }

    public static void main(String[] stringArray) {
        int[] array = new int[] { 7, 6, 5, 4, 3, 2, 1, 0 };
        bubbleSort(array);
        for (int i = 0; i < array.length; ++ i) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
