//Solution 1
    public int rob(TreeNode root) {
        if(root == null) return 0;
        int val = root.val;
        if(root.left != null) {
            val = val+rob(root.left.left) + rob(root.left.right);
        }
        if(root.right != null) {
            val = val+rob(root.right.left) + rob(root.right.right);
        }
        return Math.max(rob(root.left) + rob(root.right), val);
    }


//Solution 2. optimization
    public int rob(TreeNode root) {
        HashMap<TreeNode, Integer> map = new HashMap<>();
        return helper(root, map);
    }
    
    public int helper(TreeNode node, HashMap<TreeNode, Integer> map){
        if(node == null) return 0;
        if(map.containsKey(node)) return map.get(node);
        int val = node.val;
        
        if(node.left != null){
            val += helper(node.left.left, map) + helper(node.left.right, map); 
        }
        
        if(node.right != null){
            val += helper(node.right.left, map) + helper(node.right.right, map); 
        }
        
        val =  Math.max(helper(node.right, map) + helper(node.left, map), val);
        map.put(node, val);
        return val;
    }