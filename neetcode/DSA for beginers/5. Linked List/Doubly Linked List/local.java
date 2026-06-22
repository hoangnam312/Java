// Design Linked List
// Design your implementation of the linked list. You can choose to use a singly or doubly linked list.
// A node in a singly linked list should have two attributes: val and next.val is the value of the current node, and next is a pointer/reference to the next node.
// If you want to use the doubly linked list, you will need one more attribute prev to indicate the previous node in the linked list. Assume all nodes in the linked list are 0-indexed.

// Implement the MyLinkedList class:
// MyLinkedList() Initializes the MyLinkedList object.
// int get(int index) Get the value of the index-th node in the linked list. If the index is invalid, return -1.
// void addAtHead(int val) Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
// void addAtTail(int val) Append a node of value val as the last element of the linked list.
// void addAtIndex(int index, int val) Add a node of value val before the index-th node in the linked list. If index equals the length of the linked list, the node will be appended to the end of the linked list. If index is greater than the length, the node will not be inserted.
// void deleteAtIndex(int index) Delete the index-th node in the linked list, if the index is valid.

// Example 1:
// Input:
// ["MyLinkedList", "addAtHead", "addAtTail", "addAtIndex", "get", "deleteAtIndex", "get"]
// [[], [1], [3], [1, 2], [1], [1], [1]]
// Output:
// [null, null, null, null, 2, null, 3]

// Explanation:
// MyLinkedList myLinkedList = new MyLinkedList();
// myLinkedList.addAtHead(1);
// myLinkedList.addAtTail(3);
// myLinkedList.addAtIndex(1, 2);    // linked list becomes 1->2->3
// myLinkedList.get(1);              // return 2
// myLinkedList.deleteAtIndex(1);    // now the linked list is 1->3
// myLinkedList.get(1);              // return 3

// Constraints:
// 0 <= index, val <= 1000
// Please do not use the built-in LinkedList library.
// At most 2000 calls will be made to get, addAtHead, addAtTail, addAtIndex and deleteAtIndex.

class Main {

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();

        System.out.println("=== Test 1 ===");

        list.addAtHead(1);
        list.print();

        list.addAtTail(3);
        list.print();

        list.addAtIndex(1, 2);
        list.print();

        System.out.println("get(1) = " + list.get(1)); // 2

        list.deleteAtIndex(1);
        list.print();

        System.out.println("get(1) = " + list.get(1)); // 3

        System.out.println("\n=== Test 2 ===");

        MyLinkedList list2 = new MyLinkedList();

        list2.addAtHead(10);
        list2.addAtHead(20);
        list2.addAtHead(30);

        list2.print(); // 30 -> 20 -> 10

        list2.deleteAtIndex(0);

        list2.print(); // 20 -> 10

        System.out.println("\n=== Test 3 ===");

        MyLinkedList list3 = new MyLinkedList();

        list3.addAtIndex(1, 100); // invalid
        list3.print();

        System.out.println(list3.get(0)); // -1

        list3.deleteAtIndex(0); // invalid
        list3.print();
    }
}

class MyLinkedList {

    private class Node {
        int val;
        Node next;
        Node prev;

        Node(int val) {
            this.val = val;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public int get(int index) {
        if (index < 0 || index >= size)
            return -1;
        Node value = head;
        for (int i = 0; i < index; i++) {
            value = value.next;
        }
        return value.val;
    }

    public void addFromEmpty(Node value) {
        head = value;
        tail = value;
        size = 1;
    }

    public void addAtHead(int val) {
        Node value = new Node(val);
        if (size == 0) {
            addFromEmpty(value);
            return;
        }
        value.next = head;
        head.prev = value;
        head = value;
        size++;
    }

    public void addAtTail(int val) {
        Node value = new Node(val);
        if (size == 0) {
            addFromEmpty(value);
            return;
        }
        tail.next = value;
        value.prev = tail;
        tail = value;
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index > size)
            return;
        if (index == 0) {
            addAtHead(val);
            return;
        }
        if (index == size) {
            addAtTail(val);
            return;
        }

        Node value = new Node(val);
        Node pointer = head;
        for (int i = 0; i < index; i++) {
            pointer = pointer.next;
        }
        value.next = pointer;
        value.prev = pointer.prev;
        pointer.prev.next = value;
        pointer.prev = value;
        size++;

    }

    public void deleteAtIndex(int index) {
        if (index >= size)
            return;

        if (index == 0) {
            head = head.next;
            head.prev = null;
            size -= 1;
            return;
        }
        if (index == size - 1) {
            tail = tail.prev;
            tail.next = null;
            size -= 1;
            return;
        }
        Node value = head;
        for (int i = 0; i < index; i++) {
            value = value.next;
        }
        value.prev.next = value.next;
        value.next.prev = value.prev;
        size -= 1;
    }

    // Helper method để debug
    public void print() {
        Node current = head;

        while (current != null) {
            System.out.print(current.val);

            if (current.next != null) {
                System.out.print(" -> ");
            }

            current = current.next;
        }

        System.out.println();
    }
}
