public class BSTIterator {

//思路：这题是要快速求一个二叉搜索数是否有下一个最小结点。我们知道二叉搜索数的性质，结点左边的值比根节点小，结点右边的值比根节点大。那么利用这个性质可以知道最小的结点应该是在最左边，其实也就是中序遍历是依次增大的。知道了这样我们其实可以利用一个栈将所有结点按照: 右->根->左的方式入栈然后再依次出栈即可。这样在时间复杂度上可以达到O(1)，但空间复杂度是O(n)，ｎ为结点个数。这样不符合要求的O(h)的时间复杂度。
    
//我们还可以初始只让根的左子树入栈直到最左结点，每次结点出栈的时候再把他的右子树入栈，这样就可以达到O(h)的时间复杂度。
    
	Stack<TreeNode> s = new Stack<>();
    public BSTIterator(TreeNode root) {
        while(root != null) {
        		s.push(root);
        		root = root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !s.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode cur = s.pop();
        int ans = cur.val;
        cur = cur.right;
        while(cur != null) {
        		s.push(cur);
            //注意这里仍旧是左子树，意思查看一个右节点后，一直往左方向走。
        		cur = cur.left;
        }
        return ans;
    }
}