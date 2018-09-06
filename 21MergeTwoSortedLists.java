    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //如果不介意改变原有的list，就不用开新node
        ListNode pre = new ListNode(0), dummy = pre;
        while(l1 != null && l2 != null){
            if(l1.val > l2.val){
                pre.next = l2;
                l2 = l2.next;
            }else{
                pre.next = l1;
                l1 = l1.next;
            }
            pre = pre.next;
        }
        if(l1 != null) pre.next = l1;
        if(l2 != null) pre.next = l2;
        return dummy.next;
    }

//递归解法，真的很棒
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }else{
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }