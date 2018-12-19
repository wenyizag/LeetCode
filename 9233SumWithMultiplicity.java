    public int threeSumMulti(int[] A, int target) {
        int range = 100;
        //这个数组也要是long型，不然一直溢栈。。
        long[] count = new long[101];
        
        for(int cur : A) count[cur]++;
        
        long ans = 0;
        for(int i = 0; i <= 100; i++){
            for(int j = i; j <= 100; j++){
                int tmp = target - i - j;
                if(tmp < 0 || tmp < j || tmp > range) continue;
                if(count[tmp] == 0 || count[i] == 0 || count[j] == 0) continue;
                if(i == j && tmp == j){
                    ans += count[i] * (count[i]-1) * (count[i]-2) / 6;
                }else if(i == j){
                    ans += count[i] * (count[i]-1) * count[tmp] / 2;
                }else if(tmp == j){
                    ans += count[j] * (count[j]-1) * count[i] / 2;
                }else{
                    ans += count[i] * count[j] * count[tmp];
                }
            }
        }
        return (int)(ans % (1e9 + 7));
    }