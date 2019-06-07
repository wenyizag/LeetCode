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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int len1 = getLength(l1);
        int len2 = getLength(l2);
        ListNode head = helper(l1, len1, l2, len2);
        if(head.val >= 10) {
            ListNode newHead = new ListNode(1);
            newHead.next = head;
            head.val -= 10;
            return newHead;
        }
        return head;
    }
    
    public int getLength(ListNode list) {
        if(list == null) return 0;
        int len = 1;
        while(list.next != null) {len++; list = list.next;}
        return len;
    }
    
    public ListNode helper(ListNode l1, int len1, ListNode l2, int len2) {
        if(len1 == 1 && len2 == 1) {
            return new ListNode(l1.val + l2.val);
        }
        ListNode cur = null, next = null;
        if(len1 > len2) {
            cur = l1;
            next = helper(l1.next, len1-1, l2, len2);
        }else if(len1 < len2) {
            cur = l2;
            next = helper(l1, len1, l2.next, len2-1);
        }else {
            cur = new ListNode(l1.val + l2.val);
            next = helper(l1.next, len1-1, l2.next, len2-1);
        }
        cur.next = next;
        if(next.val >= 10) {
            cur.val += 1;
            next.val -= 10;
        }
        return cur;
    }
