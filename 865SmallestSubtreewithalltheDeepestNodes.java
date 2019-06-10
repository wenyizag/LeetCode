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
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        int height = getHeight(root);
        // System.out.println(height);
        TreeNode ans = getSubtree(root, height);
        return ans;
    }
    
    public int getHeight(TreeNode node) {
        if(node == null) return 0;
        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }
    
    public TreeNode getSubtree(TreeNode node, int height) {
        if(node == null) return null;
        if(height == 1) {
            return node;
        }
        TreeNode left = getSubtree(node.left, height-1);
        TreeNode right = getSubtree(node.right, height-1);
        if(left == null && right == null) return null;
        else if(left!=null && right!=null) return node;
        else if(left != null) return left;
        else return right;
    }
