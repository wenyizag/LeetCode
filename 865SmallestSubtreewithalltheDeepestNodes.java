    //我的思路是遍历两边，第一遍求出每个节点对应的level，用map保存，同时得知最大的depth，第二遍求包含了最大depth的最小节点
    //其实只用一遍遍历就可做这两件事，下一种优化里写
    int max = 0;
    HashMap<TreeNode, Integer> map = new HashMap<>();
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        helper(root, 0);
        return subtree(root);
    }
    public void helper(TreeNode node, int level){
        if(node == null) return;
        map.put(node, level);
        if(level > max) max = level;
        helper(node.left, level+1);
        helper(node.right, level+1);
    }
    public TreeNode subtree(TreeNode node){
        if(node == null) return null;
        if(map.get(node) == max) return node;
        TreeNode left = subtree(node.left);
        TreeNode right = subtree(node.right);
        if(left != null && right != null) return node;
        if(left != null) return left;
        return right;
    }


        //这个思路是这样的，先是求出最大深度h，然后h带到结点node中
    TreeNode ans;
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        int h = height(root);
        subtree(root, h);
        return ans;
    }
    public int height(TreeNode node){
        if(node == null) return 0;
        return Math.max(height(node.left), height(node.right))+1;
    }
    
    public boolean subtree(TreeNode node, int h){
        //如果node的深度和h一样，那说明这是最深节点
        if(node == null) return h == 0;
        //如果node的左右两个节点都是含最深节点，那么更新ans
        boolean left = subtree(node.left, h-1);
        boolean right = subtree(node.right, h-1);
        if(left && right) ans = node;
        //但凡左右中含有一个最深的，那它也算含有最深的，两个都不含才返回false
        return left || right;
    }