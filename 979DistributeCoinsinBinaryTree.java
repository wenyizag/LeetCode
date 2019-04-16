class Solution {
    int ans = 0;
    public int distributeCoins(TreeNode root) {
        distribute(root);
        return ans;   
    }
    
    public int distribute(TreeNode node) {
        if(node == null) return 0;
        // int coins = node.val;
        int left = distribute(node.left);
        int right = distribute(node.right);
        ans += Math.abs(left) + Math.abs(right);
        return node.val + left + right - 1;
    }
}