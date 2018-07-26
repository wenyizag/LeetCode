    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(root, ans, 0);
        return ans;
    }
    //没啥好说的，思路就是根据depth判断在arraylist里是正插还是反插
    public void helper(TreeNode node, List<List<Integer>> ans, int depth) {
    		if(node == null) return;
    		if(depth >=  ans.size()) {
    			ans.add(new ArrayList<Integer>());
    		}
    		if((depth & 1) == 0) {
    			ans.get(depth).add(node.val);
    		}else {
    			ans.get(depth).add(0, node.val);
    		}
    		helper(node.left, ans, depth+1);
    		helper(node.right, ans, depth+1);
    }