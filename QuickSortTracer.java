/*
 * Needs  further modification to correctly handle the field 
 * Have to print the output in more described way 
 */
class Node {
    int[] array;
    int pivot;
    Node next;

    Node(int[] array, int pivot) {
        this.array = array.clone();
        this.pivot = pivot;
        this.next = null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Array: [");
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i < array.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("], Pivot: ").append(pivot);
        return sb.toString();
    }
}
class LinkedList {
    Node head;
    Node tail;

    void addNode(int[] array, int pivot) {
        Node newNode = new Node(array, pivot);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node current = head;
        while (current != null) {
            sb.append(current.toString()).append("\n");
            current = current.next;
        }
        return sb.toString();
    }
}

public class QuickSortTracer {

    public static void main(String[] args) {
        QuickSortTracer tracer = new QuickSortTracer();
        int[] array = {29, 10, 14, 37, 13, 2, 43, 17};
        LinkedList iterations = tracer.quickSort(array, 0, array.length - 1);
        System.out.println("Sorted Array: " + arrayToString(array));
        System.out.println("Iterations:\n" + iterations);
    }

    public LinkedList quickSort(int[] array, int low, int high) {
        LinkedList trace = new LinkedList();
        if (low < high) {
            int pi = partition(array, low, high);
            trace.addNode(array, pi);
            LinkedList leftTrace = quickSort(array, low, pi - 1);
            LinkedList rightTrace = quickSort(array, pi + 1, high);
            trace.tail.next = leftTrace.head;
            leftTrace.tail.next = rightTrace.head;
            trace.tail = rightTrace.tail;
        }
        return trace;
    }

    private int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }

    private static String arrayToString(int[] array) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i < array.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
