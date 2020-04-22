package io.tguduru.ds.lab.leetcode.linkedin;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * Problem Statement:
 *
 *
 * Implement a data structure supporting the following operations:
 *
 * Inc(Key) - Inserts a new key with value 1. Or increments an existing key by 1. Key is guaranteed to be a non-empty string.
 * Dec(Key) - If Key's value is 1, remove it from the data structure. Otherwise decrements an existing key by 1. If the key does not exist, this function does nothing. Key is guaranteed to be a non-empty string.
 * GetMaxKey() - Returns one of the keys with maximal value. If no element exists, return an empty string "".
 * GetMinKey() - Returns one of the keys with minimal value. If no element exists, return an empty string "".
 * Challenge: Perform all these in O(1) time complexity.
 *
 *
 * Questions:
 * 1. do we need to worry about case?
 *
 * Constraints:
 * 1.
 *
 * @author Guduru, Thirupathi Reddy
 * created 8/27/19
 */
public class AllOne {
    Map<String, Node> nodeMap = new HashMap<>();
    Node head, tail;

    public static void main(String[] args) {
        AllOne allOne = new AllOne();
        allOne.increment("a");
        allOne.increment("b");
        allOne.increment("b");
        allOne.increment("b");
        allOne.increment("b");



        allOne.decrement("b");


        System.out.println("All Key: " + allOne.head);
        System.out.println("Max Key: " + allOne.getMaxKey().getKeys());
        System.out.println("Min Key: " + allOne.getMinKey().getKeys());
    }

    public void increment(final String key) {
        if (Objects.isNull(key))
            return;
        Node node = nodeMap.get(key);
        // key not found and no keys exists means this is the first one so add it as head and tail.
        if (node == null) {
            if (head == null) {
                Node newNode = new Node();
                newNode.setValue(1);
                newNode.getKeys().add(key);
                head = tail = newNode;
                nodeMap.put(key, newNode);
            }
            // key not found but some keys exists so add it to the head keys
            else {
                //add only if the head value is 1 else create a new node and make that as head
                if (head.getValue() == 1) {
                    head.getKeys().add(key);
                    // add the key to the map
                    nodeMap.put(key, head);
                } else {
                    Node newNode = new Node();
                    newNode.setValue(1);
                    newNode.getKeys().add(key);

                    Node temp = head;
                    newNode.setNextNode(temp);
                    temp.setPrevNode(newNode);
                    head = newNode;
                    tail = temp;

                    // add the key to the map
                    nodeMap.put(key, newNode);
                }
            }
        }
        //key found so increment and add a new node
        else {
            long currentValue = node.getValue();
            //this is the only key exists in the node and head tail both are same then just increment the value, means there is only one node with one key
            if (node.getKeys().size() == 1 && (head == tail)) {
                node.setValue(currentValue + 1);
                // add the key to the map
                nodeMap.put(key, node);
            }
            // head tail not same so we need add a new node or move the key to next node
            else {

                //hold the next node of the found node
                Node temp = node.getNextNode();
                //next value presents to add the keys to next node
                if (temp != null) {
                    temp.getKeys().add(key);
                    // add the key to the map
                    nodeMap.put(key, temp);
                }
                //no next node so increment and set the tail.
                else {
                    Node newNode = new Node();
                    newNode.setValue(currentValue + 1);
                    newNode.getKeys().add(key);

                    // add new node

                    node.setNextNode(newNode);
                    //temp is null means this new node will be the tail
                    tail = newNode;
                    // add the key to the map
                    nodeMap.put(key, newNode);

                }
                //remove keys from current node
                node.getKeys().remove(key);

                //if node doesn't contain any elements then move the head
                if (node.getKeys().isEmpty())
                    head = node.getNextNode();
            }
        }
    }

    public void decrement(String key) {
        Node foundKeyNode = nodeMap.get(key);
        //key doesnt exists dont do anything...
        if (foundKeyNode == null)
            return;
        // means we are removing the key from the head
        if (foundKeyNode.getValue() == 1) {
            foundKeyNode.getKeys().remove(key);
            //there is only one node with one key
            if (foundKeyNode.getKeys().isEmpty() && foundKeyNode.getNextNode() == null) {
                head = tail = null;
            }
            // move the head
            else {
                head = foundKeyNode.getNextNode();
            }
            //remove the key from the map
            nodeMap.remove(key);
        }
        // we are removing a key which is in the list some where
        else {
            Node temp = foundKeyNode.getPrevNode();
            if(temp.getValue() == foundKeyNode.getValue() - 1) {
                // add the key to previous node, means decreasing as the list in ascending order
                temp.getKeys().add(key);
                //reset the key's node in the map
                nodeMap.put(key, temp);
                //remove the key
                foundKeyNode.getKeys().remove(key);
            }else{
                foundKeyNode.setValue(foundKeyNode.getValue() - 1);
            }

            // means its the tail element we are removing & no elements in the tail
            if (foundKeyNode.getNextNode() == null && foundKeyNode.getKeys().isEmpty()) {
                tail = temp;
            }
            // removing key in the middle
            else {
                // if no keys then remove the node
                if (foundKeyNode.getKeys().isEmpty()) {
                    temp.setNextNode(foundKeyNode.getNextNode());
                }
            }
        }
    }

    public Node getMaxKey() {
        return tail;
    }

    public Node getMinKey() {
        return head;
    }

    static class Node {
        long value;
        Node prevNode;
        Node nextNode;
        Set<String> keys;

        public Node() {
            keys = new HashSet<>();
        }

        public long getValue() {
            return value;
        }

        public Node setValue(final long value) {
            this.value = value;
            return this;
        }

        public Node getPrevNode() {
            return prevNode;
        }

        public Node setPrevNode(final Node prevNode) {
            this.prevNode = prevNode;
            return this;
        }

        public Node getNextNode() {
            return nextNode;
        }

        public Node setNextNode(final Node nextNode) {
            this.nextNode = nextNode;
            return this;
        }

        public Set<String> getKeys() {
            return keys;
        }

        public Node setKeys(final Set<String> keys) {
            this.keys = keys;
            return this;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Node{");
            sb.append("value=").append(value);
            sb.append(", nextNode=").append(nextNode);
            sb.append(", keys=").append(keys);
            sb.append('}');
            return sb.toString();
        }
    }
}
