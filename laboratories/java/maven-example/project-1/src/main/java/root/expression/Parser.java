/*
 *  Copyright (C) 2018 Xiaoshuang LU
 *  All rights reserved.
 */

package root.expression;

public class Parser {
    private static void depthFirstSearch(TreeNode treeNode, StringBuilder stringBuilder) {
        if (treeNode.children != null && ! treeNode.children.isEmpty()) {
            if ("AND".equalsIgnoreCase(treeNode.operator)) {
                stringBuilder.append("(");
                for (TreeNode child : treeNode.children) {
                    depthFirstSearch(child, stringBuilder);
                    stringBuilder.append(" && ");
                }
                if (! treeNode.children.isEmpty()) {
                    stringBuilder.delete(stringBuilder.length() - 4, stringBuilder.length());
                }
                stringBuilder.append(")");
            } else if ("OR".equalsIgnoreCase(treeNode.operator)) {
                stringBuilder.append("(");
                for (TreeNode child : treeNode.children) {
                    depthFirstSearch(child, stringBuilder);
                    stringBuilder.append(" || ");
                }
                if (! treeNode.children.isEmpty()) {
                    stringBuilder.delete(stringBuilder.length() - 4, stringBuilder.length());
                }
                stringBuilder.append(")");
            }
        } else {
            stringBuilder.append("handle(");
            stringBuilder.append("\"");
            stringBuilder.append(treeNode.key);
            stringBuilder.append("\"");
            stringBuilder.append(")");
        }
    }

    private static void test1() {
        TreeNode treeNode = new TreeNode();
        treeNode.key = "1";
        StringBuilder stringBuilder = new StringBuilder();
        depthFirstSearch(treeNode, stringBuilder);
        System.out.println(stringBuilder.toString());
    }

    private static void test2() {
        TreeNode[] treeNodeArray = new TreeNode[19];
        for (int i = 0; i < treeNodeArray.length; ++ i) {
            treeNodeArray[i] = new TreeNode();
        }
        {
            treeNodeArray[0].children.add(treeNodeArray[1]);
            treeNodeArray[0].children.add(treeNodeArray[2]);
            treeNodeArray[0].children.add(treeNodeArray[3]);
            treeNodeArray[0].operator = "AND";
        }
        {
            treeNodeArray[1].children.add(treeNodeArray[4]);
            treeNodeArray[1].children.add(treeNodeArray[5]);
            treeNodeArray[1].children.add(treeNodeArray[6]);
            treeNodeArray[1].operator = "OR";
        }
        {
            treeNodeArray[2].children.add(treeNodeArray[7]);
            treeNodeArray[2].children.add(treeNodeArray[8]);
            treeNodeArray[2].children.add(treeNodeArray[9]);
            treeNodeArray[2].operator = "OR";
        }
        {
            treeNodeArray[3].key = "3";
        }
        {
            treeNodeArray[4].children.add(treeNodeArray[10]);
            treeNodeArray[4].children.add(treeNodeArray[11]);
            treeNodeArray[4].children.add(treeNodeArray[12]);
            treeNodeArray[4].operator = "AND";
        }
        {
            treeNodeArray[5].children.add(treeNodeArray[13]);
            treeNodeArray[5].children.add(treeNodeArray[14]);
            treeNodeArray[5].children.add(treeNodeArray[15]);
            treeNodeArray[5].operator = "AND";
        }
        {
            treeNodeArray[6].children.add(treeNodeArray[16]);
            treeNodeArray[6].children.add(treeNodeArray[17]);
            treeNodeArray[6].children.add(treeNodeArray[18]);
            treeNodeArray[6].operator = "AND";
        }
        {
            treeNodeArray[7].key = "7";
        }
        {
            treeNodeArray[8].key = "8";
        }
        {
            treeNodeArray[9].key = "9";
        }
        {
            treeNodeArray[10].key = "10";
        }
        {
            treeNodeArray[11].key = "11";
        }
        {
            treeNodeArray[12].key = "12";
        }
        {
            treeNodeArray[13].key = "13";
        }
        {
            treeNodeArray[14].key = "14";
        }
        {
            treeNodeArray[15].key = "15";
        }
        {
            treeNodeArray[16].key = "16";
        }
        {
            treeNodeArray[17].key = "17";
        }
        {
            treeNodeArray[18].key = "18";
        }
        StringBuilder stringBuilder = new StringBuilder();
        depthFirstSearch(treeNodeArray[0], stringBuilder);
        System.out.println(stringBuilder.toString());
    }

    private static boolean shortCut(String label, boolean flag) {
        System.out.println(label);
        return flag;
    }

    public static void main(String[] stringArray) {
        test1();
        test2();
        System.out.println(shortCut("1", false) && shortCut("2", false));
        System.out.println(shortCut("3", true) || shortCut("4", true));
    }
}
