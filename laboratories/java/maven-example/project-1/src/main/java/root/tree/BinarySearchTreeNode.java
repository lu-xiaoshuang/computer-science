/*
 *  Copyright (C) 2018 Xiaoshuang LU
 *  All rights reserved.
 */

package root.tree;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTreeNode {
    public BinarySearchTreeNode parent;

    public BinarySearchTreeNode left;

    public BinarySearchTreeNode right;

    public String value;

    public static void main(String[] stringArray) {
        BinarySearchTreeNode binarySearchTreeNode = new BinarySearchTreeNode();
        binarySearchTreeNode.parent = null;
        binarySearchTreeNode.left = null;
        binarySearchTreeNode.right = null;
    }
}
