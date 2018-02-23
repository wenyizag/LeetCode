package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {

	//solution 1. recursion
	 public boolean isSymmetric(TreeNode root) {
		  return symmetric(root, root);
		 }
	 
	 public boolean symmetric(TreeNode node1, TreeNode node2) {
		  if(node1 == null && node2 == null) return true;
		  else if(node1 == null || node2 == null) return false;
		  else if(node1.val != node2.val) return false;
		  return symmetric(node1.left, node2.right) && symmetric(node1.right, node2.left);
	}
	
	//solution 2. irritation
	public boolean isSymmetric2(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		q.add(root);
		while(!q.isEmpty()) {
			TreeNode r1 = q.poll();
			TreeNode r2 = q.poll();
			if(r1==null && r2==null) continue;
			if(r1==null || r2==null) return false;
			if(r1.val != r2.val) return false;
			q.add(r1.left);
			q.add(r2.right);
			q.add(r1.right);
			q.add(r2.left);
		}	
		return true;
	}
}
