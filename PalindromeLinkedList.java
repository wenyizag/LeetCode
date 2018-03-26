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
	}return a==0 && b==0;
	    }
}
