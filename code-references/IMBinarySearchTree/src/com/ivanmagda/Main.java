package com.ivanmagda;

import com.ivanmagda.core.NonEmptyBST;

public class Main {

    public static void main(String[] args) {
        NonEmptyBST<Integer> tree = NonEmptyBST.buildFrom(new Integer[]{4, 2, 6, 1, 3, 5, 7});

        System.out.println("Cardinality: " + tree.cardinality());
        System.out.println("Is empty: " + tree.isEmpty());
        System.out.println("Is contains 5: " + tree.isMember(5));
    }
}
