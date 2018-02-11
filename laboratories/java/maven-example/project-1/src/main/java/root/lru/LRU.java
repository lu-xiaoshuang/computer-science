/*
 *  Copyright (C) 2018 Xiaoshuang LU
 *  All rights reserved.
 */

package root.lru;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;

public class LRU {
    private int capacity = 4;

    private List<Map.Entry<String, String>> list = new List<Map.Entry<String, String>>();

    private Map<String, ListNode<Map.Entry<String, String>>> map = new HashMap<String, ListNode<Map.Entry<String, String>>>();

    public String read(String key) {
        ListNode<Map.Entry<String, String>> listNode = this.map.get(key);
        if (listNode == null) {
            return null;
        }
        this.list.remove(listNode);
        this.list.addFirst(listNode);
        return listNode.value.getValue();
    }

    public void write(String key, String value) {
        Map.Entry<String, String> entry = new AbstractMap.SimpleEntry<String, String>(key, value);
        ListNode<Map.Entry<String, String>> listNode = this.map.get(key);
        if (listNode == null) {
            listNode = new ListNode<Map.Entry<String, String>>();
            listNode.value = entry;
            if (this.list.getCapacity() >= this.capacity) {
                ListNode<Map.Entry<String, String>> last = this.list.last();
                this.list.removeLast();
                this.map.remove(last.value.getKey());
            }
            this.list.addFirst(listNode);
            this.map.put(key, listNode);
        } else {
            listNode.value = entry;
            this.list.remove(listNode);
            this.list.addFirst(listNode);
        }
    }

    public static void main(String[] stringArray) {

    }
}
