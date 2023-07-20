package Homework3;

public class Reversion {
    public static void main(String[] args) {
        Node A = new Node(1);
        Node B = new Node(2);
        Node C = new Node(3);
        Node D = new Node(4);
        A.next = B;
        B.next = C;
        C.next = D;        Node F = new Node(8);
        Node G = new Node(6);
        Node H = new Node(7);
        Node root = A;
        System.out.println(root.next.value);
        root = revert(A);

        System.out.println(root.next.value);
    }


    static Node revert(Node root) {
        Node currentNode = root;
        Node nextNode = new Node();
        Node previousNode = null;
        while (currentNode != null) {
            nextNode = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
        }
        return previousNode;
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
