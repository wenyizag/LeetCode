public ListNode sortList(ListNode head) {
		if(head == null || head.next == null) return head;
		
        ListNode fast = head;
        ListNode slow = head;
        ListNode medium = null;
        
        while(fast != null && fast.next != null) {
        		fast = fast.next.next;
        		medium = slow;
        		slow = slow.next;	
        }
        medium.next = null;
        
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
        
        return merge(l1, l2);   
    }
	
	public ListNode merge(ListNode l1, ListNode l2) {
		ListNode l = new ListNode(0), p = l;
		
		while(l1 != null && l2 != null) {
			if(l1.val > l2.val) {
				p.next = l2;
				p = p.next;
				l2 = l2.next;
			}else {
				p.next = l1;
				p = p.next;
				l1 = l1.next;
			}
		}
		if(l1 != null) p.next = l1;
		if(l2 != null) p.next = l2;
		
		return l.next;
	}