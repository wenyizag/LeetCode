package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class SumRootToLeafNumbers {
	  
	 //recursion
	  public int sumNumbers(TreeNode root) { 
			return sumTree(root, 0);
	  }		
	  public int sumTree(TreeNode node, int pre) {
			if(node == null) return 0;
	        if(node.left == null && node.right == null) return pre*10 + node.val;
			return sumTree(node.left, pre*10 + node.val) + sumTree(node.right, pre*10 + node.val);
	  }
	  
	  //iteration 1
	  public int sumNumbers2(TreeNode root) { 
	        if(root == null) return 0;
			Queue<TreeNode> q = new LinkedList<>();
			Queue<Integer> level = new LinkedList<>();
			q.add(root);
			level.add(root.val);
			int sum = 0;
			while(!q.isEmpty()) {
				TreeNode cur = q.poll();
	            int curValue = level.poll();
				if(cur.left == null && cur.right == null)
					sum = sum + curValue;
				if(cur.left != null) {
					q.add(cur.left);
					level.add(curValue*10 + cur.left.val);
				}
				if(cur.right != null){
					q.add(cur.right);
					level.add(curValue*10 + cur.right.val);
				}						
			}
			return sum;
		}
	  
	  //iteration 2
	  public int sumNumbers3(TreeNode root) { 
	        if(root == null) return 0;
			Queue<TreeNode> q = new LinkedList<>();
			q.add(root);
			int sum = 0;
			while(!q.isEmpty()) {
				TreeNode cur = q.poll();
				if(cur.left == null && cur.right == null)
					sum = sum + cur.val;
				if(cur.left != null) {
					cur.left.val = cur.val*10 + cur.left.val;
	                q.add(cur.left);
				}
				if(cur.right != null){
					cur.right.val = cur.val*10 + cur.right.val;
	                q.add(cur.right);
				}						
			}
			return sum;
		}
}
