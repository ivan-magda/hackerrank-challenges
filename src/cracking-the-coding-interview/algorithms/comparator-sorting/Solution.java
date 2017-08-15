import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Checker implements Comparator<Player> {

    @Override
    public int compare(Player lhs, Player rhs) {
        if (lhs.score != rhs.score) {
            return rhs.score - lhs.score;
        }

        int res = String.CASE_INSENSITIVE_ORDER.compare(lhs.name, rhs.name);
        if (res == 0) {
            res = lhs.name.compareTo(rhs.name);
        }

        return res;
    }
}

class Player {
    String name;
    int score;

    Player(String name, int score) {
        this.name = name;
        this.score = score;
    }
}

class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Player[] players = new Player[n];
        Checker checker = new Checker();

        for (int i = 0; i < n; i++) {
            players[i] = new Player(scan.next(), scan.nextInt());
        }
        scan.close();

        Arrays.sort(players, checker);
        for (Player anPlayer : players) {
            System.out.printf("%s %s\n", anPlayer.name, anPlayer.score);
        }
    }
}
