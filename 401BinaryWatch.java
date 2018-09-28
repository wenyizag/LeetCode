    public List<String> readBinaryWatch(int num) {
        int[] hours = {1, 2, 4, 8};
        int[] mins = {1, 2, 4, 8, 16, 32};
        
        List<String> ans = new ArrayList<>();
        for(int i = 0; i <= num; i++){
            List<Integer> hour = generator(i, true, hours);
            List<Integer> min = generator(num-i, false, mins);

            for(int h : hour){
                System.out.println("h "+h);
                for(int m : min){
                    String s_min = (m <= 9) ? "0"+m : m+"";
                    ans.add(h + ":" + s_min);
                }
            }
        }
        return ans;
    }
    
    //backtracking为什么我特地再写一个中间的class呢，因为这个生成的list每次一用完就需要丢弃，不能重复利用，所以要返回list的话，不能在这个class里循环
    public List<Integer> generator(int count, boolean b, int[] num){
        List<Integer> list = new ArrayList<>();
        helper(list, count, 0, 0, b, num);
        return list;
    }
    
    public void helper(List<Integer> list, int count, int start, int sum, boolean b, int[] num){
        if(count == 0){
            if(b && sum < 12) list.add(sum);
            if(!b && sum < 60) list.add(sum);
            return;
        }
        for(int i = start; i < num.length; i++){
            helper(list, count-1, i+1, sum+num[i], b, num);
        } 
    }

//Solution 2
        public List<String> readBinaryWatch(int num) {
        List<String> ans = new ArrayList<>();
        for(int i = 0; i < 12; i++){
            if(Integer.bitCount(i) > num) continue;
            for(int j = 0; j < 60; j++){
                if(Integer.bitCount(j) > num) continue;
                if(Integer.bitCount(i) + Integer.bitCount(j) == num){
                    String mins = (j <= 9) ? "0"+j : j+"";
                    ans.add(i + ":" + mins);
                }
            }
        }
        return ans;
    }