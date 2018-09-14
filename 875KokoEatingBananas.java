    public int minEatingSpeed(int[] piles, int H) {
        if(piles.length == 0) return 0;
        
        int low = 1, high = Integer.MAX_VALUE;
        while(low < high){
            int speed = low + (high-low)/2;
            int hour = 0, carry = 0;
            for(int pile : piles){
                carry = (pile % speed == 0) ? 0 : 1;
                hour += (pile / speed) + carry;
            }
            //注意注意，这里为什么没有==情况，因为是求符合条件的最小值
            if(hour > H){
                low = speed + 1;
            }else{
                //因为去掉了==，所以high也不能等于speed-1了
                high = speed;
            }
        }
        return low;
    }