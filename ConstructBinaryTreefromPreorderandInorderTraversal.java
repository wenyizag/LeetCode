package leetcode;

import java.util.HashSet;
import java.util.LinkedList;

public class ConstructBinaryTreefromPreorderandInorderTraversal {
	public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if(root == null) return ans;
        
        HashMap<Integer, LinkedList<Integer>> map = new HashMap<>();
        Queue<Integer> col = new LinkedList<>();
        Queue<TreeNode> q = new LinkedList<>();
        int min = 0, max = 0;
        
        q.add(root);
        col.add(0);
        while(!q.isEmpty()) {
        		TreeNode cur = q.poll();
        		int index = col.poll();
        		
        		if(!map.containsKey(index)) {
        			map.put(index, new LinkedList<>());
        		}
        		map.get(index).add(cur.val);
        		
        		if(cur.left != null) {
        			q.add(cur.left);
        			col.add(index-1);
        			min = Math.min(min, index-1);
        		}
        		if(cur.right != null) {
        			q.add(cur.right);
        			col.add(index+1);
        			max = Math.max(max, index+1);
        		}
        }
        for(int i = min; i<=max; i++) {
        		ans.add(map.get(i));       		
        }       
        return ans;        
    }
}
