package com.ivanmagda;

import com.ivanmagda.interfacelable.NonEmptyBST;
import com.ivanmagda.naive.BinarySearchTree;

public class Main {

    public static void main(String[] args) {
        NonEmptyBST<Integer> tree = NonEmptyBST.buildFrom(new Integer[]{4, 2, 6, 1, 3, 5, 7});

        System.out.println("Cardinality: " + tree.cardinality());
        System.out.println("Is empty: " + tree.isEmpty());
        System.out.println("Is contains 5: " + tree.isMember(5));
        System.out.println();

        BinarySearchTree binarySearchTree = new BinarySearchTree(10);

        binarySearchTree.add(5);
        binarySearchTree.add(15);
        binarySearchTree.add(8);

        System.out.println("Is contains 5: " + (binarySearchTree.contains(5) ? "Yes" : "No"));
        System.out.println("Is contains 1: " + (binarySearchTree.contains(1) ? "Yes" : "No"));
    }
}
