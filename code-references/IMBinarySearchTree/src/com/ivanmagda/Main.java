package com.ivanmagda;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        NonEmptyBST<Integer> tree = new NonEmptyBST<>(21);
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            tree = tree.add(random.nextInt(100));
        }

        System.out.println("Cardinality: " + tree.cardinality());
        System.out.println("Is empty: " + tree.isEmpty());
        System.out.println("Is contains 5: " + tree.isMember(5));
    }
}
