/*
 *  Copyright (C) 2018 Xiaoshuang LU
 *  All rights reserved.
 */

package root.depthfirstsearch;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/generate-parentheses/

public class GenerateParentheses {
    private static void depthFirstSearch(int n, int left, int right, String string, List<String> result) {
        if (left > n || right > n || left < right) {
            return;
        }
        if (left == n && right == n) {
            result.add(string);
            return;
        }
        depthFirstSearch(n, left + 1, right, string + "(", result);
        if (left > right) {
            depthFirstSearch(n, left, right + 1, string + ")", result);
        }
    }

    private static void doDirtyWork(int n) {
        List<String> result = new ArrayList<String>();
        depthFirstSearch(n, 0, 0, "", result);
        for (String item : result) {
            System.out.println(item);
        }
    }

    public static void main(String[] stringArray) {
        doDirtyWork(4);
    }
}
