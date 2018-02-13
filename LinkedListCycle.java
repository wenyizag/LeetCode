package leetcode;

import java.util.LinkedList;

public class LinkedListCycle {
	
	//思路一、preorder
	public void flatten(TreeNode root) {
        if(root == null) return;
        LinkedList<TreeNode> list = new LinkedList<TreeNode>();
        preOrder(root, list);
        TreeNode cur = list.pop();
        while(!list.isEmpty()) {
        		cur.left = null;
        		TreeNode node = list.pop();
        		cur.right = node;
        		cur = node;
        }
    }

	public static void preOrder(TreeNode root, LinkedList list) {
		if(root == null) return;
		list.add(root);
		preOrder(root.left, list);
		preOrder(root.right, list);	
	}
	
	//思路二、recursive
	private TreeNode pre = null;
	public void flatten2(TreeNode root) {
        if(root == null) return;
        flatten(root.right);
        flatten(root.left);
        root.right = pre;
        root.left = null;
        pre = root;
    }

}
