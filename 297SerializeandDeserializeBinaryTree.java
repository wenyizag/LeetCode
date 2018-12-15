public class Codec {
    private String spliter = ",";
    private String NULL = "#";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder s = new StringBuilder("");
        preOrderSerial(root, s);
        return s.toString();
    }
    
    public void preOrderSerial(TreeNode node, StringBuilder s){
        if(node == null){
            s.append(NULL).append(spliter);
            return;
        }else{
            s.append(node.val).append(spliter);
            preOrderSerial(node.left, s);
            preOrderSerial(node.right, s);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> dq = new LinkedList<>();
        dq.addAll(Arrays.asList(data.split(spliter)));
        return preOrderDeserial(dq);
    }
    
    public TreeNode preOrderDeserial(Queue<String> dq){
        String cur = dq.remove();
        if(cur.equals(NULL)){
            return null;
        }
        else{
            TreeNode node = new TreeNode(Integer.parseInt(cur));
            node.left = preOrderDeserial(dq);
            node.right = preOrderDeserial(dq);
            return node;
        }
    }
}