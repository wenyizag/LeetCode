    //加了个visited数组，其实list可以直接check list.contains(i), 但时间复杂度是O(n)
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if(nums.length == 0) return ans;
        boolean[] visited = new boolean[nums.length];
        helper(ans, new ArrayList<Integer>(), nums, visited);
        return ans;
    }
    public void helper(List<List<Integer>> ans, List<Integer> list, int[] nums, boolean[] visited){
        if(list.size() == nums.length){
            ans.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(visited[i]) continue;
            list.add(nums[i]);
            visited[i] = true;
            helper(ans, list, nums, visited);
            list.remove(list.size()-1);
            visited[i] = false;
        }
    }