//跟sort有关的题，要求O(nlogn)的话，只有两种排序，quickSort和Mergesort
    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k+1;
         // System.out.println(" low " + 0 + " high "+ (nums.length-1) + " k "+k);
        return findK(nums, 0, nums.length-1, k);
    }
    public int findK(int[] nums, int low, int high, int k){
        //注意这一句
        if(low >= high) return nums[high];
        
        //要分清楚pivot和rank的区别，pivot是在该段内的index，rank是该段内排多少名
        int pivot = partition(nums, low, high);
        int rank = pivot - low + 1;
        
        if(rank == k) return nums[pivot];
        else if(rank > k) return findK(nums, low, pivot-1, k);
        else return findK(nums, pivot+1, high, k-rank);  
    }
    
    public int partition(int[] nums, int low, int high){
        int pivot = nums[low], i = low+1, j = high;
        while(true){
            //注意这里我为什么用了<=, 因为测试数组的数有可能是duplicate的，
            //如果{3，3，3，3}，没有这个=情况去跳过，它就会一个一个处理，时间变成O(n^2)
            while(i < high && nums[i] <= pivot) i++;
            while(j > low && nums[j] > pivot) j--;
            if(i >= j) break;
            swap(nums, i, j);  
        }
        swap(nums, j, low);

        return j;
    }
    
    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

   //Solution 2
  //PQ也是解有关排序的很好的数据结构
      public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int num : nums){
            q.offer(num);
            if(q.size() > k){
              q.poll();  
            } 
        }
        return q.poll();
    }