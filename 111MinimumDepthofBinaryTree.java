    int ans = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        helper(root, 1);
        return ans;
    }
    
    //其实我的思路是，当root是叶节点的时候更新一下全局变量ans
    public void helper(TreeNode root, int depth) {
        if(root == null) return;
        if(root.left == null && root.right == null) ans = Math.min(ans, depth);
        helper(root.left, depth+1);
        helper(root.right, depth+1);
    }

    //Solution 2
        public int minDepth(TreeNode root) {
        if(root == null) return 0;
        //左为空，左path不成立，继续往右走
        if(root.left == null) return minDepth(root.right) + 1;
        
        if(root.right == null) return minDepth(root.left) + 1;
        //两个都不为空，选短的那个
        return Math.min(minDepth(root.left), minDepth(root.right))+1;
    }