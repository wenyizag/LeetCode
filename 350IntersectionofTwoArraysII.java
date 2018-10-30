    //solution 1.这种是排好序的
    public int[] intersect(int[] nums1, int[] nums2) {
        int l1 = nums1.length, l2 = nums2.length;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i1 = 0, i2 = 0, i3 = 0;
        int[] tmp = new int[l1];
        while(i1 < l1 && i2 < l2){
            if(nums1[i1] == nums2[i2]){
                tmp[i3++] = nums1[i1];
                i1++;
                i2++;
            }else if(nums1[i1] > nums2[i2]){
                i2++;
            }else{
                i1++;
            }
        }
        int[] ans = Arrays.copyOf(tmp, i3);
        return ans;
    }

    //solution 2. HashMap
        public int[] intersect(int[] nums1, int[] nums2) {
        int l1 = nums1.length, l2 = nums2.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int cur : nums1){
            map.put(cur, map.getOrDefault(cur, 0)+1);
        }
        int i = 0;
        for(int cur : nums2){
            if(map.containsKey(cur) && map.get(cur) > 0){
                nums1[i] = cur;
                i++;
                map.put(cur, map.get(cur)-1);
            }
        }
        int[] ans = new int[i];
        for(int j = 0; j < i; j++){
            ans[j] = nums1[j];
        }
        return ans;
    }