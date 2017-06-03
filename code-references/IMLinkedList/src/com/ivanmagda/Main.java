package com.ivanmagda;

import com.ivanmagda.core.IMLinkedList;
import com.ivanmagda.core.Node;

public class Main {

    public static void main(String[] args) {
        IMLinkedList<Integer> linkedList = new IMLinkedList<>();
        for (int i = 0; i <= 10; i++) {
            linkedList.add(i);
        }

        System.out.println("First element: " + linkedList.getAt(0));
        System.out.println("Size: " + linkedList.getCount());
        System.out.println("Last element: " + linkedList.getAt(linkedList.getCount() - 1));

        for (Node<Integer> node : linkedList) {
            System.out.print(node.getData() + " ");
        }
        System.out.println("");

        for (int i = 0; i < 2; i++) {
            linkedList.removeLast();
        }
    }
}
