package com.sh.goshop.shh;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Queue;
import java.util.Stack;

@SpringBootTest
public class NodeTest {

    @Test
    public void reverser(){
        Node node = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        node2.setNext(node3);
        node1.setNext(node2);
        node.setNext(node1);
        sout(node);

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
        sout(head);
    }

    void sout(Node node) {
        if (node == null) {
            System.out.println("---");
        } else {
            System.out.println(node.getValue());
            node = node.getNext();
            sout(node);
        }
    }

}
