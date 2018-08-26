//思路是分别找出以当前节点为根节点的左子树和右子树的高度并对比，如果相等，则说明是满二叉树，直接返回节点个数，如果不相等，则节点个数为左子树的节点个数加上右子树的节点个数再加1(根节点)，其中左右子树节点个数的计算可以使用递归来计算
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        TreeNode left = root.left, right = root.right;
        int leftlevel = 1, rightlevel = 1;
        while(right != null){
            rightlevel++;
            right = right.right;
        }
        while(left != null){
            leftlevel++;
            left = left.left;
        }
        if(rightlevel == leftlevel){
            //这里求平方的时候改为bit manipulation会更快些
            return (1<<leftlevel)-1;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;  
    }