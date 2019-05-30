class Solution {
    String ans = null;
    public String smallestFromLeaf(TreeNode root) {
        if(root == null) return "";
        helper(root, "");
        return ans;
    }
    public void helper(TreeNode node, String suffix) {
        if(node == null) return;
        String cur = (char)(node.val + 'a') + suffix;
        if(node.left == null && node.right == null) {
            if(ans == null) ans = cur;
            else ans = ans.compareTo(cur)<0 ? ans : cur;
        }
        helper(node.left, cur);
        helper(node.right, cur);
    }
}
