/*
 *  Copyright (C) 2018 Xiaoshuang LU
 *  All rights reserved.
 */

package root;

import java.util.HashMap;
import java.util.Map;

public class SubArraySum {
    private static int doDirtyWork(int[] array, int sum) {
        if (array == null || array.length < 1) {
            return 0;
        }
        int count = 0;
        // prefixSum[i] - prefixSum[j - 1] = sum, [j, ..., i]
        int prefixSum = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, 1);
        for (int i = 0; i < array.length; ++ i) {
            prefixSum = prefixSum + array[i];
            Integer temporary = map.get(prefixSum - sum);
            if (temporary != null) {
                count = count + temporary;
            }
            Integer value = map.get(prefixSum);
            if (value != null) {
                map.put(prefixSum, value + 1);
            } else {
                map.put(prefixSum, 1);
            }
        }
        return count;
    }

    public static void main(String[] stringArray) {
        int[] array = new int[] { 3, 4, 7, 2, -3, 1, 4, 2 };
        int result = doDirtyWork(array, 7);
        System.out.println(result);
    }
}
