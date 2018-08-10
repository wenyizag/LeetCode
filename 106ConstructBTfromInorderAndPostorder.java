    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder, 0, inorder.length-1, postorder, 0, inorder.length-1);
    }
    
    public TreeNode helper(int[] inorder, int is, int ie,
    	int[] postorder, int ps, int pe) {
		if(is > ie || ps > ie) return null;
        //小小的优化一下，is == ie的时候也必然 ps==pe，所以只用只用判断一个，它们返回的值是一样的
        if(is == ie) return new TreeNode(inorder[is]);
		
    		TreeNode root = new TreeNode(postorder[pe]);
    		int index = is;
    		for( ; index <= ie; index++ ) {
    			if(inorder[index] == root.val)
    				break;
    		}
    		int leftsize = index-is;
    		TreeNode left = helper(inorder, is, index-1, postorder, ps, ps+leftsize-1);
    		TreeNode right = helper(inorder, index+1, ie, postorder, ps+leftsize, pe-1);
    		root.left = left;
    		root.right = right;
    		return root;
    }