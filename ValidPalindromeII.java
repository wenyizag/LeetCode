package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ValidPalindromeII {
	public static boolean validPalindrome(String s) {
		for(int i = 0, j = s.length() - 1; i < j; i++,j--) {
			if(s.charAt(i) != s.charAt(j)) return isPalindrome(s, i, j-1) || isPalindrome(s,i+1,j);
		}
		return true;		
    }
	
	public static boolean isPalindrome(String s, int start, int end) {		
		while(start<end) {
			if(s.charAt(start) != s.charAt(end)) return false;
			start++;
			end--;
		}
		return true;
	}
}
