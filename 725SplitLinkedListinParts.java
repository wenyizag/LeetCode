class Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {
        int len = 0;
        for(ListNode head = root; head != null; head = head.next, len++);
        
        int large = len % k;
        int small = len / k;
        
        ListNode pre = null;
        ListNode[] ans = new ListNode[k];
        for(int i = 0; i < k; i++, large--) {
            ans[i] = root;
            for(int j = 0 ; j < small + (large > 0 ? 1 : 0); j++) {
                pre = root;
                root = root.next;
            }
            if(pre != null) pre.next = null;
        }
        
        return ans;
    }
}