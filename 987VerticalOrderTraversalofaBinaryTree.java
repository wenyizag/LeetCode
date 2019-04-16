class Node {
    TreeNode n;
    int x;
    int y;
    Node(TreeNode n, int x, int y) {
        this.n = n;
        this.x = x;
        this.y = y;
    }
}
class Solution {
    int maxLevel = 0, minLevel = 0;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        
        HashMap<Integer, TreeSet<Node>> map = new HashMap<>();
        preorderTraverse(map, new Node(root, 0, 0));
            
        for(int i = minLevel, j = 0; i <= maxLevel; i++, j++) {
            ans.add(new ArrayList<Integer>());
            for(Node cur : map.get(i)) {
                ans.get(j).add(cur.n.val);
            }
        }
        
        return ans;
    }
    
    public void preorderTraverse(HashMap<Integer, TreeSet<Node>> map, Node cur) {
        // if(node == null) return;
        minLevel = Math.min(cur.x, minLevel);
        maxLevel = Math.max(cur.x, maxLevel);
        if(!map.containsKey(cur.x)) {
            map.put(cur.x, new TreeSet<Node>(new Comparator<Node>(){
                public int compare(Node a, Node b) {
                    return (a.y != b.y) ? (a.y - b.y) : (a.n.val - b.n.val);
                }
            }));
        }
        map.get(cur.x).add(cur);
        if(cur.n.left != null) preorderTraverse(map, 
                                new Node(cur.n.left, cur.x-1, cur.y + 1));
        if(cur.n.right != null) preorderTraverse(map, 
                                new Node(cur.n.right, cur.x+1, cur.y + 1));
        
    }
}