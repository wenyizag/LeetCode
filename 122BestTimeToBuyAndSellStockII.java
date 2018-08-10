//两种方法都不难，不多解释

//Solution 1

    public int maxProfit(int[] prices) {
        //这个傻瓜方法是跟前一天比，但凡有涨就加入到ans
        int ans = 0;
        for(int i = 1; i < prices.length; i++){
            if(prices[i] - prices[i-1] > 0) ans += (prices[i]-prices[i-1]);
        }
        return ans;
    }

//Solution 2. Valley && Peak

    public int maxProfit(int[] prices) {
        int ans = 0, valley, peak;
        
        for(int i = 0; i < prices.length; i++){
            //注意判断边界条件的要放在前面啊，不然还是炸了
            while(i<prices.length-1 && prices[i] > prices[i+1] ) i++;
            valley = prices[i];
            while(i<prices.length-1 && prices[i] < prices[i+1] ) i++;
            peak = prices[i];
            ans += (peak - valley);
        } 
        return ans;
    }