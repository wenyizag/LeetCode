package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class LongestPalindromicSubstring {
	public static String longestPalindrome(String s) {
		int left = -1, right = -1;
		int maxLen = 0;
		for(int i = 0; i < s.length(); i++) {
			int oddlen = expandFromCenter(s, i, i);
			int evenlen = expandFromCenter(s, i, i+1);
			int max = Math.max(oddlen, evenlen);
			if(max > maxLen) {
				maxLen = max;
				left = i- (maxLen-1)/2;
				right = i + maxLen/2;
			}
		}
		return s.substring(left, right+1);
	}
	
	//return the length
	//odd expand from 2, [120], len = 1, and left = 0, right = 2, length = right - left - 1;
	//even expand from 2, [120], len = 0;
	//odd expand from 2, [1220], len = 1;
	//even expand from 2, [1220], and right = 3, left = 0, length = right - left - 1;
	public static int expandFromCenter(String s, int left, int right) {
		while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}
		return right - left - 1;
	}
}
