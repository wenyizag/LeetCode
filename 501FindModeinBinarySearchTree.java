    
    //思路是利用BST的性质，如果我们按照postorder遍历，那么会得到一个递减的序列，所以当pre的值和cur的值不等的时候，就说明该值不会再出现了
    //那么把它的出现次数和mode比较
    int mode = 0, cur = 0;
    Stack<Integer> s = new Stack<>();
    int pre = Integer.MIN_VALUE;
    
    public int[] findMode(TreeNode root) {
        helper(root);
        int[] ans = new int[s.size()];
        int i = 0;
        //将stack转换为array
        while(!s.isEmpty()){
            ans[i++] = s.pop();
        }
        return ans;
    }
    public void helper(TreeNode node){
        if(node == null) return;
        helper(node.right);
        
        if(node.val == pre || pre == Integer.MIN_VALUE){
            cur += 1;
        }else{
            cur = 1;
        }
        if(cur > mode){
            s.clear();
            s.push(node.val);
            mode = cur;
        }else if(cur == mode){
            s.push(node.val);
        }
        
        pre = node.val;
        helper(node.left);
    }