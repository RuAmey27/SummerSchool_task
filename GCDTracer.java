/*This progam is specifically used to demonstrate the loop states in each iteration while the execution of the gcd function */

class Node {
    int a, b, temp;         // No of variable used in loop as the State variable
    Node next;              //pointer to maintain the link 

    Node(int a, int b, int temp) {
        this.a = a;
        this.b = b;
        this.temp = temp;
        this.next = null;
    }

    @Override
    public String toString() {
        return "a = " + a + ", b = " + b + ", temp = " + temp;
    }
}                          // Linked List implementation 

class LinkedList            // to add fuctionality of Linking the Nodes 
{
    Node head;
    Node tail;

    void addNode(int a, int b, int temp) {
        Node newNode = new Node(a, b, temp);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    @Override               //This implemenation is specifically used to return the output in the form of string 
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

public class GCDTracer {

    public static void main(String[] args) {
        GCDTracer tracer = new GCDTracer();
        int a = 56, b = 98;
        LinkedList iterations = tracer.gcd(a, b);
        System.out.println("GCD of " + a + " and " + b + " is: " + iterations.tail.a);
        System.out.println("Iterations:\n" + iterations);
        LinkedList iterations1 = tracer.gcd1(a, b);
        System.out.println("GCD of " + a + " and " + b + " is: " + iterations1.tail.a);
        System.out.println("Iterations:\n" + iterations1);
    }

    public LinkedList gcd(int a, int b) // This is how and and what parameter we are tracing the opeartion 
    {
        LinkedList trace = new LinkedList();
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
            trace.addNode(a, b, temp);
        }
        return trace;  // returning head pointer to print the states 
    }
    public LinkedList gcd1(int a, int b) // This is how and and what parameter we are tracing the opeartion 
    {
        LinkedList trace = new LinkedList();
        while (b != 0) {
            int temp = b;
            trace.addNode(a, b, temp);
            b = a % b;
            a = temp;
            //trace.addNode(a, b, temp);
        }
        return trace;  // returning head pointer to print the states 
    }
}
