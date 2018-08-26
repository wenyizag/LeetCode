//其实就是考一个后序遍历
    public int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        helper(root);
        return root;
    }
    public void helper(TreeNode node){
        if(node == null) return;
        helper(node.right);
        node.val += sum;
        sum = node.val;
        helper(node.left);
        return;
    }

//用stack的方法
    public TreeNode convertBST(TreeNode root) {
       Stack<TreeNode> s = new Stack<>();
        int sum = 0;
        //要给这个root指针存一个底，因为之后被改变了
        TreeNode ans = root;
        while(!s.isEmpty() || root != null){
            while(root != null){
                s.push(root);
                root = root.right;
            }
            root = s.pop();
            root.val += sum;
            sum = root.val;
            root = root.left;
        }
        return ans;
    }