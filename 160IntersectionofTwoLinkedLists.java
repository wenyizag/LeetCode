    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //思路是，先让两个list一样长，因为长出来的部分肯定不是相等的部分。所以先计算长度
        //但是计算长度的时候一定要新开两个指针，不然headA和headB就变成null了，没法进行接下来的操作。
        ListNode A = headA, B = headB;
        int lenA = 0, lenB = 0;
        while(A != null) {A = A.next; lenA++;}
        while(B != null) {B = B.next; lenB++;}
        
        if(lenA == 0 || lenB == 0) return null;
        
        while(lenA > lenB) {headA = headA.next; lenA--;}
        while(lenA < lenB) {headB = headB.next; lenB--;}
        
                
        while(headA !=null && headA != headB){headA = headA.next; headB = headB.next;}
        
        return headA;
    }