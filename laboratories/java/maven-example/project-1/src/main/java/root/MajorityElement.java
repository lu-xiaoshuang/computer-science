/*
 *  Copyright (C) 2018 Xiaoshuang LU
 *  All rights reserved.
 */

package root;

// https://leetcode.com/problems/majority-element/
// https://leetcode.com/problems/majority-element-ii/
//
// 给定一个大小为n的数组，找出其中最多的元素。
// 多数元素是指在数组中出现次数大于⌊n/2⌋的元素。

public class MajorityElement {
    // 摩尔投票法
    public static int majorityElement(int[] array) {
        int count = 1;
        int majorityElement = array[0];
        for (int i = 1; i < array.length; ++ i) {
            if (majorityElement == array[i]) {
                ++ count;
            } else {
                -- count;
                if (count == 0) {
                    majorityElement = array[i + 1];
                }
            }
        }
        return majorityElement;
    }

    public static void main(String[] stringArray) {
        int[] array = new int[] { 1, 1, 1, 1, 1, 2, 2, 2 };
        int value = majorityElement(array);
        System.out.println(value);
    }
}
