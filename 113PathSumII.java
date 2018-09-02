    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> list = new ArrayList<>();
        helper(list, new ArrayList<>(), root, sum);
        return list;
    }
    public void helper(List<List<Integer>> list, List<Integer> curList, TreeNode node, int sum){
        if(node == null) return;
        sum -= node.val;
        curList.add(node.val);
        if(sum == 0 && node.left ==null && node.right == null){
            list.add(new ArrayList<Integer>(curList)); 
            //这是一个易错点，就是每次返回的时候，都需要把最后一个点去掉，这是因为List的性质，它不会随着递归的调回而消除之前添加的值，所以需要手动修改
            curList.remove(curList.size()-1);
            return;
        }
        helper(list, curList, node.left, sum);
        helper(list, curList, node.right, sum);
        curList.remove(curList.size()-1);
    }