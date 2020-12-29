package com.chstore.ca.employee.alg;


public class LinkedList {

    private Node head;

    // insert the data
    public void insertAtHead(final int data) {

        Node newNode = new Node(data);
        newNode.setNextNode(this.head);
        this.head = newNode;
    }

    //delete the first node
    public void deleteFromHead() {
        this.head = this.head.getNextNode();
    }

    //search the data
    public Node search(final int search) {

        Node currentNode = this.head;

        while (currentNode != null) {
            if (currentNode.getData() == search) {
                return currentNode;
            }
            currentNode = currentNode.getNextNode();

        }
        return null;
    }

    //
    public int length() {
        int lenght = 0;
        Node currentNode = this.head;
        while (currentNode != null) {
            lenght++;
            currentNode = currentNode.getNextNode();
        }
        return lenght;
    }

    @Override
    public String toString() {

        StringBuilder s = new StringBuilder("{");
        Node currentNode = this.head;
        //loop until null value of current node
        while (currentNode != null) {
            s.append(currentNode.toString())
                    .append(",");
            currentNode = currentNode.getNextNode();
        }
        s.append("}");
        return s.toString();
    }
}
