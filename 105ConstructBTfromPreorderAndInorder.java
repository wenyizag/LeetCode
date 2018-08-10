    //跟106一模一样，换汤不换药
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(inorder, 0, inorder.length-1, preorder, 0, inorder.length-1);
    }
    
    public TreeNode helper(int[] inorder, int is, int ie,
    		int[] preorder, int ps, int pe) {
		if(is > ie || ps > pe) return null;
		if(is == ie) return new TreeNode(inorder[is]);
		
    		TreeNode root = new TreeNode(preorder[ps]);
    		int index = is;
    		for( ; index <= ie; index++ ) {
    			if(inorder[index] == root.val)
    				break;
    		}
    		int leftsize = index-is;
    		TreeNode left = helper(inorder, is, index-1, preorder, ps+1, ps+leftsize);
    		TreeNode right = helper(inorder, index+1, ie, preorder, ps+leftsize+1, pe);
    		root.left = left;
    		root.right = right;
    		return root;
    }