    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        //之所以快慢指针都指向dummy而非head，是因为head也可能被删掉啊
        ListNode fast = dummy, slow = dummy;
        dummy.next = head;
        for(int i = 0; i <= n; i++){
            fast = fast.next;
        }
        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }