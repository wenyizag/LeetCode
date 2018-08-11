    public List<Integer> findDuplicates(int[] nums) {
        //这个题的难点在于no extra space和o(n)
        //但它有一个特点是所有的值 1<= nums[i] <= n
        //思路是利于正负性来记录是否重复，例如当出现一个数nums[i]=4后，我们index = 4-1的数变成负数
        //如果再次出现4，然后我们发现index=3的数已经是负了，那证明已经出现过了，加入list
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            int x = Math.abs(nums[i]) - 1;
            if(nums[x] < 0) ans.add(x+1);
            nums[x] = -nums[x];
        }
        return ans;
    }