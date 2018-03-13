package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal {
	//Iteration
	public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		if(root == null) return ans;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		Boolean level = true;
		while(!q.isEmpty()){
			int size = q.size();
			List<Integer> curList = new ArrayList<>();
			for(int i = 0; i < size; i++) {
				TreeNode curr = q.poll();
				if(level) {
					curList.add(curr.val);
				}else {
					curList.add(0, curr.val);
				}
				if(curr.left != null) q.add(curr.left);
				if(curr.right != null) q.add(curr.right);
				
			}
			ans.add(curList);
			level = level ? false : true;
		}
		return ans;
	}
	
	//Recursion
	public static List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
		List<List<Integer>> ans = new ArrayList<>();
		helper(root, ans, 0);
		return ans;		
	}
	public static void helper(TreeNode node, List<List<Integer>> ans, int level) {
		if(node == null) return;
		if(level >= ans.size()) {
			ans.add(new ArrayList<Integer>());
		}
		List<Integer> cur = ans.get(level);
		if(level%2 == 0) cur.add(node.val);
		else cur.add(0, node.val);
		
		helper(node.left, ans, level+1);
		helper(node.right, ans, level+1);
	}
}
