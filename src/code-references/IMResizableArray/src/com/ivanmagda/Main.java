package com.ivanmagda;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        IMResizableArray<Integer> resizableArray = new IMResizableArray<>(10);

        Random random = new Random();
        for (int i = 0; i < 11; i++) {
            resizableArray.append(random.nextInt(100));
        }

        for (int i = 0; i < resizableArray.getSize(); i++) {
            System.out.print(resizableArray.get(i) + " ");
        }
        System.out.println();
    }
}
