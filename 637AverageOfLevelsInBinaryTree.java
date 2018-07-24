    //Solution 1
    public List<Double> averageOfLevels(TreeNode root) {
        //求每层的平均值的话，第一个思路肯定是BFS，常规做法，不细讲
            Queue<TreeNode> q = new LinkedList<>();
            List<Double> ans = new LinkedList<>();
            
            q.add(root);
            while(!q.isEmpty()) {
                int size = q.size();
                //这是一个易错点，就是得将sum的type设置为double，用int就错了
                double sum = 0;
                for(int i = 0; i < size; i++) {
                    TreeNode cur = q.poll();
                    sum += cur.val;
                    if(cur.left != null) q.add(cur.left);
                    if(cur.right != null) q.add(cur.right);
                }
                ans.add(sum/size);
            }
        return ans;
    }


    //Solution 2
    public List<Double> averageOfLevels(TreeNode root) {
        //DFS, 思路就是用两个list，一个用来记录每一层的sum，一个用来记录每一层的个数，递归的时候传递层数
 		    List<Double> sum = new LinkedList<>();
    		List<Integer> level = new LinkedList<>();
    		helper(root, sum, level, 0);
    		for(int i = 0; i < sum.size(); i++) {
    			sum.set(i, sum.get(i)/level.get(i));
    		}
    		return sum;
    }
    public void helper(TreeNode node, List<Double> sum, List<Integer> level, int index) {
    		if(node == null) return;
            //注意判断边界条件
    		if(index >= level.size()) {
    			level.add(1);
                //因为node.val是int型的，所以将之转化为double
    			sum.add((double) node.val);
    		}else {
    			level.set(index, level.get(index)+1);
    			sum.set(index, sum.get(index)+node.val);
    		}
    		helper(node.left, sum, level, index+1);
    		helper(node.right, sum, level, index+1);
    }