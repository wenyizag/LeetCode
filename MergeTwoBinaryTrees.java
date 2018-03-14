package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class MergeTwoBinaryTrees {
	
	//recursion
	   public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
	        if (t1 == null)
	            return t2;
	        if (t2 == null)
	            return t1;
	        t1.val += t2.val;
	        t1.left = mergeTrees(t1.left, t2.left);
	        t1.right = mergeTrees(t1.right, t2.right);
	        return t1;
	    }
	//iteration
	   public TreeNode mergeTrees2(TreeNode t1, TreeNode t2) {
			if(t1 == null) return t2;
	        Stack<TreeNode[]> s = new Stack<>();
	        s.push(new TreeNode[]{t1, t2});
	        
	        while(!s.isEmpty()){
	        		TreeNode[] cur = s.pop();
	        		if(cur[1] == null) continue;
	        		
	        		cur[0].val += cur[1].val;
	        		
	        		if(cur[0].left == null) {
	        			cur[0].left = cur[1].left;
	        		}else {
	        			s.push(new TreeNode[] {cur[0].left, cur[1].left});
	        		}
	        		
	        		if(cur[0].right == null) {
	        			cur[0].right = cur[1].right;
	        		}else {
	        			s.push(new TreeNode[] {cur[0].right, cur[1].right});
	        		}     			
	        }
	        return t1;
	    }
	
}
