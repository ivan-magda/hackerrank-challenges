import tree.IMRedBlackBST;
import tree.Node;

public class Main {

    public static void main(String[] args) {
        IMRedBlackBST rbBST = new IMRedBlackBST();

        for (int i = 1; i <= 4; i++) {
            rbBST.insert(i);
        }

        System.out.println(rbBST);

        Node node = rbBST.search(4);
        System.out.println("Depth (4): " + node.getDepth());
    }
}
