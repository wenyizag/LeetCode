    //递归寻找两个带查询LCA的节点p和q，当找到后，返回给它们的父亲。
    //如果某个节点的左右子树分别包括这两个节点，那么这个节点必然是所求的解，返回该节点。
    //否则，返回左或者右子树（哪个包含p或者q的就返回哪个。
    //复杂度O(n)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return root;
        if(root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        if(left != null && right != null)
          return root;
        else return left!= null ? left : right;
    }