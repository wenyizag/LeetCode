//这个思路其实特别好理解，简单一点的方法就是将数组数组排序，然后选择其中奇数位的相加
//所以最简单的就是用自带的Arrays.sort()，这种方法用时O(nlgn)

    public int arrayPairSum(int[] nums) {
        long ans = 0;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i+=2){
            ans+=nums[i];
        }
        return (int)ans;
    }

//如果不想用自带的sort，可以用将用自己写一个bucket sort
//建一个[20001]的bucket，将所有的数值都放在bucket里面
//从小到大遍历bucket，有一个boolean变量记录是奇数还是偶数位
//注意数值可能重复，所以bucket里面存的是该值有多少个
    public int arrayPairSum(int[] nums) {
        int[] sort = new int[20001];
        for(int i = 0; i < nums.length; i++) {
            sort[nums[i] + 10000]++;
        }
        int ans = 0;
        boolean odd = true;
        for(int i = 0; i < sort.length; i++) {
            while(sort[i] > 0) {
                if(odd) {
                    ans += (i-10000);
                }
                //这个sort--得写到if外面来啊。。因为无论是不是odd，这个sort都计数了
                sort[i]--;
                odd = !odd;
            }
        }
        return ans;
    }