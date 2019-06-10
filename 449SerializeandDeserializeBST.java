/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    //思路是利用前序遍历，这样比如 5[3 2 4][7 6 8]，这样第一个node是root，此后比root小的肯定都是左子，比它大的为右子
    // Encodes a tree to a single string.
    private String SEP = "#";
    private String NULL = "";
    public String serialize(TreeNode root) {
        if(root == null) return "";
        // StringBuilder s = new StringBuilder("");
        // s.append(root.val);
        // s.toString();
        return root.val + "#" + serialize(root.left) + serialize(root.right);
        
    }

    // Decodes your encoded data to tree.
    
    public TreeNode deserialize(String data) {
        if(data.equals(NULL)) return null;
        String[] nodes = data.split(SEP);
        Queue<Integer> q = new LinkedList<>();
        for(String node : nodes) {
            //我为啥加了这一句话呢，是因为data.split的时候有个""string也被分出来了，不知道为啥。。。
                // if(node.equals(NULL)) continue;
        		q.add(Integer.parseInt(node));
        }
        return helper(q);
    }
    
    public TreeNode helper(Queue<Integer> q) {
        if(q.isEmpty()) return null;
        TreeNode root = new TreeNode(q.poll());
        
        Queue<Integer> left = new LinkedList<>();
        while(!q.isEmpty() && q.peek() < root.val) left.add(q.poll());
        
        root.left = helper(left);
        root.right = helper(q);
        
        return root;    
    }
    

    	
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
