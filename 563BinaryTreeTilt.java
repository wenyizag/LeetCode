	int tilt = 0;
    public int findTilt(TreeNode root) {
        //虽然这个sum函数是int返回型，但是如果这个返回值我们不需要的话，也可以当void使呢
        sum(root);
        return tilt;
    }
    
    //思路就是用一个recursion，将所有node的值改变为它的值加上其subtree的所有节点的sum
    public int sum(TreeNode node) {
    		if(node == null) return 0;
    		int left = sum(node.left);
    		int right = sum(node.right);
           //并在此时计算tilt
    		tilt += Math.abs(left - right);
    		node.val += left + right;
    		return node.val;
    }