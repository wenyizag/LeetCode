package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class TwoSumIVInputIsABST {
	
	 //recursion
	 public boolean findTarget(TreeNode root, int k) {
		   Set<Integer> set = new HashSet<>();
		   return twoSum(root, k, set);
     }
		 
     public boolean twoSum(TreeNode node, int k, Set<Integer> set) {
			 if(node == null) return false;
			 if(set.contains(k - node.val)) return true;
			 if(!set.contains(node.val)) set.add(node.val);
			 return twoSum(node.left, k, set) || twoSum(node.right, k , set);
	 }
     
     //iteration
     public boolean findTarget2(TreeNode root, int k) {
		 Set<Integer> set = new HashSet<>();
		 Queue<TreeNode> q = new LinkedList<>();
		 q.add(root);
		 while(!q.isEmpty()) {
			 TreeNode cur = q.remove();
			 if(cur != null) {			 
				 if(set.contains(k - cur.val)) return true;
				 set.add(cur.val);
				 q.add(cur.left);
				 q.add(cur.right);
			 }
		 }		 
		 return false;
	 }
     
     //inOrder
     public boolean findTarget3(TreeNode root, int k) {
 		ArrayList<Integer> list = new ArrayList<>();
 		inOrder(root, list);
 		int s = 0, e = list.size()-1;
 		while(s < e) {
 			int cur = list.get(s) + list.get(e);
 			if(cur == k) return true;
 			else if(cur < k) s++;
 			else e--;
 		}
 		return false;
 }
 
     public void inOrder(TreeNode node, ArrayList<Integer> list) {
 		if(node == null) return;
 		inOrder(node.left, list);
 		list.add(node.val);
 		inOrder(node.right, list);
 }
     
	 
	  

}
