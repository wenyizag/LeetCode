    
//Solution 1. Iteration
//今天终于弄懂了。。。
//为什么用stack不用queue，因为stack是dfs好助手，queue适合层遍历
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        
        while(!s.isEmpty()) {
            root = s.pop();
            ans.add(root.val);
            //注意push的顺序，preorder本应是father -> left -> right，所以push的时候顺序应该是先right再left
            if(root.right != null) s.push(root.right);
            if(root.left != null) s.push(root.left);
        }
        return ans;
    }

//Recursion
    public List<Integer> preorderTraversal(TreeNode root) {
       List<Integer> ans = new ArrayList<>();
        helper(root, ans);
        return ans;
    }
    public void helper(TreeNode node, List<Integer> ans){
        if(node == null)
            return;
        ans.add(node.val);
        helper(node.left, ans);
        helper(node.right, ans);
    }