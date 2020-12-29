package com.chstore.ca.employee.alg;

public class TestClient {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.insertAtHead(11);
        linkedList.insertAtHead(12);
        linkedList.insertAtHead(54);
        linkedList.insertAtHead(2);

        linkedList.deleteFromHead();
        System.out.println(linkedList);
        System.out.println(linkedList.length());
        System.out.println(linkedList.search(15));
    }
}
