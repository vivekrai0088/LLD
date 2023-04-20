package com.vivek.policies;

import com.vivek.datastructures.DoublyLinkedList;
import com.vivek.datastructures.DoublyLinkedListNode;

import java.util.HashMap;
import java.util.Map;

public class LRUEvictionPolicy<Key> implements EvictionPolicy<Key> {

  private Map<Key, DoublyLinkedListNode<Key>> keyToNodeMappings;
  private DoublyLinkedList<Key> doublyLinkedList;

  public LRUEvictionPolicy() {
    keyToNodeMappings = new HashMap<>();
    doublyLinkedList = new DoublyLinkedList<>();
  }

  public void keyAccessed(Key key) {
    if(keyToNodeMappings.containsKey(key)) {
      doublyLinkedList.removeNodeAndInsertToTail(keyToNodeMappings.get(key));
    } else {
      DoublyLinkedListNode<Key> doublyLinkedListNode = new DoublyLinkedListNode(key);
      keyToNodeMappings.put(key, doublyLinkedListNode);
      doublyLinkedList.insertNodeToTail(doublyLinkedListNode);
    }
  }

  public Key evictKey() {
    DoublyLinkedListNode<Key> removedNode = doublyLinkedList.removeNodeFromHead();
    if(removedNode == null) {
      return null;
    }
    return removedNode.getKey();
  }
}
