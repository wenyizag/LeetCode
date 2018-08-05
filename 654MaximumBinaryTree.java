public TreeNode constructMaximumBinaryTree(int[] nums) {
    TreeNode root = helper(nums, 0, nums.length-1);
    return root;
}

public TreeNode helper(int[] nums, int left, int right) {
	if(left > right) return null;
	
	int max = nums[left], index = left;
    for(int i = left+1; i <= right; i++) {
    		if(nums[i] > max) {
    			max = nums[i];
    			index = i;
    		}
    }
    
    TreeNode node = new TreeNode(max);
    //System.out.println(node.val);

    node.left = helper(nums, left, index-1);
    node.right = helper(nums, index+1, right);
    return node;
}