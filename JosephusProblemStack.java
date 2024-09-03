import java.util.LinkedList;
import java.util.List;

// Custom Stack class to store snapshots of LinkedList
class Stack {
    Node head;

    // Node representing each state of LinkedList
    class Node {
        List<Integer> state;
        Node next;

        Node(List<Integer> state) {
            this.state = new LinkedList<>(state); // Store a copy of the current state
            this.next = null;
        }
    }

    // Method to push a state onto the stack
    void push(List<Integer> state) {
        Node newNode = new Node(state);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    // Method to pop a state from the stack
    List<Integer> pop() {
        if (head == null) {
            return null;
        }
        List<Integer> state = head.state;
        head = head.next;
        return state;
    }

    // Method to check if the stack is empty
    boolean isEmpty() {
        return head == null;
    }
}

public class JosephusProblemStack {

    public static void main(String[] args) {
        int numFriends = 6; // Number of friends
        int count = 5;      // Counting every 2nd person

        int survivor = findTheWinner(numFriends, count);
        System.out.println("The survivor is Friend " + survivor);
    }

    public static int findTheWinner(int n, int k) {
        List<Integer> friends = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            friends.add(i); // Populate LinkedList with friends numbered from 1 to n
        }

        Stack stack = new Stack();
        recursion(n, k, friends, stack); // Start recursion with initial state

        // Pop final state from stack to determine the survivor
        List<Integer> finalState = stack.pop();
        return finalState.get(0); // Survivor is the last remaining friend
    }

    private static int recursion(int n, int k, List<Integer> friends, Stack stack) {
        if (n == 1) {
            stack.push(friends); // Push final state (only one person left)
            return 0;
        }

        int position = (recursion(n - 1, k, friends, stack) + k) % n;
        System.out.println("n = " + n + ", k = " + k + ", Position: " + position);
        System.out.println("Stack Trace: " + friends); // Print current state of LinkedList

        // Adjust position to stay within bounds of the current size of the list
        position = position % friends.size();

        friends.remove(position); // Remove the friend at the calculated position
        stack.push(new LinkedList<>(friends)); // Push current state onto stack (create a copy)
        return position;
        
    }
}
