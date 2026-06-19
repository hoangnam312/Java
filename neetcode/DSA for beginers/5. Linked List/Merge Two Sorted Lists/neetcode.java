class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(0);
        ListNode current = head;  
        
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                current.next = new ListNode(list1.val);
                current = current.next;
                list1 = list1.next;
            } else {
                current.next = new ListNode(list2.val);
                current = current.next;
                list2 = list2.next;
            }
        }

        // end: list 1 || list 2 = null
        if (list1 == null) current.next = list2;
        if (list2 == null) current.next = list1;

        return head.next;
    }
}