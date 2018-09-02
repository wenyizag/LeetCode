    //思路是利用前序遍历，这样比如 5[3 2 4][7 6 8]，这样第一个node是root，此后比root小的肯定都是左子，比它大的为右子
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        StringBuilder s = new StringBuilder("");
        s.append(" "+root.val);
        s.toString();
        return s + serialize(root.left) + serialize(root.right);
        
    }

    // Decodes your encoded data to tree.
    private String sep = " ";
    private String Null = "";
    public TreeNode deserialize(String data) {
        if(data.equals("")) return null;
        String[] nodes = data.split(sep);
        Queue<Integer> q = new LinkedList<>();
        for(String node : nodes) {
            //我为啥加了这一句话呢，是因为data.split的时候有个""string也被分出来了，不知道为啥。。。
                if(node.equals(Null)) continue;
        		q.add(Integer.parseInt(node));
        }
        return helper(q);
    }
    
    public TreeNode helper(Queue<Integer> q) {
    		if(q.isEmpty()) return null;
    		TreeNode root = new TreeNode(q.poll());
    		Queue<Integer> smallq = new LinkedList<>();
    		while(!q.isEmpty() && q.peek() < root.val) {
    			smallq.add(q.poll());
    		}
    		root.left = helper(smallq);
    		root.right = helper(q);
    		return root;
    }