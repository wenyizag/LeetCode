package leetcode;

public class PalindromeLinkedList {
	public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null) {
        		fast = fast.next.next;
        		slow = slow.next;
        }
       if(fast != null){
           slow = slow.next;
       }
        fast = head;
        slow = reverse(slow);
        while(slow != null) {
        		if(slow.val != fast.val) return false;
        		slow = slow.next;
        		fast = fast.next;
        }
        return true; 
        
    }
	// 1 -> 2 -> 3
	// 1
	public ListNode reverse(ListNode node) {
		ListNode pre = null;
		while(node != null) {
			ListNode next = node.next;
			node.next = pre;
			pre = node;
			node = next;			
		}
		return pre;
	    }
}

//solution 2. stack
    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;
        ListNode fast = head, slow = head;
        Stack<ListNode> s = new Stack<>();
        while(fast != null && fast.next != null){
            s.push(slow);
            fast = fast.next.next;
            slow = slow.next;
        }
        if(fast != null){
            slow = slow.next;
        }

        while(slow != null){
            if(s.pop().val != slow.val) return false;
            slow = slow.next;
        }
        return true;
    }
