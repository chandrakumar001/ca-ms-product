package com.chstore.ca.employee.alg;

import lombok.ToString;

public class Node {
    private int data;
    private Node nextNode;

    public Node(int data) {
        this.data = data;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                '}';
    }
}
