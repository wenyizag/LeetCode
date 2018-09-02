    int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        helper(root, false);
        return sum;
    }
    public void helper(TreeNode node, boolean left){
        if(node == null) return;
        helper(node.left, true);
        if(node.left == null && node.right == null && left) sum += node.val;
        helper(node.right, false);
    }

    //两种递归写法
        public int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;
        if(root == null) return 0;
        if(root.left != null && root.left.left == null && root.left.right == null) sum += root.left.val;
        return sum + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
            
    }