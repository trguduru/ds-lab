package io.tguduru.ds.lab.leetcode.linkedin;


import java.util.HashMap;
import java.util.Map;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
 * <p>
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 * <p>
 * The cache is initialized with a positive capacity.
 * <p>
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 *
 *
 * SOLUTION: O(1)
 *   1. Use Map to store the data
 *    1.1 Key as Map key
 *    1.2 Value as a doubly linked list node
 * @author Guduru, Thirupathi Reddy
 * created 9/10/19
 */
public class LRUCache {
    private long capacity;
    private Map<Long, Node<Long>> cacheStore;
    private Node<Long> lruNode; // least recently used
    private Node<Long> mruNode; // most recently used

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(3);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.put(3, 3);
        lruCache.put(4, 4);
        System.out.println(lruCache.get(4));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(2));
        System.out.println(lruCache.get(1));
        lruCache.put(5, 5);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));
        System.out.println(lruCache.get(5));
    }


    public LRUCache(long capacity) {
        this.capacity = capacity;
        cacheStore = new HashMap<>();
    }

    public long get(long key) {
        Node<Long> value = cacheStore.get(key);
        if (value != null) { //reset lru only if the lru key is the same as the get key
            updateLRUNode(value);
            return value.getData();
        }

        return -1;
    }

    public void put(long key, long value) {
        // check whether the key exists or not
        Node<Long> existingNode = cacheStore.get(key);
        if (existingNode != null) { // key exists so set the value and set the mru to this node
            existingNode.setData(value);
            updateLRUNode(existingNode);
            cacheStore.put(key, existingNode);
        } else { // adding a new key
            if (cacheStore.size() == capacity) { // remove lru node
                removeLRUNode();
            }

            Node<Long> newNode = new Node<>(value);
            addNode(newNode);
            cacheStore.put(key, newNode);
        }
    }

    private void updateLRUNode(Node<Long> node) {
        if (node.equals(lruNode)) {
            lruNode = node.getNextNode();
            lruNode.setPreviousNode(null);
            Node<Long> newNode = new Node<>(node.getData());
            newNode.setPreviousNode(mruNode);
            mruNode.setNextNode(newNode);
            mruNode = newNode;
        } else if (node.getNextNode() != null && node.getPreviousNode() != null) {
            Node<Long> temp = node.getPreviousNode();
            temp.setNextNode(node.getNextNode());
            Node<Long> newNode = new Node<>(node.getData());
            newNode.setPreviousNode(mruNode);
            mruNode.setNextNode(newNode);
            mruNode = newNode;
        }
    }

    private void addNode(Node<Long> node) {
        if (node == null)
            throw new RuntimeException("Cannot insert 0 as key");
        if (lruNode == null) { // this is the first node
            lruNode = mruNode = node;
        } else {
            node.setPreviousNode(mruNode);
            mruNode.setNextNode(node);
            mruNode = node;
        }
    }

    private void removeLRUNode() {
        cacheStore.remove(lruNode.getData()); // remove the lru data
        lruNode = lruNode.getNextNode(); // remove root node
        lruNode.setPreviousNode(null); // this is the root so no previous
    }

    /**
     * Doubly linked list node
     *
     * @param <E>
     */
    class Node<E> {
        private E data;
        private Node<E> nextNode;
        private Node<E> previousNode;

        public Node(E data) {
            this.data = data;
        }

        public E getData() {
            return data;
        }

        public void setData(E data) {
            this.data = data;
        }

        public Node<E> getNextNode() {
            return nextNode;
        }

        public void setNextNode(Node<E> nextNode) {
            this.nextNode = nextNode;
        }

        public Node<E> getPreviousNode() {
            return previousNode;
        }

        public Node<E> setPreviousNode(Node<E> previousNode) {
            this.previousNode = previousNode;
            return this;
        }
    }
}
