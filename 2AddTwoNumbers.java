    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //创造了两个点用于定位，一个是固定的dummy，一个是遍历用的node
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;
        ListNode p1 = l1, p2 = l2;
        
        int sum = 0, carry = 0;
        while(p1 != null || p2 != null){
            sum = carry;
            if(p1 != null){
                sum += p1.val;
                p1 = p1.next;
            }
            if(p2 != null){
                sum += p2.val;
                p2 = p2.next;
            }
            carry = sum / 10;
            sum = sum % 10;
            ListNode cur = new ListNode((sum));
            node.next = cur;
            node = cur;
        }
        
        if(carry == 1){
            ListNode cur = new ListNode(1);
            node.next = cur;
        }
        return dummy.next;
    }