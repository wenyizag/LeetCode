    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length-1);
    }
    
    public TreeNode helper(int[] nums, int s, int e){
        if(s > e) return null;
        int mid = s + (e-s)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(nums, s, mid-1);
        node.right = helper(nums, mid+1, e);
        return node;
    }