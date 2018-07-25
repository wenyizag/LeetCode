    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(root == null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
     	   		int size = q.size();
     	   		List<Integer> level = new ArrayList<>();
     	   		for(int i = 0; i < size; i++) {
     	   			TreeNode cur = q.poll();
     	   			level.add(cur.val);
     	   			if(cur.left != null) q.add(cur.left);
     	   			if(cur.right != null) q.add(cur.right);
     	   		}
                //在指定index插入
     	   		ans.add(0, level);
        }
        return ans;
     }