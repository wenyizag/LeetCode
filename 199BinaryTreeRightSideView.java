    
//其实思路还是dfs层遍历
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        helper(root, 0, ans);
        return ans;
        
    }
    public void helper(TreeNode node, int depth, List<Integer> ans) {
    		if(node == null) return;
    		if(depth >= ans.size()) {
    			ans.add(node.val);
    		}else {
    			ans.set(depth, node.val);
    		}
            //先遍历左子，然后如果有右子就去覆盖左子的值
    		helper(node.left, depth+1, ans);
    		helper(node.right, depth+1, ans);
    }