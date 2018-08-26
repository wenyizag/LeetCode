    public String tree2str(TreeNode t) {
        if(t == null) return "";
        String s = t.val+"";
        //只要右边有值，就要把左边的加上
        if(t.right != null){
            s = s + "(" + tree2str(t.left) + ")" + "(" + tree2str(t.right) + ")";
        //如果左边有值，但是右边没值，就只加左边的
        }else if(t.left != null){
            s = s + "(" + tree2str(t.left) + ")";
        }
        return s;
    }