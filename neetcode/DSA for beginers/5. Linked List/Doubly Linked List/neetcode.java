
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
