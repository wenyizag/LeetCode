package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PalindromicSubstrings {
	//expend from center
	private static int ans;
	 public static int countSubstrings(String s) {
		 if(s.length()==0) return 0;
		 
	     for(int i = 0; i < s.length(); i++) {
	        	palindromic(i, i, s); //even
	        	palindromic(i, i+1, s); //odd
	     }	     
	     return ans;
	 }
	 public static void palindromic(int left, int right, String s) {
		 while(left >= 0 && right < s.length()
				 && s.charAt(left)==s.charAt(right)) {
			 ans++;
			 left--;
			 right++;
		 }
	 }
	
	
}
