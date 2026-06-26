class Main {

    public static void main(String[] args) {

        // Test case:
        // [[1,2,4],[1,3,5],[3,6]]

        ListNode[] lists = new ListNode[3];

        lists[0] = buildList(new int[] { 1, 2, 4 });
        lists[1] = buildList(new int[] { 1, 3, 5 });
        lists[2] = buildList(new int[] { 3, 6 });

        ListNode result = Solution.mergeKLists(lists);

        printList(result);
    }

    // Tạo Linked List từ mảng
    private static ListNode buildList(int[] arr) {
        if (arr.length == 0)
            return null;

        ListNode head = new ListNode(arr[0]);
        ListNode current = head;

        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }

        return head;
    }

    // In Linked List
    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);

            if (head.next != null) {
                System.out.print(" -> ");
            }

            head = head.next;
        }

        System.out.println();
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public divine(ListNode[] arr) {
        if (arr.length > 2) {
            // chia
        }
        if (arr.length == 2) {
            merge(arr[0], arr[1]);
        }

        if (arr.length == 1) return arr[0];
    }

    public ListNode merge(ListNode[] left, ListNode[] right) {
        
    }

    public static ListNode mergeKLists(ListNode[] lists) {

        // TODO: Viết thuật toán tại đây

        return null;
    }

}