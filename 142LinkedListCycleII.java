    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;

        //思路参考之前写的博客，懒得说了
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            
            //今天才发现ListNode可以直接比较啊。。。不用.val也可以啊
            if(fast == slow){
               slow = head;
                while(fast.val != slow.val){
                    slow = slow.next;
                    fast = fast.next;
                } 
                return fast;
            }
        }
        
        return null;  
    }