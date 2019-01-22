//solution 1
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1), pre = dummy;
        pre.next = head;
        while(pre.next != null) {
            if(pre.next.val == val) {
                pre.next = pre.next.next;
            }
            else pre = pre.next;
        }
        return dummy.next;
    }
}

//solution 2
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return null;
        head.next = removeElements(head.next, val);
        return (head.val == val) ? head.next : head;
    }
}