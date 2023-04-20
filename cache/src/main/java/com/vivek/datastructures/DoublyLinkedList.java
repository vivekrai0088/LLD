package com.vivek.datastructures;

public class DoublyLinkedList<Key> {

  private DoublyLinkedListNode<Key> dummyHead;
  private DoublyLinkedListNode<Key> dummyTail;

  public DoublyLinkedList() {
    dummyHead = new DoublyLinkedListNode(null);
    dummyTail = new DoublyLinkedListNode(null);

    dummyHead.setNext(dummyTail);
    dummyTail.setPrev(dummyHead);
  }

  public void insertNodeToTail(DoublyLinkedListNode<Key> node) {
    DoublyLinkedListNode dummyTailPrev = dummyTail.getPrev();
    dummyTailPrev.setNext(node);
    node.setPrev(dummyTailPrev);
    node.setNext(dummyTail);
    dummyTailPrev.setPrev(node);
  }

  public void removeNodeAndInsertToTail(DoublyLinkedListNode<Key> node) {
    // TODO: implement
  }

  public DoublyLinkedListNode<Key> removeNodeFromHead() {
    // TODO: implement
    return null;
  }
}
