/*
 *  Copyright (C) 2018 Xiaoshuang LU
 *  All rights reserved.
 */

package root.depthfirstsearch;

import java.util.LinkedList;

public class PowerSet2 {
    private static void doDirtyWork(String[] array, int index, LinkedList<String> result) {
        if (index == array.length) {
            System.out.println(result);
            return;
        }
        result.addLast(array[index]);
        doDirtyWork(array, index + 1, result);
        result.removeLast();
        doDirtyWork(array, index + 1, result);
    }

    public static void main(String[] stringArray) {
        String[] array = new String[] { "a", "b", "c", "d" };
        LinkedList<String> result = new LinkedList<String>();
        doDirtyWork(array, 0, result);
    }
}
