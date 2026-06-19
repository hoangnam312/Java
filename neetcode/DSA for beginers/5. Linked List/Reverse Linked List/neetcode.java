class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode next = (head != null ? head.next : null);
        ListNode current = head;
        
        while (current != null) {
            current.next = prev;

            // update for next loop
            prev = current;
            current = next;
            next = (next != null ? next.next : null);
        }

        return prev;
    }
}