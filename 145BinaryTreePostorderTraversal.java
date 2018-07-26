    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        
        while(!s.isEmpty()) {
        	root = s.pop();
            //捡了个漏。。其实就是preorder倒过来，真正的postorder还没研究
            ans.add(0, root.val);
            if(root.left != null) s.push(root.left);
            if(root.right != null) s.push(root.right);
        }
        return ans;
    }