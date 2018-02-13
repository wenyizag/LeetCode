package leetcode;

import java.util.HashSet;
import java.util.LinkedList;

public class BinaryTreeVerticalOrderTraversal {
	
	//思路一、HashMap
	public boolean hasCycle(ListNode head) {
        HashSet<ListNode> map = new HashSet();
        while(head != null) {
        		if(map.contains(head)) return true;
        		else map.add(head);
        		head = head.next;
        }
        return false;
    }
	
	//思路二、双指针法
	public boolean hasCycle2(ListNode head) {
		if(head == null) return false;	
		ListNode first = head;
		ListNode second = head.next;		
		while(first != second) {
			if(second == null || second.next == null) return false;
			else {
				second = second.next.next;
				first = first.next;
			}			
		}		
		return true;
	}

}
