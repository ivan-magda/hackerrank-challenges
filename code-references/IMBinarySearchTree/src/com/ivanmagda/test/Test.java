package com.ivanmagda.test;

import com.ivanmagda.interfacelable.EmptyBST;
import com.ivanmagda.interfacelable.NonEmptyBST;
import com.ivanmagda.interfacelable.Tree;

public class Test {

    private Test() {
    }

    private static <T extends Comparable<T>> void checkIsEmpty(Tree<T> tree) throws Exception {
        if (tree instanceof EmptyBST && !tree.isEmpty()) {
            throw new Exception("EmptyBST must be an empty");
        } else if (tree instanceof NonEmptyBST && tree.isEmpty()) {
            throw new Exception("NonEmptyBST must be non empty");
        }
    }

    private static <T extends Comparable<T>> void checkAddMemberCardinality(Tree<T> tree, T data) throws Exception {
        int originalCardinality = tree.cardinality();
        int newCardinality = tree.add(data).cardinality();

        if (newCardinality == (originalCardinality + 1)) {
            if (tree.isMember(data)) {
                throw new Exception(String.valueOf(data) + ": "
                        + "the cardinality increased by 1, but the thing that was added was already a member of the tree.");
            }
        } else if (newCardinality == originalCardinality) {
            if (!tree.isMember(data)) {
                throw new Exception(String.valueOf(data) + ": "
                        + "the cardinality didn't increased by 1, but we added a new thing.");
            }
        } else {
            throw new Exception("Something is wrong");
        }
    }

    public static void main(String[] args) throws Exception {
        EmptyBST<Integer> eTree = new EmptyBST<>();
        NonEmptyBST<Integer> nTree = NonEmptyBST.buildFrom(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9});

        checkIsEmpty(eTree);
        checkIsEmpty(new NonEmptyBST<>(10));
        checkIsEmpty(nTree);

        checkAddMemberCardinality(eTree, 22);
        checkAddMemberCardinality(nTree, 12);
        checkAddMemberCardinality(nTree, 1);

        int tests = 1000;
        for (int i = 0; i < tests; i++) {
            Tree<Integer> tree;
            if (i % 10 == 0) {
                tree = Utils.buildRandomTree(0);
            } else {
                tree = Utils.buildRandomTree(10);
            }

            checkAddMemberCardinality(tree, i);
        }

        System.out.println("All tests passed.");
    }
}
