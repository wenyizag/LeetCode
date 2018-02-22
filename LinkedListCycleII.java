package leetcode;

public class LinkedListCycleII {
	public static ListNode detectCycle(ListNode head) {
		 ListNode fast = head;
		 ListNode slow = head;
		 //detect
		 while(fast!= null && fast.next!= null) {
			 fast = fast.next.next;
			 slow = slow.next;
			 if(slow == fast) {
				 //cycle
				 slow = head;
				 while(fast != slow) {
					 fast = fast.next;
					 slow = slow.next;
				 }
				 return slow;
			 }
		 }		 
		 return null;	        
	 }
}
