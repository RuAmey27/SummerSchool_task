import java.util.ArrayList;
import java.util.List;

class JosephusProblem {

    public static void main(String[] args) {
        int numFriends = 5; // Number of friends
        int count = 2;      // Counting every 2nd person

        int survivor = findTheWinner(numFriends, count);
        System.out.println("The survivor is Friend " + survivor);
    }

    public static int findTheWinner(int n, int k) {
        List<Integer> friends = new ArrayList<>();
        
        // Populate the list with friends numbered from 1 to n
        for (int i = 1; i <= n; i++) {
            friends.add(i);
        }
        
        int index = 0;
        while (friends.size() > 1) {
            // Find the index of the next person to be removed
            index = (index + k - 1) % friends.size();
            
            // Print the current state of friends and the person to be removed
            System.out.print("Current friends: ");
            for (int friend : friends) {
                System.out.print(friend + " ");
            }
            System.out.println();
            System.out.println("Removing Friend at index " + index + ": " + friends.get(index));
            
            // Remove the person at the found index
            friends.remove(index);
        }
        
        // Return the last remaining person (index 0 in the list)
        return friends.get(0);
    }
}
