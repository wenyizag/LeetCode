    int ans = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        //虽然helper有返回值，但是不用非要赋给谁，可以当做void用
        helper(root);
        return ans;
    }
    //其实这道题的思路是这样的，一条path，如果经过一个节点，那么以它为根节点，经过它两个子节点，
    //要么它也是上层的子节点，且它两个子节点只能经过其中一个
    public int helper(TreeNode node){
        if(node == null) return 0;
        int left = helper(node.left);
        int right = helper(node.right);
        //设定一个ans值，比较每次以节点为根节点的情况
        ans = Math.max(ans, left+right);
        //该节点也是子节点
        return Math.max(left, right) + 1;
        
    }