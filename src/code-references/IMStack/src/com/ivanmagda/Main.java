package com.ivanmagda;

import com.ivanmagda.core.stack.IMStack;

public class Main {

    public static void main(String[] args) {
        IMStack<Integer> stack = new IMStack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println("Pop firs: " + stack.pop());
        System.out.println("Pop second: " + stack.pop());
        System.out.println("Pop third: " + stack.pop());
        System.out.println("Pop fourth: " + stack.pop());
    }
}
