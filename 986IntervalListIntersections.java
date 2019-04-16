class Solution {
    public Interval[] intervalIntersection(Interval[] A, Interval[] B) {
        List<Interval> tmpAns = new ArrayList<>();
        
        int i = 0, j = 0;
        while(i < A.length && j < B.length) {
            int start = Math.max(A[i].start, B[j].start);
            int end = Math.min(A[i].end, B[j].end);
            
            if(start <= end) {
                tmpAns.add(new Interval(start, end));
            }
            if(A[i].end < B[j].end) i++;
            else j++;
        }
        
        //我原来的写法
        // Interval[] ans = new Interval[tmpAns.size()];
        // return tmpAns.toArray(ans);
        
        //改进
        return tmpAns.toArray(new Interval[0]);
    }
}