class Main {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {

        // Test case: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Before reverse:");
        printList(head);

        ListNode reversed = reverseList(head);

        System.out.println("After reverse:");
        printList(reversed);
    }

    public static ListNode swap(ListNode prev, ListNode current) {
        ListNode next = current.next;
        current.next = prev;
        if (next.next == null) {
            return current;
        }

        return swap(current, next);
    }

    public static ListNode reverseList(ListNode head) {
        ListNode reverseHead = swap(head, head.next);
        return reverseHead;
    }

    public static void printList(ListNode head) {
        ListNode current = head;

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