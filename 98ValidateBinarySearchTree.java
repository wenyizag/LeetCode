    public boolean isValidBST(TreeNode root) {
        //为啥用Long呢，因为它的test case里有用Integer.MIN_VALUE，导致用integer通不过
       return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public boolean helper(TreeNode node, long low, long high){
        if(node == null) return true;
        if(node.val <= low || node.val >= high) return false;
        return helper(node.left, low, node.val) && helper(node.right, node.val, high);
    }


//Solution 2
        public boolean isValidBST(TreeNode root) {
        //或者是中序遍历，利用BST的性质
        Stack<TreeNode> s = new Stack<>();
        TreeNode pre = null;
        while(!s.isEmpty() || root!=null){
            while(root!=null){
                s.push(root);
                root = root.left;
            }
            root = s.pop();
            if(pre != null && pre.val >= root.val) return false;
            pre = root;
            root = root.right;
        }
        return true;
    }