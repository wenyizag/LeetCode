    //用了两个栈来存节点，这样pop出来的时候就是逆序
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> s1 = new Stack<>();
        Stack<ListNode> s2 = new Stack<>();
        while(l1 != null || l2 != null){
            if(l1 != null)  {s1.push(l1); l1 = l1.next;}
            if(l2 != null)  {s2.push(l2); l2 = l2.next; }
        }
        int sum = 0,  carry = 0;
        ListNode node = null;
        while(!s1.isEmpty() || !s2.isEmpty()){
            sum = carry;
            
            if(!s1.isEmpty()) {ListNode cur = s1.pop(); sum += cur.val;}
            if(!s2.isEmpty()) {ListNode cur = s2.pop(); sum += cur.val;}
            carry = sum / 10;
            sum = sum % 10;
            //需要注意的是节点添加的顺序，逆着添加
            ListNode cur = new ListNode(sum);
            cur.next = node;
            node = cur;
        }
        if(carry == 1){
            ListNode cur = new ListNode(1);
            cur.next = node;
            node = cur;
        }
        return node;
    }

    //还有个recursion的解法，没有心思看了