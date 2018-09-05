    // 两个相同的数异或后为0；
    // 0和一个数异或后为那个数；
    // 异或运算满足交换律。
    public int singleNumber(int[] nums) {
        int ans = 0;
        for(int cur : nums){
            ans ^= cur;
        }
        return ans;
    }