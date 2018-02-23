package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class ClosestBinarySearchTreeValue {
	//iteration
	  public static int closestValue(TreeNode root, double target) {
		  int ans = root.val;
		  double min = Math.abs(ans - target);
		  while(root != null) {
			  if(Math.abs(root.val - target) < min) {
				  min = Math.abs(root.val - target);
				  ans = root.val;
			  }
			  root = (root.val > target) ? root.left: root.right;			  
		  }
		  return ans;
	  }
	  
	 //recursion
	  public static int closestValue2(TreeNode root, double target) {
		  int a = root.val;
		  TreeNode kid = (a > target) ? root.left : root.right;
		  if(kid == null) return a;
		  int b = closestValue2(kid, target);
		  return (Math.abs(a-target) < Math.abs(b-target))?a : b;
	  }
}
