class Solution {
     HashMap<String, PriorityQueue<String>> map;
     LinkedList<String> ans;
    
    public List<String> findItinerary(String[][] tickets) {
        map = new HashMap<>();
        ans = new LinkedList<>();
        
        for(String[] cur : tickets) {
            map.putIfAbsent(cur[0], new PriorityQueue<>());
            map.get(cur[0]).add(cur[1]);
        }
        DFS("JFK");
        return ans;
    }
    
    public void DFS(String cur) {
        PriorityQueue<String> trips = map.get(cur);
        while(trips != null && !trips.isEmpty()) {
            DFS(trips.poll());
        }
        ans.addFirst(cur);
    }
    
}