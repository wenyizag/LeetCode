    //思路就是根据BST的性质DFS
    //用一个TreeNode min记录最接近值，每当有更接近的node出现的时候就更新min
    //从root开始比较，大了就走root.left，反之则走root.right，直到比到null节点。

//错误思路:
    //我之前的想法是，用一个pre和一个cur两个的值与target比较，如果两个都比target大或者小，则继续dfs，直到出现一个比target大，一个比target小，
    //然后返回这两个node中更接近的那个。
    //但这种思路错误的原因是，出现转折点不代表最接近，比如 [24,1,35,0,2,30,36], taget是 2.5，那么第一次出现转折点是24与1这一对，但其实真正的node应该是2

    TreeNode min = new TreeNode(Integer.MAX_VALUE);
    public int closestValue(TreeNode root, double target) {
        // write your code here
    		min  = root;
    		helper(root, target, Math.abs(root.val-target));
    		return min.val;
    }
    public void helper(TreeNode root, double target, double diff) {
    		if(root == null) return;
    		double rootdiff = root.val - target;
    		if(Math.abs(rootdiff) < diff) {
    			min = root;
    			diff = Math.abs(rootdiff);
    		}
    		if(rootdiff > 0)
    			helper(root.left, target, diff);
    		else
    			helper(root.right, target, diff);
    }