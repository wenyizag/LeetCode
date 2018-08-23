    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        ans.add(1);
        if(rowIndex == 0) return ans;
        
        int row = 0, size;
        while(row < rowIndex){
            size = ans.size();
            for(int i = 0; i < size-1; i++){
                //然后注意下set这个函数是怎么写的
                ans.set(i, ans.get(i)+ans.get(i+1));
            }
            //add这个函数第一位是index，第二位才是值
            ans.add(0, 1);
            row++;
        }
        return ans;
    }