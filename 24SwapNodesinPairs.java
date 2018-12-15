//solution 1. recursion
    // 1 -> 2 -> 3
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode node = head.next, next = head.next.next;
        node.next = head;
        head.next = swapPairs(next);
        return node;  
    }


//solution 2. iteration
    // 1 -> 2 -> 3 -> 4
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0), cur = head, pre = dummy;
        
        while(cur != null && cur.next != null){
            ListNode second = cur.next, third = second.next;
            pre.next = second;
            second.next = cur;
            cur.next = third;
            pre = cur;
            cur = third;

        }
        return dummy.next; 
    }