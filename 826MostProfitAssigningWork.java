//Solution 1
/* 
1. sort worker
2. sort difficulty pair
3. 线性扫描worker，获取与之对应的最大profit，difficulty是随着worker的skill的增长而增长，所以此步是O(n)时间
4. 总共时间复杂度o(nlogn)，因为排序
5. 需要注意的是，测试集中，difficulty可能有重复，对应不同profit，所以应该去重并选最大的那个
*/

    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        HashMap<Integer, Integer> skill = new HashMap<>();
        for(int i = 0; i < n; i++){
        	//为difficulty去重
            if(skill.containsKey(difficulty[i])) {
                skill.put(difficulty[i], Math.max(profit[i], skill.get(difficulty[i])));
            }
            else {
                skill.put(difficulty[i], profit[i]);   
            }
        }
        Arrays.sort(worker);
        Arrays.sort(difficulty);
        int best = 0, j = 0, ans = 0;
        for(int w : worker){
            while(j < n && w >= difficulty[j]){
                best = Math.max(best, skill.get(difficulty[j++]));
            }
            ans += best;
        }
        return ans;


//对solution 1进行小小的优化，自己定义了一个pair class，这样比hashmap快，省事的话用int[][]也差不多
class Solution {
    class Pair{
        int d;
        int p;
        public Pair(int d, int p){
            this.d = d;
            this.p = p;
        }
    }
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        List<Pair> skill = new ArrayList<>();
        for(int i = 0; i < n; i++){
            skill.add(new Pair(difficulty[i], profit[i]));
        }
        Arrays.sort(worker);
        Collections.sort(skill, new Comparator<Pair>(){
            public int compare(Pair a, Pair b){
                return a.d == b.d ? a.p - b.p : a.d- b.d;
            }
        });
        int best = 0, j = 0, ans = 0;
        for(int w : worker){
            while(j < n && w >= skill.get(j).d){
                best = Math.max(best, skill.get(j++).p);
            }
            ans += best;
        }
        return ans;
    }
}

//solution 2. bucket sort
/* 
非常非常快，利用了difficulty长度不超过10^5 的特点，预先设定一个skill数组，将对应的difficulty和最大的profit从0到100000一个个填进去
*/

class Solution {

    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        int[] dp = new int[100001];
        for(int i = 0; i < n; i++){
            dp[difficulty[i]] = Math.max(dp[difficulty[i]], profit[i]);
        }
        
        for(int i = 1; i < dp.length; i++) 
            dp[i] = Math.max(dp[i-1], dp[i]);
        
        int ans = 0;
        for(int w : worker) {
            ans += dp[w];
        }
        
        return ans;
    }
}