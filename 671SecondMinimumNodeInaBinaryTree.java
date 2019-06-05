 //我觉得我这个思路只用一遍遍历，比大众解法要好，美滋滋
    Integer min = null, secondMin = null;
    public int findSecondMinimumValue(TreeNode root) {
        helper(root);
        return (secondMin == null) ? -1 : secondMin;
    }
    //是这样的，有两个数来记录，分别是min和secondMin，那求min不用说了，就只要node的值比min小就更新min
    //在更新min的时候，同时将secondMin的值换成旧的min，那它肯定就是第二小的
    //但有一个问题，如果一来我的min就直接是最小了，secondMin只更新了一次，而那一次的更新值是Integer.MAX_VALU，就不是正确答案，比如example 1
    //这个时候我再需要把（node.val > min && node.val < secondMin）这样比较一下不就可以了吗。美滋滋
    public void helper(TreeNode node){
        if(node == null) return;
        if(min == null || node.val < min){
            secondMin = min;
            min = node.val;
        }else if(node.val > min && (secondMin == null || node.val < secondMin)){
            secondMin = node.val;
        }

        
        helper(node.left);
        helper(node.right);
    }
    
    //大众解法是遍历tree得到一个list，把list转换为数组，再把数组sort，求第二小
