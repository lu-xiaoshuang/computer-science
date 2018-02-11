/*
 *  Copyright (C) 2018 Xiaoshuang LU
 *  All rights reserved.
 */

package root;

public class SingleList {
    private static class ListNode {
        public ListNode next;

        public String value;
    }

    public static ListNode reverse(ListNode listNode) {
        if (listNode == null || listNode.next == null) {
            return listNode;
        }
        ListNode prev = null;
        ListNode curr = listNode;
        ListNode next = listNode.next;
        while (next != null) {
            curr.next = prev;
            prev = curr;
            curr = next;
            next = next.next;
        }
        curr.next = prev;
        return curr;
    }

    public static ListNode reverseRecursive(ListNode listNode) {
        if (listNode == null || listNode.next == null) {
            return listNode;
        }
        ListNode temporary = reverseRecursive(listNode.next);
        temporary.next = listNode;
        listNode.next = null;
        return listNode;
    }

    public static void main(String[] stringArray) {
        ListNode[] list = new ListNode[8];
        for (int i = 0; i < 8; ++ i) {
            list[i] = new ListNode();
            list[i].value = "" + (7 - i);
        }
        list[0].next = list[1];
        list[1].next = list[2];
        list[2].next = list[3];
        list[3].next = list[4];
        list[4].next = list[5];
        list[5].next = list[6];
        list[6].next = list[7];
        list[7].next = null;
        ListNode result = reverse(list[0]);
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
        System.out.println();
        reverseRecursive(list[7]);
        result = list[0];
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
        System.out.println();
    }
}
