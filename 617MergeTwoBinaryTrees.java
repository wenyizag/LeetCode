    //自己写的，代码需要factory一下
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null || t2 == null){
            t1 = (t2 != null) ? t2 : t1;
            return t1;
        }
        helper(t1, t2);
        return t1;
    }
    public void helper(TreeNode t1, TreeNode t2){
        t1.val += t2.val;
        if(t1.left != null && t2.left != null) helper(t1.left, t2.left);
        else if(t1.left == null) t1.left = t2.left;
        if(t1.right != null && t2.right != null) helper(t1.right, t2.right);
        else if(t1.right == null) t1.right = t2.right;       
    }

        //优化写法
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null) return null;
        else if(t1 == null) return t2;
        else if(t2 == null) return t1;
        TreeNode cur = new TreeNode(t1.val + t2.val);
        cur.left = mergeTrees(t1.left, t2.left);
        cur.right = mergeTrees(t1.right, t2.right);
        return cur;
    }