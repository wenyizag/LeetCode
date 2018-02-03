package leetcode;

public class AddTwoNumbers {
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(0);
		ListNode curNode = head;
		int carry = 0;
		while(l1 != null || l2 != null) {
			int cur = carry;
			cur += (l1!=null)? l1.val: 0;
			cur += (l2!=null)? l2.val: 0;
			carry = cur / 2;
			ListNode node = new ListNode(cur%2);
			curNode.next = node;
			curNode = node;
			l1 = (l1!=null)? l1.next : null;
			l2 = (l2!=null)? l2.next : null;
		}
		if(carry!=0) {
			curNode.next = new ListNode(carry);
		}
		return head.next;       
    }
}
