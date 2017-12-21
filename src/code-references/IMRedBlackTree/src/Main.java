import tree.IMRedBlackBST;
import tree.Node;

public class Main {

    public static void main(String[] args) {
        IMRedBlackBST rbBST = new IMRedBlackBST();

        for (int i = 1; i <= 4; i++) {
            rbBST.insert(i);
        }

        System.out.println(rbBST);
        rbBST.inorderTreeWalk(value -> System.out.print(String.valueOf(value) + " "));
        System.out.println();

        System.out.println("Height: " + rbBST.getHeight());
        System.out.println("Max node: " + rbBST.getMaximum(rbBST.getRoot()));
        System.out.println("Min node: " + rbBST.getMinimum(rbBST.getRoot()));

        Node node = rbBST.search(4);
        System.out.println("Depth (4): " + node.getDepth());

        rbBST.clear();
        rbBST.insert(41);
        rbBST.insert(38);
        rbBST.insert(31);
        rbBST.insert(12);
        rbBST.insert(19);
        rbBST.insert(8);
        System.out.println();
        System.out.println(rbBST);

        rbBST.delete(rbBST.search(8));
        System.out.println(rbBST);
    }
}
