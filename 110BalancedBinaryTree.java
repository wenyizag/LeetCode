    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        int left = helper(root.left);
        int right = helper(root.right);
        //注意要检查三种，1.左右子树的最大深度 2.左子树 3.右子树
        return Math.abs(left-right) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }
    //返回一个node的深度
    public int helper(TreeNode node) {
    		if(node == null) return 0;
            //一个node的深度是它的左右子树较深的那一个+1
    		return Math.max(helper(node.left), helper(node.right)) + 1;
    }