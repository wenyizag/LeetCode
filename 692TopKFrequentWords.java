    public List<String> topKFrequent(String[] words, int k) {

        //用hashmap统计出现次数
        HashMap<String, Integer> map = new HashMap<>();
        for(String cur : words){
            map.put(cur, map.getOrDefault(cur, 0)+1);
        }

        //这里的compare没有用一个新的class写是因为需要用到map里的数据
        PriorityQueue<String> q = new PriorityQueue( new Comparator<String>(){
            public int compare(String s1, String s2){
                if(map.get(s1) == map.get(s2)){
                    return -s1.compareTo(s2);
                }else{
                    return map.get(s1) - map.get(s2);
                }
            }
        });
        //用priorityQueu找出前k个
        for(String cur : map.keySet()){
            q.offer(cur);
            if(q.size() > k){
                q.poll();
            }
        }
        //把priorityQueue里的转换到list，注意需倒着插，因为queue里是从小到大排列
        List<String> ans = new ArrayList<>();
        while(!q.isEmpty()){
            ans.add(0, q.poll());
        }
        return ans;
    }