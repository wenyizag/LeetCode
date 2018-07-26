//Solution 1 - recursion

	public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        helper(ans, root);
        return ans;
    }
	public void helper(List<Integer> ans, TreeNode root) {
		if(root == null) return;
		helper(ans, root.left);
		ans.add(root.val);
		helper(ans, root.right);
	}

//Solution 2 - Iteration
	public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        Stack<TreeNode> s = new Stack<>();
        //为什么不在这里先push root呢，因为根据pop的顺序得先pop左子啊，所以得先push左子
        
        while(!s.isEmpty() || root != null) {
            //先把所有最左边的node入栈
            while(root != null){
                s.push(root);
                root = root.left;
            }
            //pop出最左的那个
            root = s.pop();
            ans.add(root.val);
            //如果最左的node有右子，则继续遍历这个右子
            root = root.right;
        }
        return ans;
    }