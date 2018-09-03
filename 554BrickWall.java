    public int leastBricks(List<List<Integer>> wall) {
        int max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(List<Integer> cur : wall){
            int lenSum = 0;
            //然后这个为什么只到cur.size()-1呢，因为墙的两边不算啊，最后一块加上去的width总是相等的，没有计算的必要
            for(int i = 0 ; i < cur.size()-1; i++){
                lenSum += cur.get(i);
                map.put(lenSum, map.getOrDefault(lenSum, 0)+1);
                max = Math.max(max, map.get(lenSum));
            }
        }
        
        return wall.size()-max;    
    }