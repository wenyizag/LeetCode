class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        int[] row = new int[size+1];
        Arrays.fill(row, Integer.MAX_VALUE);      
        
        for(int i = 1; i <= size; i++) {
            List<Integer> curRow = triangle.get(i-1);
            int[] tmp = new int[size+1];
            for(int j = 1; j <= i; j++) {
                if(i == 1 && j == 1) {
                    tmp[j] = curRow.get(j-1);
                }else if(j == 1) {
                    tmp[j] = row[j] + curRow.get(j-1);
                }else if(j == i) {
                    tmp[j] = row[j-1] + curRow.get(j-1);
                }else {
                    tmp[j] = Math.min(row[j-1], row[j]) + curRow.get(j-1);
                }
            }
            row = tmp;  
        }
         
    
        int ans = row[1];
        for(int i = 1; i <= size; i++) {
            ans = Math.min(ans, row[i]);
        }
        return ans;
    }
}