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
		 String ss = preOrder(s, true);
		 String ts = preOrder(t, true);
		 return ss.contains(ts);
	 }
	 
	 public String preOrder(TreeNode node, boolean left) {
		 if(node == null) {
			 if(left) return "lnull";
			 else return "rnull";
		 }
		 return "#" + node.val + preOrder(node.left, true) + preOrder(node.right, false);
	 }

     
	 
	  

}
