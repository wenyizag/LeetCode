    //DFS
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        helper(root, ans, "");
        return ans;
    }
    public void helper(TreeNode node, List<String> ans, String s) {
    		if(node == null) return;
    		if(node.left == null && node.right == null) {
    			ans.add(s + node.val);
                return;
    		}
		    if(node.left != null) {
    			helper(node.left, ans, s + node.val + "->");
    		}
            //注意这里不是else if，因为是每条路径都要加，不是有了左子就不管右子
    		if(node.right != null) {
                //注意即便有孩子的情况也要加node.val，不然路径就成了 ->->->leaf.val
    			helper(node.right, ans, s + node.val+ "->");
            }		
    }