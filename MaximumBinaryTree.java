package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class MaximumBinaryTree {
	  
	 //recursion
 public TreeNode constructMaximumBinaryTree(int[] nums) {
 		return construct(nums, 0, nums.length);     
 }
 
 public TreeNode construct(int[] nums, int s, int e) {
 	    if(s == e) return null;
        int index = findIndex(nums, s, e);
		TreeNode root = new TreeNode(nums[index]);
		root.left = construct(nums, s, index);
		root.right = construct(nums, index+1, e);
		return root;
 }
 
 public int findIndex(int[] nums, int s, int e) {
 		int max = nums[s];
 		int index = s;
 		for(int i = s+1; i < e; i++) {
 			if(nums[i] > max) {
 				max= nums[i];
 				index = i;
 			}
 		}
 		return index;
 }
	  
	 
	  

}
