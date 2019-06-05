    
    //思路是利用BST的性质，如果我们按照postorder遍历，那么会得到一个递减的序列，所以当pre的值和cur的值不等的时候，就说明该值不会再出现了
    //那么把它的出现次数和mode比较
        List<Integer> list;
    TreeNode pre = null;
    int curCount = 0;
    int maxCount = 0;
    public int[] findMode(TreeNode root) {
        list = new ArrayList<>();
        
        inOrder(root);
        
        int[] ans = new int[list.size()];
        for(int i = 0; i < list.size(); i++) ans[i] = list.get(i);
        return ans;
    }
    public void inOrder(TreeNode node) {
        if(node == null) return;
        inOrder(node.left);
        if(pre == null || pre.val != node.val) {
            curCount = 1;
        }else {
            curCount += 1;
        }
        if(curCount > maxCount) {
            list.clear();
            list.add(node.val);
            maxCount = curCount;
        }else if(curCount == maxCount) {
            list.add(node.val);
        }

        pre = node;
        inOrder(node.right);
    }
