//双重递归
    public int pathSum(TreeNode root, int sum) {
        //edge case []
        if(root == null) return 0;
        //这里很重要，它的子节点是对pathSum进行递归，是对这个原函数进行递归啊，不是下面那个。。。
        return traverse(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }
    
    //这个递归是为了找出以当前节点为根节点，它的所有path上加起来合等于sum的
    public int traverse(TreeNode root, int sum) {
        int count = 0;
        if(root == null) return count;
        if(root.val == sum) count += 1;
        count += traverse(root.left, sum-root.val);
        count += traverse(root.right, sum-root.val);
        return count;
    }


       //So the idea is similar as Two sum, using HashMap to store ( key : the prefix sum, value : how many ways get to this prefix sum) , and whenever reach a node, we check if prefix sum - target exists in hashmap or not, if it does, we added up the ways of prefix sum - target into res.
//For instance : in one path we have 1,2,-1,-1,2, then the prefix sum will be: 1, 3, 2, 1, 3, let's say we want to find target sum is 2, then we will have{2}, {1,2,-1}, {2,-1,-1,2} and {2}ways. 
    
    int count = 0;
    public int pathSum(TreeNode root, int sum) {
        HashMap<Integer, Integer> map = new HashMap<>();
        //加个0是为了有直接curSum == sum的情况
        map.put(0, 1);
        helper(root, sum, 0, map);
        return count;
    }
    
    public void helper(TreeNode root, int sum, int curSum, HashMap<Integer, Integer> map) {
        if(root == null) return;
        curSum += root.val;
        if(map.containsKey(curSum - sum)){
            count += map.get(curSum - sum);
        }
        
        map.put(curSum, map.getOrDefault(curSum, 0) + 1);
        helper(root.left, sum, curSum, map);
        helper(root.right, sum, curSum, map);
        // 回溯。把已经处理完毕的当前节点从路径中清除，那这里超重要的，不加这一句就是错的，因为这道题定义的path是从root到leave，不能使leave-root-leave这样
        //所以当已经回溯的时候，就说明这条path已经处理完了，那么就要把以前放进map的值清楚掉，不然会影响其他path
        map.put(curSum, map.get(curSum) - 1);
    }