// Reverse Linked List
// Given the beginning of a singly linked list head, reverse the list, and return the new beginning of the list.

// Example 1:
// Input: head = [0,1,2,3]
// Output: [3,2,1,0]

// Example 2:
// Input: head = []
// Output: []

// Constraints:
// 0 <= The length of the list <= 1000.
// -1000 <= Node.val <= 1000


class Main {
    public static void main(String[] args) {
        // Tạo linked list: 1 -> 2 -> 3 -> 4 -> 5
        // ListNode head = null;
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.print("Original: ");
        printList(head);

        ListNode reversed = reverseList(head);

        System.out.print("Reversed: ");
        printList(reversed);
    }

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode next = (head != null ? head.next : null);
        ListNode current = head;
        
        while (current != null) {
            System.out.println("------------- ");
            System.out.println("current: " + (current != null ? current.val : "null"));
            System.out.println("next: " + (next != null ? next.val : "null"));
            System.out.println("prev: " + (prev != null ? prev.val : "null"));
            
            current.next = prev;

            // update for next loop
            prev = current;
            current = next;
            next = (next != null ? next.next : null);

            printList(prev);
            printList(current);
        }

        return prev;
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

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}