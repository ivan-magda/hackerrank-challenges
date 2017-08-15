package com.ivanmagda.test;

import com.ivanmagda.interfacelable.EmptyBST;
import com.ivanmagda.interfacelable.Tree;

import java.util.Random;

public class Utils {

    private static final Random random = new Random();

    private Utils() {
    }

    public static int getRandomIntInBounds(int min, int max) {
        return random.nextInt((max - min) + 1) + min;
    }

    public static Tree<Integer> buildRandomTree(int count) {
        if (count == 0) {
            return new EmptyBST<>();
        }

        return buildRandomTree(count - 1).add(getRandomIntInBounds(0, 100));
    }
}
