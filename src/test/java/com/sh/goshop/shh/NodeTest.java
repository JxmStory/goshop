package com.sh.goshop.shh;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Stack;

@SpringBootTest
public class NodeTest {

    private Node node = new Node(1);

    {
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        node2.setNext(node3);
        node1.setNext(node2);
        node.setNext(node1);
        print(node);
    }

    /**
     * 递归反转
     */
    @Test
    public void reverserDg() {
        node = dg(node);
        print(node);
    }

    private Node dg(Node node) {
        Node next = node.getNext();
        if (next == null) {
            return node;
        }
        Node head = dg(next);
        next.setNext(node);
        node.setNext(null);
        return head;

    }

    /**
     * 堆栈反转
     */
    @Test
    public void reverser(){
        Stack<Node> nodeStack = new Stack<>();
        Node head = null;
        while (node != null){
            nodeStack.push(node);
            node = node.getNext();
        }
        if (!nodeStack.isEmpty()) {
            head = nodeStack.pop();
        }
        while (!nodeStack.isEmpty()){
            Node tempNode = nodeStack.pop();
            tempNode.getNext().setNext(tempNode);
            tempNode.setNext(null);
        }
        print(head);
    }

    private void print(Node node) {
        if (node == null) {
            System.out.println("---");
        } else {
            System.out.println(node.getValue());
            node = node.getNext();
            print(node);
        }
    }

}

class Node {

    private final int value;

    private Node next;

    Node(int value) {
        this.value = value;
        this.next = null;
    }

    int getValue() {
        return value;
    }

    Node getNext() {
        return next;
    }

    void setNext(Node next) {
        this.next = next;
    }
}
