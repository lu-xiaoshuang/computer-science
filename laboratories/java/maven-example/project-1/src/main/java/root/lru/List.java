/*
 *  Copyright (C) 2018 Xiaoshuang LU
 *  All rights reserved.
 */

package root.lru;

public class List<T> {
    private ListNode<T> listNode;

    private int capacity;

    public List() {
        this.listNode = new ListNode<T>();
        this.listNode.prev = this.listNode;
        this.listNode.next = this.listNode;
        this.capacity = 0;
    }

    public ListNode<T> first() {
        return this.listNode.next;
    }

    public ListNode<T> last() {
        return this.listNode.prev;
    }

    public void addFirst(ListNode<T> node) {
        node.prev = this.listNode;
        this.listNode.next.prev = node;
        node.next = this.listNode.next;
        this.listNode.next = node;
        ++ this.capacity;
    }

    public void addLast(ListNode<T> node) {
        node.next = this.listNode;
        this.listNode.prev.next = node;
        node.prev = this.listNode.prev;
        this.listNode.prev = node;
        ++ this.capacity;
    }

    public void removeFirst() {
        this.listNode.next.next.prev = this.listNode;
        this.listNode.next = this.listNode.next.next;
        -- this.capacity;
    }

    public void removeLast() {
        this.listNode.prev.prev.next = this.listNode;
        this.listNode.prev = this.listNode.prev.prev;
        -- this.capacity;
    }

    public void remove(ListNode<T> node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        -- this.capacity;
    }

    public int getCapacity() {
        return this.capacity;
    }
}
