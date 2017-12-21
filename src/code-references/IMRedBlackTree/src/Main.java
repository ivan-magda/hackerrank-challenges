import tree.IMRedBlackBST;

public class Main {

    public static void main(String[] args) {
        IMRedBlackBST tree = new IMRedBlackBST();

        for (int i = 1; i <= 4; i++) {
            tree.insert(i);
        }

        System.out.println(tree);
    }
}
