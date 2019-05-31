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


//solution 2
class Solution {
    public int threeSumMulti(int[] A, int target) {
        int range = 100;
        //这个数组也要是long型，不然一直溢栈。。
        long[] count = new long[101];
        
        Arrays.sort(A);
        for(int cur : A) count[cur]++;
        
        long ans = 0;
        for(int i = 0; i < A.length - 2; i++) {
            int tmp = target - A[i];
            int low = i+1, high = A.length-1;
            while(low < high) {
                int cur = A[low] + A[high];
                if(cur == tmp) {
                    if(A[i] == A[low] && A[low] == A[high]) {
                        ans += count[A[i]] * (count[A[i]]-1) * (count[A[i]]-2) / 6;
                    }
                    else if(A[i] == A[low]) {
                        ans += count[A[high]] * count[A[low]] * (count[A[low]]-1)/2;
                    }else if(A[low] == A[high]) {
                        ans += count[A[i]] * count[A[low]] * (count[A[low]]-1)/2;  
                    }
                    else {
                        ans += count[A[i]] * count[A[low]] * count[A[high]];
                    }
                    while(low<high && A[low] == A[low+1]) low++;
                    while(low<high && A[high] == A[high-1]) high--;
                    low++;
                    high--;
                }else if(cur < tmp) {
                    while(low<high && A[low] == A[low+1]) low++;
                    low++;
                }else{
                    while(low<high && A[high] == A[high-1]) high--;
                    high--;
                }
            }
            while(i<A.length-3 && A[i] == A[i+1]) i++;
        }
        
        return (int)(ans % (1e9 + 7));
    }
}
