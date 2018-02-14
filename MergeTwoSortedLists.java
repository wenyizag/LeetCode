package leetcode;

import java.util.HashSet;
import java.util.LinkedList;

public class MergeTwoSortedLists {
	//思路一、recursion
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1 == null) return l2;
		else if(l2 == null) return l1;
		
		if(l1.val < l2.val) {
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		}else {
			l2.next = mergeTwoLists(l1, l2.next);
			return l2;
		}
	}
}
