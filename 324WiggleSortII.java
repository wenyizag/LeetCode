    
//Solution1
    public void wiggleSort(int[] nums) {
		//这个思路是这样的，首先先把数组sort了，然后用到了一个辅助数组
       Arrays.sort(nums);
       int mid = (nums.length-1)/2;
       int last = nums.length-1;
       int[] array = new int[nums.length];
       //将sort后的数组由mid点分成两半部分，0,1,2,3...mid....last
       //这个时候我们将对应的mid，last, mid-1, last-1....mid+1, 0这样穿插起来放
       //last部分的肯定比夹着它的两个mid大，同理mid也比夹着它的两个last小，由此实现wiggle
        
        //还有一个要点是为什么要从mid和last取呢，而不从head和mid取呢，
        //以数组{4，5，5，6}举例，假如我们以head和mid这样交替安放，结果还是{4，5，5，6}
        //但是以mid和last交替安放，就变成符合要求的{5，6，4，5}
        //原因是因为聚集在中位的有些数字是重复的，我们把它放在一头一尾分隔越开越好。所以以mid放在0位不出错。
       for(int i = 0; i < nums.length; i++) {
    	   	 //判断为奇数
    	   	 if((i&1) == 0) {
    	   		 array[i] = nums[mid--];
    	   	 }else {
    	   		 array[i] = nums[last--];
    	   	 }
       }
       for(int i = 0; i<nums.length; i++)
    	   		nums[i] = array[i];
    	   	
    }

//Solution 2
    //我真滴是疯辽，这道quick sort我一直错一直错的原因还是index和kth分不清楚啊。。。。。
    
		 int len = nums.length, mid = (len+1)/2;
		 int middle = findk(nums, 0, len-1, mid);
		 //System.out.println("middle "+middle);
		 //开了一个辅助数组, 把小于middle的存在左边，大于middle的存在右边
		 int[] tmp = new int[nums.length];
		 int low = 0, high = len-1;
		 for(int i = 0; i < len; i++) {
			 if(nums[i] > middle)
				 tmp[high--] = nums[i];
			 else if(nums[i] < middle)
			 	 tmp[low++] = nums[i];
		 }
				 
		 //中间还有些空的，说明都是等于middle的
		while(low <= high)
			 tmp[low++] = middle;
		
		for(int i = 0; i< nums.length; i++) {
			 System.out.print(tmp[i]+" ");
		 }
		System.out.println(" ");
		 for(int i = 0; i < nums.length; i++) {
			 nums[i] = ((i&1) == 0) ? tmp[--mid] : tmp[--len];
			 System.out.print(nums[i]+" "); 
		 }		 
	 }
	 public static int findk(int[] nums, int low, int high, int k) {
		 if(low >= high) {
			 //System.out.println("nums[high] "+nums[high]);
			 return nums[high];
		 }
			
		 //通过partition选出来的第i位		 
		 int i = partition(nums, low, high);
		 int cur = i-low+1;
		 if(cur == k) {
			// System.out.println("nums[i] "+nums[i]);
			 return nums[i];
		 }
		 return (cur>k) ? findk(nums, low, i-1, k) : findk(nums, i+1, high, k-cur);
	 }
	 
	 public static int partition(int[] nums, int low, int high) {
		 //随机选一个作为比较，如果用random会更好
		 int val = nums[low];
		 //注意j用high+1比较方便
		 int i = low, j = high+1;
		 while(true) {
			 while(++i < high && nums[i] < val);
			 while(--j > low && nums[j] > val);
			 //如果两数相遇就直接break了，因为外层循环是没有break条件的
			 if(i >= j) break;
			 swap(nums, i, j);
		 }
		 //最后要记得把nums[low]换到中间，因为它是比较的标杆
		 swap(nums, low, j);
		 //返回了标杆是处于第几位
		 return j;
	 }
    public static void swap(int[] nums, int i, int j) {
		 int tmp = nums[i];
		 nums[i] = nums[j];
		 nums[j] = tmp;
	 }