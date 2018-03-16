package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class MaximumDepthOfBinaryTree {
	
	//recursion
	public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
	
	//iteration
	public int maxDepth2(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level = 0;
        
        while(!q.isEmpty()){
            level++;
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode cur = q.poll();
                if(cur.left != null) q.add(cur.left);
                if(cur.right != null) q.add(cur.right);
            }
        }
        return level;
    }
}
