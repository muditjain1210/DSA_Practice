package Stack;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private Map<Integer, DoubleLinkedList> mp;
    private DoubleLinkedList head;
    private DoubleLinkedList tail;
    private int maxSize;
    private int currentSize;

    public LRUCache(int maxSize) {
        this.maxSize = maxSize;
        this.mp = new HashMap<>();
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(3);
        lruCache.insert(1, "one");
        lruCache.insert(2, "two");
        lruCache.insert(3, "three");
        lruCache.get(1);
        lruCache.get(2);
        lruCache.get(2);
        lruCache.printLRUCache();
        System.out.println();
        lruCache.insert(4, "four");
        lruCache.printLRUCache();
    }

    public void insert(int key, String val) {
        if (currentSize == 0) {
            DoubleLinkedList node = new DoubleLinkedList(val);
            head = node;
            tail = node;
            mp.put(key, node);
            currentSize++;
        } else if (mp.containsKey(key)) {
            //Update case
            DoubleLinkedList node = mp.get(key);
            removeNode(node);
            appendToTail(node);
        } else if (currentSize >= maxSize) {
            //remove head
            removeNode(head);
            //Insert in end
            DoubleLinkedList node = new DoubleLinkedList(val);
            appendToTail(node);
            mp.put(key, node);
            currentSize++;
        } else {
            DoubleLinkedList node = new DoubleLinkedList(val);
            appendToTail(node);
            mp.put(key, node);
            currentSize++;
        }
    }

    public String get(int key) {
        if (!mp.containsKey(key)) {
            return "minusOne";
        }
        DoubleLinkedList node = mp.get(key);
        if (node != tail) {
            System.out.println("Moving node to end" + node);
            removeNode(node);
            appendToTail(node);
        }
        return node.val;
    }

    private void appendToTail(DoubleLinkedList node) {
        tail.next = node;
        node.prev = tail;
        node.next = null;
        tail = node;
    }

    private void removeNode(DoubleLinkedList node) {
        DoubleLinkedList prevNode = node.prev;
        DoubleLinkedList nextNode = node.next;
        if (nextNode == null) {
            //this is tail node
            prevNode.next = null;
            tail = prevNode;
        } else if (prevNode == null) {
            //this is head node
            nextNode.prev = null;
            head = nextNode;
        } else {
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
        }
    }

    public void printLRUCache() {
        DoubleLinkedList node = head;
        while (node != null) {
            System.out.print(node.val + "-->");
            node = node.next;
        }
    }

    private static class DoubleLinkedList {
        private DoubleLinkedList prev;
        private DoubleLinkedList next;
        private String val;

        public DoubleLinkedList(String val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "DoubleLinkedList{" +
                    "val='" + val + '\'' +
                    '}';
        }
    }

}
