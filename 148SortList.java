    public ListNode sortList(ListNode head) {
        //就是一个merge sort
        if(head == null || head.next == null) return head;
        //我擦我才发现这个快慢指针法，fast需要等于head.next啊。。。或者得有个dummy; dummy.next = head, slow = dummy, fast = dummy
        ListNode fast = head.next, slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        // System.out.println("slow "+slow.val);
        ListNode mid = slow.next;
        slow.next = null;
        return merge(sortList(head), sortList(mid));
    }
    
    public ListNode merge(ListNode l1, ListNode l2){
        
        ListNode dummy = new ListNode(0), tail = dummy;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                tail.next = l1;
                l1 = l1.next;
            }else{
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        if(l1 != null) tail.next = l1;
        if(l2 != null) tail.next = l2;
        return dummy.next;  
    }