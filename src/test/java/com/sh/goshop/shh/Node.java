package com.sh.goshop.shh;

public class Node {

    //链表用于存储值
    private final int value;
    //指向下一个节点  理解为Node next更加恰当
    private Node next;

    public Node(int value) {
        this.value = value;
        this.next = null;
    }

    public int getValue() {
        return value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
