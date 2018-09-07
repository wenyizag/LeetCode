    public ListNode[] splitListToParts(ListNode root, int k) {
        
        int len = 0;
        for(ListNode node = root; node != null; node = node.next) len++;
        
        int groupLarge = len % k, group = k - groupLarge;
        int groupSize = len / k, groupLargeSize = groupSize+1;
        
        ListNode[] ans = new ListNode[k];
        ListNode node = root, pre = null;

        for(int i = 0; i < k; i++){
            ans[i] = node;
            int size = (i < groupLarge) ? groupLargeSize : groupSize;
            for(int j = 0; j < size; j++) {pre = node; node = node.next;}
            //这里为什么要多加一个 pre != null呢，是因为可能root是个空的啦，pre就没法变。
            if(pre != null) pre.next = null;
        }
        return ans;
    }