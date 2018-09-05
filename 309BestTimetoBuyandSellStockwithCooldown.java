    public int maxProfit(int[] prices) {
        //详情思路参考花花油管，讲得非常好
        int hold = Integer.MIN_VALUE, sold = 0, rest = 0;
        for(int price : prices){
            //这里要使用一个tmp变量记录上一次的值
            int pre_sold = sold;
            sold = hold + price;
            hold = Math.max(hold, rest - price);
            rest = Math.max(rest, pre_sold);
        }
        return Math.max(sold, rest);
    }