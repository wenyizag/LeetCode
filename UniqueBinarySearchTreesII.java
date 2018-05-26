package leetcode;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesII {
	public static List<TreeNode> generateTrees(int n) {
		if(n == 0) return new ArrayList<TreeNode>();
        return generate(1, n);
    }
	
	public static List<TreeNode> generate(int start, int end){
		List<TreeNode> result = new ArrayList<TreeNode>();
		if(start > end) {
			result.add(null);
			return result;
		}
		for(int k = start; k <= end; k++) {
			List<TreeNode> left = generate(start, k-1);
			List<TreeNode> right = generate(k+1, end);
			
			for(TreeNode i : left) {
				for(TreeNode j : right) {
					TreeNode node = new TreeNode(k);
					node.left = i;
					node.right = j;
					result.add(node);
				}
			}
			
		}
		return result;
	}
}
