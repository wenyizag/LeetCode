    public List<String> topKFrequent(String[] words, int k) {

        //using hashMap to store frequence
        HashMap<String, Integer> map = new HashMap<>();
        for(String cur : words){
            map.put(cur, map.getOrDefault(cur, 0) + 1);
        }        
        
        //using priorityQueue to store answer
        PriorityQueue<String> q = new PriorityQueue<>(k+1, new Comparator<String>(){
             public int compare(String s1, String s2){
                if(map.get(s1) == map.get(s2)){
                    return -s1.compareTo(s2);
                }else
                    return map.get(s1) - map.get(s2);
            }
        });
        
        for(String cur : map.keySet()){
            q.add(cur);
            if(q.size() > k) q.poll();
        }

        List<String> ans = new ArrayList<>();
        while(!q.isEmpty()){
            ans.add(0, q.poll());
        }
        return ans;
    }
