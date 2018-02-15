package leetcode;

import java.util.HashSet;
import java.util.LinkedList;

public class DecodeWays {
	public static int numDecodings(String s) {
		int n = s.length();
		if(n==0) return 0;
		int[] dp = new int[n+1];
		dp[0] = 1;
		dp[1] = (s.charAt(0) == '0') ? 0 : 1;
		for(int i = 2; i <= n; i++) {
			int n1 = Integer.valueOf(s.substring(i-2, i));
			int n2 = Integer.valueOf(s.substring(i-1, i));
			if(n2 >=1 && n2 <= 9) dp[i] += dp[i-1];
			if(n1 >=10 && n1 <= 26) dp[i] += dp[i-2];
		}
		return dp[n];
	}
}
