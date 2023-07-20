package Homework3;

public class Sortion {
    public static void main(String[] args) {
        Node A = new Node(4);
        Node B = new Node(2);
        Node C = new Node(5);
        Node D = new Node(1);
        Node E = new Node(3);
        A.next = B;
        B.next = C;
        C.next = D;
        D.next = E;

        Node current = A;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        current = sort(A);
        System.out.println();
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
    }


    static Node sort(Node root) {
        if (root == null) return null;
        boolean isSorted;
        do {
            Node current = root;
            Node previous = null;
            isSorted = false;
            while (current.next != null) {
                if (current.value > current.next.value) {
                    isSorted = true;
                    if (current.next.next != null) {
                        if (current == root) {
                            previous = current.next;
                            root = previous;
                        } else {
                            previous.next = current.next;
                            previous = previous.next;
                        }
                        current.next = current.next.next;
                        previous.next = current;
                    } else {
                        previous.next = current.next;
                        previous = previous.next;
                        previous.next = current;
                        current.next = null;
                    }
                } else {
                    previous = current;
                    current = current.next;
                }
            }
        } while (isSorted);
        return root;
    }


    static class Node {
        int value;
        Node next;

        Node() {
        }

        Node(int value) {
            this();
            this.value = value;
        }
    }
}
