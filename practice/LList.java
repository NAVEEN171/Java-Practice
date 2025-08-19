import java.util.LinkedList;

public class LList {
    public static Node reverseLinkedList(Node head) {
        if (head == null || head.next == null) {
            return head;

        }
        Node prev = null;
        Node curr = head;
        Node nextPtr = curr.next;
        while (curr != null) {
            curr.next = prev;
            prev = curr;
            curr = nextPtr;
            if (curr != null) {
                nextPtr = curr.next;
            }

        }
        return prev;

    }

    public static void printLL(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data + " -> ");
            temp = temp.next;
        }

    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node head = node1;
        Node node2 = new Node(2);
        node1.assignNext(node2);

        Node node3 = new Node(3);
        node2.assignNext(node3);
        Node node4 = new Node(5);
        node3.assignNext(node4);
        Node node5 = new Node(7);
        node4.assignNext(node5);
        printLL(node1);
        System.out.println("---------------");
        printLL(reverseLinkedList(node1));
    }

}

class Node<T> {
    T data;
    Node next;

    Node(T data, Node next) {
        this.data = data;
        this.next = next;
    }

    public void assignNext(Node next) {
        this.next = next;
    }

    Node(T data) {
        this.data = data;
        this.next = null;
    }

}
