package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class BinaryTreeLevelOrderTraversal {
	
	//BFS
	 public List<List<Integer>> levelOrder(TreeNode root) {
		 Queue<TreeNode> q = new LinkedList<>();
		 List<List<Integer>> ans = new ArrayList<List<Integer>>();
		 if(root == null) return ans;
		 q.add(root);
		 
		 while(!q.isEmpty()) {
			 int size = q.size();
			 ArrayList<Integer> list = new ArrayList<>();
			 for(int i = 0; i < size; i++) {
				 TreeNode cur = q.poll();
				 list.add(cur.val);
				 if(cur.left != null) q.add(cur.left);
				 if(cur.right != null) q.add(cur.right);
			 }
			 ans.add(list);
		}
		return ans;	 
	 }
	 
	 //recursion	 
	 public List<List<Integer>> levelOrder2(TreeNode root) {
		 List<List<Integer>> ans = new ArrayList<List<Integer>>();	
		 levelHelper(root, 0, ans);
		 return ans;
	 }
	 
	 public void levelHelper(TreeNode node, int height, List<List<Integer>> ans) {
		 if(node == null) return;
		 if(height >= ans.size()) {
			 ans.add(new ArrayList<Integer>());
		 }
		 ans.get(height).add(node.val);
		 levelHelper(node.left, height+1, ans);
		 levelHelper(node.right, height+1, ans);
	 }

     
	 
	  

}
