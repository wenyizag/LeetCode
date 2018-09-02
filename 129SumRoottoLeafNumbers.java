    int sum = 0;
    public int sumNumbers(TreeNode root) {
        helper(root, 0);
        return sum;
    }
    public void helper(TreeNode node, int curSum){
        if(node == null) return;
        curSum = curSum*10 + node.val;
        if(node.left == null && node.right == null){
            sum += curSum;
            return;
        }
        helper(node.left, curSum);
        helper(node.right, curSum);
    }

    //第二种方法是用遍历，用两个queue，一个来遍历，另一个记录当前的curSum

        public int sumNumbers(TreeNode root) { 
        if(root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> level = new LinkedList<>();
        q.add(root);
        level.add(root.val);
        int sum = 0;
        while(!q.isEmpty()) {
            TreeNode cur = q.poll();
            int curValue = level.poll();
            if(cur.left == null && cur.right == null)
                sum = sum + curValue;
            if(cur.left != null) {
                q.add(cur.left);
                level.add(curValue*10 + cur.left.val);
            }
            if(cur.right != null){
                q.add(cur.right);
                level.add(curValue*10 + cur.right.val);
            }                       
        }
        return sum;
    }