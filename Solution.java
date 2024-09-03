class HelloWorld {
    public int firstMissingPositive(int[] nums, LinkedList statusList) {
        int n = nums.length;

        // Step 1: Partition the array so that all positive integers are at the front
        int i = 0;
        while (i < n) {
            if (nums[i] > 0 && nums[i] <= n && nums[i] != nums[nums[i] - 1]) {
                // Swap nums[i] with nums[nums[i] - 1]
                int temp = nums[i];
                int targetIndex = nums[i] - 1;
                statusList.addNode(i, nums[i], nums[targetIndex], temp, nums); // Save state before swap
                nums[i] = nums[targetIndex];
                nums[targetIndex] = temp;
                statusList.addNode(i, nums[i], nums[targetIndex], temp, nums); // Save state after swap
            } else {
                statusList.addNode(i, nums[i], (nums[i] > 0 && nums[i] <= n) ? nums[nums[i] - 1] : -1, -1, nums); // Save state before increment
                i++;
            }
        }

        // Step 2: Find the first missing positive integer
        for (i = 0; i < n; i++) {
            statusList.addNode(i, nums[i], i + 1, -1, nums); // Save state for each iteration
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        // If all positive integers from 1 to n are present, the missing integer is n + 1
        statusList.addNode(n, -1, -1, -1, nums); // Save the final state before return
        return n + 1;
    }


    public static void main(String[] args) {
        HelloWorld sol = new HelloWorld();
        int[] nums = {1,2,0};
        LinkedList statusList = new LinkedList();
        int missingPositive = sol.firstMissingPositive(nums, statusList);
        
        // Print the final output
        System.out.println("First Missing Positive: " + missingPositive);

        // To print the saved states
        statusList.printList();
    }
}


class Node {
    int index;
    int currentValue;
    int targetValue;
    int tempValue;
    int[] numsState;
    Node next;

    Node(int index, int currentValue, int targetValue, int tempValue, int[] numsState) {
        this.index = index;
        this.currentValue = currentValue;
        this.targetValue = targetValue;
        this.tempValue = tempValue;
        this.numsState = numsState.clone(); // Clone to save the state
        this.next = null;
    }
}

class LinkedList {
    Node head;
    Node tail;

    LinkedList() {
        this.head = null;
        this.tail = null;
    }

    void addNode(int index, int currentValue, int targetValue, int tempValue, int[] numsState) {
        Node newNode = new Node(index, currentValue, targetValue, tempValue, numsState);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    void printList() {
        Node current = head;
        while (current != null) {
            System.out.print("Index: " + current.index + ", nums[i]: " + current.currentValue + 
                ", nums[nums[i] - 1]: " + current.targetValue + ", temp: " + current.tempValue + 
                ", nums: [");
            for (int num : current.numsState) {
                System.out.print(num + " ");
            }
            System.out.println("]");
            current = current.next;
        }
    }
}

