    public boolean isPalindrome(ListNode head) {
        // E.g.
        // 1->2->3->4->3->2->1->null
        // fast = null
        // slow = 4
        // stack = 1,2,3
        
         // E.g.
        // 1->2->3->3->2->1->null
        // fast = 1
        // slow = 3
        // stack = 1,2,3
        Stack<ListNode> s = new Stack<>();
        ListNode fast = head, slow = head;
        while(fast != null && fast.next != null){
            s.push(slow);
            slow = slow.next;
            fast = fast.next.next;
        }
        //List是奇数长，奇数长的时候也只有 (n-1)/2的部分入栈了，最中间那个奇数没有入栈
        if(fast != null) {
           slow = slow.next;
        }
        
        while(!s.isEmpty()){
            if(slow.val != s.pop().val) return false;
            slow = slow.next;
        }
        return true;
    }


    //不用stack，用reverse
        public boolean isPalindrome(ListNode head) {

        ListNode fast = head, slow = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //List是奇数长
        if(fast != null) {
           slow = slow.next;
        }
        //reverse一下后半部分
        ListNode r_second = reverse(slow);
        
        while(r_second != null){
            if(r_second.val != head.val) return false;
            head = head.next;
            r_second = r_second.next;
        }
        return true;
    }
    
    //这个reverse，一次只用翻转一条边
    public ListNode reverse(ListNode head){
        ListNode pre = null, next = null;
        while(head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }