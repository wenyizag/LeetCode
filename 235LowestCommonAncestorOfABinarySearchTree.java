    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //自己写的版本
        //if(root == null) return root;
        //if(root.val == p.val || root.val == q.val) return root;
        //if((root.val > p.val && root.val < q.val) ||
          //(root.val < p.val && root.val > q.val)) return root;
        //if(root.val > p.val) return lowestCommonAncestor(root.left, p, q);
        //else return lowestCommonAncestor(root.right, p, q);
        
        //优化版
        while((root.val - p.val) * (root.val - q.val) > 0)
            root = (root.val - p.val) > 0 ? root.left : root.right;
        return root;
    }