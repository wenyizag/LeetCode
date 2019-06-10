    public List<List<Integer>> verticalOrder(TreeNode root) {
        // write your code here
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> index = new LinkedList<>();
        q.add(root);
        index.add(0);
        int min = 0, max = 0;
        
        while(!q.isEmpty()) {
            TreeNode cur = q.poll();
            int idx = index.poll();
            min = Math.min(min, idx);
            max = Math.max(max, idx);
            
            if(!map.containsKey(idx))
                map.put(idx, new ArrayList<Integer>());
            map.get(idx).add(cur.val);
            if(cur.left != null) {
                q.add(cur.left);
                index.add(idx-1);
            }
            if(cur.right != null) {
                q.add(cur.right);
                index.add(idx+1);
            }
        }
        
        for(int i = min; i<=max; i++)
            ans.add(map.get(i));
    
        return ans;
    }


//这题有DFS版本的做法，但是容易错，因为hashmap里必须用priorityQueue，
//因为它要求在上面的层的数排序优先于下面层，所以是普通的preOrder，inOrder无法达到的
//最好就直接用queue层遍历
