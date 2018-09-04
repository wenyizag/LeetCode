    public int countPrimes(int n) {
        //思路是，如果一个数i是prime，那么它的倍数一定不是prime，所以把n以内的所有i的倍数改为not prime
        boolean[] nums = new boolean[n+1];
        int count = 0;
        for(int i = 2; i < n; i++){
            //表明不是prime
            if(nums[i]) continue;
            count++;
            for(int j = 2; j*i <= n; j++){
                // System.out.println(j);
                nums[j*i] = true;
            }
        }
        return count;
    }
