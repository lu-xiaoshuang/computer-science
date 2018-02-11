/*
 *  Copyright (C) 2018 Xiaoshuang LU
 *  All rights reserved.
 */

package root.dynamicprogramming;

// https://leetcode.com/problems/longest-valid-parentheses/
//
// (和)构成的字符串，求最长有效的括号字符串

import java.util.LinkedList;

public class LongestValidParentheses {
    private static int doDirtyWork(String[] array) {
        if (array == null || array.length < 1) {
            return 0;
        }
        LinkedList<String> stack = new LinkedList<String>();
        // 以array[i]结尾的字符串包含最长括号对数
        int[] dp = new int[array.length];
        int max = 0;
        for (int i = 0; i < array.length; ++ i) {
            if ("(".equals(array[i])) {
                stack.addLast(array[i]);
                dp[i] = 0;
            } else if (")".equals(array[i])) {
                if (! stack.isEmpty()) {
                    stack.removeLast();
                    dp[i] = dp[i - 1] + 1;
                    // ( | ) | ( | )
                    // 0 | 1 | 0 | 2
                    int previous = i - dp[i] * 2;
                    if (previous >= 0) {
                        dp[i] = dp[i] + previous;
                    }
                }
            }
            if (max < dp[i]) {
                max = dp[i];
            }
        }
        return max;
    }

    public static void main(String[] stringArray) {
        {
            String[] array = new String[] { "(", ")", "(", ")" };
            int result = doDirtyWork(array);
            System.out.println(result);
        }
        {
            String[] array = new String[] { "(", "(", "(", ")", ")", ")" };
            int result = doDirtyWork(array);
            System.out.println(result);
        }
        {
            String[] array = new String[] { ")", "(", "(", "(", ")", ")", ")" };
            int result = doDirtyWork(array);
            System.out.println(result);
        }
    }
}
