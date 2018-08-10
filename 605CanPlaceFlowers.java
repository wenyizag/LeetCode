    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(n <= 0) return true;
        //为了提高速度多增加一个判断条件
        if(n > flowerbed.length) return false;
        
        Boolean left, right;
        for(int i = 0; i < flowerbed.length; i++){
            if(flowerbed[i] == 0){
                left = (i==0 || flowerbed[i-1]==0) ? true : false;
                right = (i==flowerbed.length-1 || flowerbed[i+1]==0) ? true : false;
                if(left && right) {
                    if(--n == 0) return true;
                    //一定要记得把i变为1啊
                    flowerbed[i] = 1;
                }
            }
        }
        return false;
    }