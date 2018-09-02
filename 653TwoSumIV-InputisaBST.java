//Solution 1
    //set需要写到外面来，不然每一次递归都重新创建了。。
    Set<Integer> set = new HashSet<>();
    public boolean findTarget(TreeNode root, int k) {
        if(root == null) return false;
        if(set.contains(k-root.val)) return true;
        else set.add(root.val);
        
        return findTarget(root.left, k) || findTarget(root.right, k);
    }

//Solution 2
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new LinkedList<>();
        helper(root, list);
        int low = 0, high = list.size()-1;
        while(low < high){
            int l = list.get(low);
            int h = list.get(high);
            if((l + h) == k) return true;
            else if((l + h) > k) high--;
            else low++;
        }
        return false;
    }
    public void helper(TreeNode node, List<Integer> list){
        if(node == null) return;
        helper(node.left, list);
        list.add(node.val);
        helper(node.right, list);
        
    }