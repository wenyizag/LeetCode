    public int maxProfit(int[] prices) {
        if(prices.length <= 1) return 0;
        int ans = 0, lowest = prices[0];
        //这个思路就是寻找一个最低点啊，而且nums[i]只用于之前的最低点比较，不用管后面更新了的值，所以是one pass
        for(int i = 1; i < prices.length; i++){
            if(prices[i] - lowest > ans) ans = prices[i] - lowest;
            if(prices[i] < lowest) lowest = prices[i];
        }
        return ans;
    }