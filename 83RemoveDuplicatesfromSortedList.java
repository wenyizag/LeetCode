    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return head;
        ListNode dummy = head, cur = head;
        //只需要一个指针就够了，不过判断的时候需要判断下一位
        while(cur.next != null){
            if(cur.val == cur.next.val){
                cur.next = cur.next.next;
            }
            else{
                cur = cur.next;
            }
        }
        return dummy;
    }