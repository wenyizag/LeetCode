    HashMap<Integer, List<TreeNode>> map = new HashMap<>();
    public List<TreeNode> allPossibleFBT(int N) {
        List<TreeNode> ans = new LinkedList<>();
        if(N == 1) {
            ans.add(new TreeNode(0));
            return ans;
        } 
        if(map.containsKey(N)) return map.get(N);
        for(int l = 1; l < N; l += 2){
            for(TreeNode left : allPossibleFBT(l)){
                for(TreeNode right : allPossibleFBT(N-1-l)){
                    TreeNode node = new TreeNode(0);
                    node.left = left;
                    node.right = right;
                    ans.add(node);
                }
            }
        }
        map.put(N, ans);
        return ans;
    }