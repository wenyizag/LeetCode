/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Node{
    int val;
    int level;
    public Node(int val, int level) {
        this.val = val;
        this.level = level;
    }
}

class Solution {

    int min = 0, max = 0;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        
        HashMap<Integer, PriorityQueue<Node>> map = new HashMap<>();
        DFS(root, map, 0, 0);
        
        for(int i = min; i <= max; i++) {
            List<Integer> list = new ArrayList<>();
            PriorityQueue<Node> cur = map.get(i);
            while(!cur.isEmpty()) {
                list.add(cur.poll().val);
            }
            ans.add(list);
        }
        return ans;
    }
    
    public void DFS(TreeNode node, HashMap<Integer, PriorityQueue<Node>> map, int index, int level) {
        if(node == null) return;
        if(!map.containsKey(index)) {
            min = Math.min(min, index);
            max = Math.max(max, index);
            map.put(index, new PriorityQueue<Node>(new Comparator<Node>(){
                public int compare(Node a, Node b) {
                    return (a.level != b.level) ? a.level - b.level : a.val - b.val;
                }
            })
           );
        }
        map.get(index).add(new Node(node.val, level));
        if(node.left != null) DFS(node.left, map, index-1, level+1);
        if(node.right != null) DFS(node.right, map, index+1, level+1);
    }
}
