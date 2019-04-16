class Solution {
    public String smallestFromLeaf(TreeNode root) {
        if(root == null) return "";
        //At least one of the child nodes is null
        String min = "" + (char)(root.val + 'a');
        if(root.left == null && root.right == null) {
           return "" + min; 
        }
        else if(root.left == null) {
            return smallestFromLeaf(root.right) + min;
        }
        else if(root.right == null) {
            return smallestFromLeaf(root.left) + min;
        }
        //none of the child nodes is null
        String left = smallestFromLeaf(root.left);
        String right = smallestFromLeaf(root.right);
        String cur = (left.compareTo(right) > 0) ? right : left;
        return cur + min;
    }
}