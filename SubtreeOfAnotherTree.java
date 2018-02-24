package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class SubtreeOfAnotherTree {
	
	//recursion
	public boolean isSubtree(TreeNode s, TreeNode t) {
		return traverse(s, t);
	 }
	 public boolean equals(TreeNode s, TreeNode t) {
		 if(s == null && t == null) return true;
		 if(s == null || t== null) return false;
		 return s.val == t.val && equals(s.right, t.right) && equals(s.left, t.left);
	 } 
	 public boolean traverse(TreeNode s, TreeNode t) {
		 return s != null && (equals(s, t) || traverse(s.left, t) || traverse(s.right, t));
	 }
	 
	 //preOrder + string
	 public boolean isSubtree2(TreeNode s, TreeNode t) {
		 String ss = preOrder(s);
		 String ts = preOrder(t);
		 return ss.contains(ts);
	 }
	 
	 public String preOrder(TreeNode node) {
		 if(node == null) {
			 return "null";
		 }
		 return "#" + node.val + preOrder(node.left) + preOrder(node.right);
	 }

     
	 
	  

}
