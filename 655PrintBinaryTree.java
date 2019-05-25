class Solution {
    public List<List<String>> printTree(TreeNode root) {
        int height = getHeight(root);
        int width = (1<<height) - 1;
        List<List<String>> ans = new ArrayList<>();
        for(int i = 0; i < height; i++) {
            String[] tmp = new String[width];   
            Arrays.fill(tmp, "");
            ans.add(Arrays.asList(tmp));
        }
        fill(root, ans, 0, 0, width);
        return ans;
    }
    
    public int getHeight(TreeNode node) {
        if(node == null) return 0;
        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }
    
    public void fill(TreeNode node, List<List<String>> ans, int depth, int l, int r)
    {
        if(node == null) return;
        int mid = l + (r-l)/2;
        
        ans.get(depth).set(mid, node.val + "");
        
        fill(node.left, ans, depth+1, l, mid-1);
        fill(node.right, ans, depth+1, mid+1, r);       
    }   
}