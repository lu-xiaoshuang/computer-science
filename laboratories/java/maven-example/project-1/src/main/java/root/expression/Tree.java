/*
 *  Copyright (C) 2018 Xiaoshuang LU
 *  All rights reserved.
 */

package root.expression;

import java.util.LinkedList;
import java.util.Random;
import java.util.Set;

public class Tree {
    private static void run(Set<TreeNode> parents, Set<String> result) {
        if (parents == null || parents.isEmpty()) {
            return;
        }
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>(parents);
        while (! queue.isEmpty()) {
            LinkedList<TreeNode> children = new LinkedList<TreeNode>();
            children.addAll(queue);
            queue.clear();
            mark(children, result);
            for (TreeNode treeNode : children) {
                if (result.contains(treeNode.key)) {
                    for (TreeNode temp : treeNode.children) {
                        queue.addLast(temp);
                    }
                }
            }
        }
    }

    private static void mark(LinkedList<TreeNode> children, Set<String> result) {
        Random random = new Random();
    }

    public static void main(String[] stringArray) {

    }
}
