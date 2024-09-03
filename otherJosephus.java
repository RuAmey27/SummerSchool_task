import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class otherJosephus {

    public static void main(String[] args) {
        int numFriends = 5; // Number of friends
        int count = 2;      // Counting every 2nd person

        int survivor = findTheWinner(numFriends, count);
        System.out.println("The survivor is Friend " + survivor);
    }

    public static int findTheWinner(int n, int k) {
        List<Integer> friends = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            friends.add(i); // Populate LinkedList with friends numbered from 1 to n
        }

        return recursion(n, k, friends) + 1; // Adjust to 1-based index
    }

    private static int recursion(int n, int k, List<Integer> friends) {
        if (n == 1) {
            return friends.get(0); // Base case: If there is only one person, return their position
        }

        int position = (recursion(n - 1, k, friends) + k) % n;
        System.out.println("n = " + n + ", k = " + k + ", Position: " + position);
        System.out.println("Stack Trace: " + friends); // Print stack trace (LinkedList state)

        friends.remove(position); // Remove the friend at the calculated position

        return position;
    }
}
