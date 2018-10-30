    public boolean find132pattern(int[] nums) {
        //find the smallest num before index i (13 pattern)
        if(nums.length <= 2) return false;
        int[] mins = new int[nums.length];
        int min = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i] < min){
                min = nums[i];
            }
            mins[i] = min;
        }
        //using a stack, scan the array from right to left
        //once the index is larger than it's corresponding min one (13 pattern)
        //retrive numbers from the stack to find the 132 pattern
        Stack<Integer> s = new Stack<>();
        for(int i = nums.length - 1; i > 0; i--){
            if(nums[i] == mins[i]) continue;
            while(!s.isEmpty() && s.peek() < nums[i]){
               if(s.pop() > mins[i]) return true;
            }
            s.push(nums[i]);
        }
        return false;
    }