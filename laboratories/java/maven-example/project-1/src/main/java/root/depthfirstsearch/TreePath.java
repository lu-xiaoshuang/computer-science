/*
 *  Copyright (C) 2018 Xiaoshuang LU
 *  All rights reserved.
 */

package root.depthfirstsearch;

import java.util.LinkedList;

public class TreePath {
    private static class TreeNode {
        public TreeNode[] children;

        public String value;
    }

    private static void doDirtyWork1(TreeNode root, TreeNode target, LinkedList<TreeNode> result) {
        if (root == null) {
            return;
        }
        if (root == target) {
            //result.addLast(root);
            for (TreeNode node : result) {
                System.out.print(node.value + " ");
            }
            System.out.println();
            //result.removeLast();
            return;
        }
        result.addLast(root);
        /*if (root.children == null) {
            for (TreeNode node : result) {
                System.out.print(node.value + " ");
            }
            System.out.println();
        }*/
        if (root.children != null) {
            for (TreeNode node : root.children) {
                doDirtyWork1(node, target, result);
            }
        }
        result.removeLast();
    }

    public static void main(String[] stringArray) {
        TreeNode[] treeNodeArray = new TreeNode[5];
        for (int i = 0; i < 5; ++ i) {
            treeNodeArray[i] = new TreeNode();
        }
        treeNodeArray[0].value = "0";
        treeNodeArray[0].children = new TreeNode[2];
        treeNodeArray[0].children[0] = treeNodeArray[1];
        treeNodeArray[0].children[1] = treeNodeArray[2];
        treeNodeArray[1].value = "1";
        treeNodeArray[1].children = new TreeNode[2];
        treeNodeArray[1].children[0] = treeNodeArray[3];
        treeNodeArray[1].children[1] = treeNodeArray[4];
        treeNodeArray[2].value = "2";
        treeNodeArray[2].children = new TreeNode[2];
        treeNodeArray[2].children[0] = null;
        treeNodeArray[2].children[1] = null;
        treeNodeArray[3].value = "3";
        treeNodeArray[3].children = new TreeNode[2];
        treeNodeArray[3].children[0] = null;
        treeNodeArray[3].children[1] = null;
        treeNodeArray[4].value = "4";
        treeNodeArray[4].children = new TreeNode[2];
        treeNodeArray[4].children[0] = null;
        treeNodeArray[4].children[1] = null;
        doDirtyWork1(treeNodeArray[0], treeNodeArray[0], new LinkedList<TreeNode>());
        doDirtyWork1(treeNodeArray[0], treeNodeArray[1], new LinkedList<TreeNode>());
        doDirtyWork1(treeNodeArray[0], treeNodeArray[2], new LinkedList<TreeNode>());
        doDirtyWork1(treeNodeArray[0], treeNodeArray[3], new LinkedList<TreeNode>());
        doDirtyWork1(treeNodeArray[0], treeNodeArray[4], new LinkedList<TreeNode>());
        int[] array1 = new int[] { 0, 1 };
        int[] array2 = new int[] { 0, 1, 4 };
        int length = array1.length < array2.length ? array1.length : array2.length;
        int index = 0;
        while (index < length) {
            if (array1[index] != array2[index]) {
                break;
            }
            ++ index;
        }
        System.out.println(index - 1);
    }
}
