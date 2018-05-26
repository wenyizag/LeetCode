package leetcode;

public class UniqueBinarySearchTrees {
	public static int numTrees(int n) {
        int[] store = new int[n+1];
        store[0] = store[1] = 1;
        
        for(int i = 2; i<=n; i++) {
        		for(int j=0; j<i; j++)
        			store[i] += store[j]*store[i-j-1];
        }
        
        return store[n];
    }
}
