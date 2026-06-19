// Merge Two Sorted Linked Lists
// You are given the heads of two sorted linked lists list1 and list2.
// Merge the two lists into one sorted linked list and return the head of the new sorted linked list.
// The new list should be made up of nodes from list1 and list2.

// Example 1:
// Input: list1 = [1,2,4], list2 = [1,3,5]
// Output: [1,1,2,3,4,5]

// Example 2:
// Input: list1 = [], list2 = [1,2]
// Output: [1,2]

// Example 3:
// Input: list1 = [], list2 = []
// Output: []

// Constraints:
// 0 <= The length of the each list <= 100.
// -100 <= Node.val <= 100

class Main {
    public static void main(String[] args) {

        // list1: 1 -> 2 -> 4
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        // list2: 1 -> 3 -> 4
        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        System.out.print("List 1: ");
        printList(list1);

        System.out.print("List 2: ");
        printList(list2);

        ListNode result = mergeTwoLists(list1, list2);
        // case empty
        // ListNode result = mergeTwoLists(null, null);

        System.out.print("Merged: ");
        printList(result);
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        // end: list 1 || list 2 = null
        if (list1 == null)
            current.next = list2;
        else
            current.next = list1;

        return dummy.next;
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