/*
 *  Copyright (C) 2018 Xiaoshuang LU
 *  All rights reserved.
 */

package root.stack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Test {
    private static List<String> doDirtyWork(List<String> list) {
        LinkedList<String> stack = new LinkedList<String>();
        for (int i = 0; i < list.size(); ++ i) {
            stack.addLast(list.get(i));
            while (stack.size() >= 3) {
                if ("6".equals(stack.get(stack.size() - 1)) &&
                    "1".equals(stack.get(stack.size() - 2)) &&
                    "8".equals(stack.get(stack.size() - 3))) {
                    stack.removeLast();
                    stack.removeLast();
                    stack.removeLast();
                    stack.addLast("8");
                } else {
                    break;
                }
            }
        }
        return stack;
    }

    public static void main(String[] stringArray) {
        List<String> list = new ArrayList<String>();
        list.add("8");
        list.add("1");
        list.add("8");
        list.add("1");
        list.add("6");
        list.add("1");
        list.add("6");
        System.out.println(list);
        List<String> result = doDirtyWork(list);
        System.out.println(result);
    }
}

