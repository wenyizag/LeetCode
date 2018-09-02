//懒得多写了，看别人的博文解释吧：http://bangbingsyb.blogspot.com/2014/11/leetcode-flatten-binary-tree-to-linked.html
    public void flatten(TreeNode root) {
        if(root == null) return;
        flatten(root.left);
        flatten(root.right);
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = null;
        while(root.right != null){
            root = root.right;
        }
        root.right = tmp;
    }