/*
 *  Copyright (C) 2018 Xiaoshuang LU
 *  All rights reserved.
 */

package root.tree;

import java.util.LinkedList;

public class CompleteBinaryTree {
    private static boolean doDirtyWork(BinaryTreeNode binaryTreeNode) {
        if (binaryTreeNode == null) {
            return true;
        }
        LinkedList<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
        queue.addLast(binaryTreeNode);
        int flag = 0;
        while (! queue.isEmpty()) {
            BinaryTreeNode node = queue.removeFirst();
            if (node == null) {
                flag = 1;
                continue;
            } else if (flag == 1) {
                return false;
            }
            queue.addLast(node.left);
            queue.addLast(node.right);
        }
        return true;
    }

    public static void main(String[] stringArray) {
        BinaryTreeNode[] tree = new BinaryTreeNode[7];
        for (int i = 0; i < 7; ++ i) {
            tree[i] = new BinaryTreeNode();
            tree[i].value = "" + i;
            tree[i].left = null;
            tree[i].right = null;
        }
        {
            tree[0].left = tree[1];
            tree[0].right = tree[2];
            tree[1].left = tree[3];
            tree[1].right = tree[4];
            tree[2].left = tree[5];
            tree[2].right = null;
            boolean result = doDirtyWork(tree[0]);
            System.out.println(result);
        }
        {
            tree[0].left = tree[1];
            tree[0].right = tree[2];
            tree[1].left = tree[3];
            tree[1].right = tree[4];
            boolean result = doDirtyWork(tree[0]);
            System.out.println(result);
        }
        {
            tree[0].left = tree[1];
            tree[0].right = tree[2];
            tree[1].left = tree[3];
            tree[1].right = tree[4];
            tree[2].left = null;
            tree[2].right = tree[6];
            boolean result = doDirtyWork(tree[0]);
            System.out.println(result);
        }
    }
}
