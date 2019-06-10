package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class InvertBinaryTree {
	
	//recursion
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
	
	//iteration
	 public TreeNode invertTree2(TreeNode root) {
	        if(root == null) return null;
	        Queue<TreeNode> q = new LinkedList<>();
	        q.add(root);
	        
	        while(!q.isEmpty()){
	            TreeNode cur =  q.poll();
	            TreeNode tmp = cur.left;
	            cur.left = cur.right;
	            cur.right = tmp;
	            if(cur.left != null) q.add(cur.left);
	            if(cur.right != null) q.add(cur.right);
	        }
	        
	        return root;
	    }
}
