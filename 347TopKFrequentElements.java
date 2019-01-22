//solution1. bucket sort
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer>[] bucket = new ArrayList[nums.length + 1];
        
        for(int num : nums) 
            map.put(num, map.getOrDefault(num, 0) + 1);
        
        for(int key : map.keySet()) {
            int freq = map.get(key);
            if(bucket[freq] == null)
                bucket[freq] = new ArrayList<>();
            bucket[freq].add(key);
        }
        
        int sum = 0;
        List<Integer> ans = new ArrayList<>();
        for(int i = bucket.length - 1; i >= 0; i--) {
            if(bucket[i] != null && sum < k) {
                ans.addAll(bucket[i]);
                sum = ans.size();
            }
            if(sum >= k) break;
        }
        return ans;
        
    }
}

//PriorityQueue
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> q = new PriorityQueue(new Comparator<Integer>(){
            public int compare(Integer a, Integer b) {
                return map.get(a) - map.get(b);
            }
        });
        
        for(int num : nums) 
            map.put(num, map.getOrDefault(num, 0) + 1);
        
        for(int key : map.keySet()) {
            q.add(key);
            if(q.size() > k) q.poll();
        }
        
        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()) {
            ans.add(0, q.poll());
        }
        
        return ans;
    }
}