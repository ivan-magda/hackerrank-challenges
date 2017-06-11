import java.util.Scanner;

class Main {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        int staircaseSize = in.nextInt();
        for (int i = 0; i < staircaseSize; i++) {
            int whitespacesCount = (staircaseSize - 1) - i;
            int stairCount = i + 1;

            for (int j = 0; j < whitespacesCount; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < stairCount; j++) {
                System.out.print("#");
            }
            System.out.println();
        }

        in.close();
    }
}
