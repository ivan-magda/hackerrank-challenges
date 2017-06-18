package com.ivanmagda;

public class Main {

    public static void main(String[] args) {
        System.out.println("Fib recursively of 10:    " + IMFibonacci.recursively(10));
        System.out.println("Fib with memorization 10: " + IMFibonacci.recursivelyWithMemorization(10));
        System.out.println("Fib iterative 10:         " + IMFibonacci.iterative(10));
    }
}
