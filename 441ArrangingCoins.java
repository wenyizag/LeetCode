    public int arrangeCoins(int n) {
        if(n <= 1) return n;
        long low = 1, high = n, mid, sum;
        while(low <= high){
            mid = low + (high-low)/2;
            sum = (mid+1)*mid/2;
            
            //<=的时候都是mid+1，这是因为我们最后的答案是low-1
            if(sum <= n) low = mid + 1;
            else high = mid-1;
        }
        return (int)low-1; 
    }