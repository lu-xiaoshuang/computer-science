/*
 *  Copyright (C) 2018 Xiaoshuang LU
 *  All rights reserved.
 */

package root.heap;
public class Heap {
    private static void down(int[] array, int begin, int end, int index) {
        int value = array[index];
        int child = index * 2 + 1;
        while (child < end) {
            if (child < end - 1 && array[child] < array[child + 1]) {
                ++ child;
            }
            if (value < array[child]) {
                array[index] = array[child];
                index = child;
                child = child * 2 + 1;
            } else {
                break;
            }
        }
        array[index] = value;
    }

    private static void up(int[] array, int begin, int end, int index) {
        int value = array[index];
        int parent = (index - 1) / 2;
        while (parent > 0) {
            if (array[parent] < value) {
                array[index] = array[parent];
                index = parent;
                parent = (parent - 1) / 2;
            } else {
                break;
            }
        }
        array[index] = value;
    }

    public static void makeHeap(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        int lastNonLeaf = array.length / 2 - 1;
        for (int i = lastNonLeaf; i >= 0; -- i) {
            down(array, 0, array.length, i);
        }
    }

    public static void sortHeap(int[] array) {
        makeHeap(array);
        int begin = 0;
        int end = array.length;
        while (end - begin > 1) {
            -- end;
            int value = array[end];
            array[end] = array[begin];
            array[begin] = value;
            down(array, 0, end, 0);
        }
    }

    public static void main(String[] stringArray) {
        {
            int[] array = new int[] { 0, 1, 2, 3, 4, 5, 6, 7 };
            makeHeap(array);
            for (int i = 0; i < array.length; ++ i) {
                System.out.print(array[i] + " ");
            }
            System.out.println();
        }
        {
            int[] array = new int[] { 7, 6, 5, 4, 3, 2, 1, 0 };
            sortHeap(array);
            for (int i = 0; i < array.length; ++ i) {
                System.out.print(array[i] + " ");
            }
            System.out.println();
        }
    }
}
