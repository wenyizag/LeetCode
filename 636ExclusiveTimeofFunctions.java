class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] ans = new int[n];
        Stack<Integer> s = new Stack<>();
        
        int preTime = 0;
        for(String str : logs){
            String[] cur = str.split(":");
            int id = Integer.valueOf(cur[0]);
            int time = Integer.valueOf(cur[2]);
            if(s.isEmpty()){
                s.push(id);
            }
            else if(cur[1].equals("start")){
                ans[s.peek()] += time - preTime;
                s.push(id);
            }else{
                time = time + 1;
                ans[s.pop()] += time - preTime;
            }
            preTime = time;
        }
        return ans;
    }
}