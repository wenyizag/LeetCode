//Solution 1. Recursion

    //它这个题的意思是，把value加在指定层，然后它有个没讲清楚的点是，比如我应该加在5的下面，5有左节点没有右节点，这时5的左右节点还是都要加上value
    //只是左节点加完value后，要把原本的左子树接上。右节点加完后，原本的右子树也接上（是null）
    
    //这个方法是recursion，recursion永远是最快也是最好写的哈，因为没用到多余的储存空间和数据读写
    public TreeNode addOneRow(TreeNode root, int v, int d) {
            if(d == 1) {
                TreeNode newroot = new TreeNode(v);
                newroot.left = root;
                return newroot;
            }
            helper(root, v, d, 1);
            return root;
    }
    public void helper(TreeNode node, int v, int d, int depth) {
            if(node == null) return;
            if(depth == d-1) {
                TreeNode lnode = new TreeNode(v);
                lnode.left = node.left;
                node.left = lnode;
                TreeNode rnode = new TreeNode(v);
                rnode.right = node.right;
                node.right = rnode;
                return;
            }
            helper(node.left, v, d, depth+1);
            helper(node.right, v, d, depth+1);
    }
 

 //Solution 2. BFS

     public TreeNode addOneRow(TreeNode root, int v, int d) {
        //如果是d=1，则直接加在root，由于没经过queue，单独讨论
          if(d == 1) {
            TreeNode node = new TreeNode(v);
            node.left = root;
            return node;
           }
           Queue<TreeNode> q = new LinkedList<>();
           q.add(root);
           int depth = 1;
           //简单的BFS，遍历到d-1
           while(!q.isEmpty() && depth < d-1) {
            int size = q.size();
            for(int i = 0; i< size; i++) {
                TreeNode cur = q.poll();
                if(cur.left != null) 
                    q.offer(cur.left);
                if(cur.right != null)
                    q.offer(cur.right);   
            }
            depth++;
           }
    while(!q.isEmpty()) {
            TreeNode cur = q.poll();
            //left
            TreeNode lNode = new TreeNode(v);
            //这里有个点就是不用管cur.left是不是等于null，它即使等于null，也可以加在新加的node后面
                lNode.left = cur.left;
            cur.left = lNode;
            //right
            TreeNode rNode = new TreeNode(v);
            rNode.right = cur.right;
            cur.right = rNode;
    }
    return root;
}