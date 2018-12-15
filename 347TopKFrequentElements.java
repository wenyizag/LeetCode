//solution 1. bucket sort    
public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, List<Integer>> bucket = new HashMap<>();

        //查看频率
        for(int cur : nums){
            map.put(cur, map.getOrDefault(cur, 0)+1);
        }
        //把频率相同的数存到bucket里，同时得到最大频率
        int maxFqt = 0;
        //遍历一个map用 keySet()
        for(Integer i : map.keySet()){
            int fqt = map.get(i);
            maxFqt = Math.max(maxFqt, fqt);
            if(bucket.containsKey(fqt)){
                bucket.get(fqt).add(i);
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(i);
                bucket.put(fqt, list);
            }
        }
        //由最大频率开始往下加
        List<Integer> ans = new ArrayList<>();
        int count = 0;
        for(int i = maxFqt; i >= 0; i--){
            if(bucket.containsKey(i)){
                //注意这个小函数addAll
                ans.addAll(bucket.get(i));
                count = ans.size();
                if(count >= k) break;
            }
        }
        return ans;
    }

//solution 2. priorituQueue
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> q = new PriorityQueue(new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                return -(map.get(a) - map.get(b));
            }
        });
        for(int cur : nums){
            map.put(cur, map.getOrDefault(cur, 0) + 1);
        }
        for(int cur : map.keySet()){
            q.add(cur);
        }
        List<Integer> ans = new ArrayList<>();
        while(k > 0){
            ans.add(q.poll());
            k--;
        }
        return ans;
    }