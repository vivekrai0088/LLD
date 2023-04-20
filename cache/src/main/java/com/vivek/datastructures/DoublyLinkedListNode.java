package com.vivek.datastructures;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DoublyLinkedListNode<Key> {

  private Key key;
  private DoublyLinkedListNode<Key> prev;
  private DoublyLinkedListNode<Key> next;

  public DoublyLinkedListNode(Key key) {
    this.key = key;
    this.prev = null;
    this.next = null;
  }

}
