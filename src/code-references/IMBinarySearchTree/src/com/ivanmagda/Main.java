package com.ivanmagda;

import com.ivanmagda.interfacelable.NonEmptyBST;
import com.ivanmagda.naive.BinarySearchTree;

import java.util.*;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        NonEmptyBST<Integer> tree = NonEmptyBST.buildFrom(new Integer[]{4, 2, 6, 1, 3, 5, 7});

        System.out.println("Cardinality: " + tree.cardinality());
        System.out.println("Is empty: " + tree.isEmpty());
        System.out.println("Is contains 5: " + tree.isMember(5));
        System.out.println();

        BinarySearchTree bst = new BinarySearchTree(10);

        bst.add(5);
        bst.add(15);
        bst.add(8);

        System.out.println("Is contains 5: " + (bst.contains(5) ? "Yes" : "No"));
        System.out.println("Is contains 1: " + (bst.contains(1) ? "Yes" : "No"));
        System.out.println();

        bst = new BinarySearchTree(5);
        bst.add(2);
        bst.add(18);
        bst.add(3);
        bst.add(-4);

        System.out.println(bst);
        System.out.println("Min value: " + String.valueOf(bst.getMinimum().getData()));
        System.out.println("Max value: " + String.valueOf(bst.getMaximum().getData()));

        bst.remove(5);
        System.out.println(bst);

        // Tree walks.

        List<Integer> inorderList = new ArrayList<>();
        bst.inorderTreeWalk(inorderList::add);
        System.out.println("Inorder: " + inorderList);

        List<Integer> inorderWithoutRecursionList = new ArrayList<>();
        bst.inorderTreeWalkWithoutRecursion(inorderWithoutRecursionList::add);
        System.out.println("Inorder without recursion: " + inorderWithoutRecursionList);

        List<Integer> preorderList = new ArrayList<>();
        bst.preorderTreeWalk(preorderList::add);
        System.out.println("Preorder: " + preorderList);

        List<Integer> postorderList = new ArrayList<>();
        bst.postorderTreeWalk(postorderList::add);
        System.out.println("Postorder: " + postorderList);

        // Search.

        int length = 10;
        int bound = length * 2;
        int[] values = new int[length];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            values[i] = random.nextInt(bound) + 1;
        }

        bst = new BinarySearchTree(values);
        System.out.println();
        System.out.println(bst);
        System.out.println("Search for 8 (recursion): " + (bst.search(8) != null));
        System.out.println("Search for 8 (iterative): " + (bst.iterativeSearch(8) != null));
    }
}
