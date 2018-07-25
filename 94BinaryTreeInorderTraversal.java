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
        //其实这个思路和173是一模一样的，就是先不停地往左边走，边走边加入stack，直到左边为null
        //然后pop一个最左点，answer中加入它的值，然后它的左子肯定是null，它自己又已经访问过了，就接着访问它的右节点(此时不用加入stack)
        //循环的时候会加入
        while(root != null || !s.isEmpty()) {
        		//将所有的左子树入栈
        		while(root != null) {
        			s.push(root);
        			root = root.left;
        		}
        		//pop最左的那个
        		root = s.pop();
        		ans.add(root.val);
        		root = root.right;
        }
        return ans;
    }