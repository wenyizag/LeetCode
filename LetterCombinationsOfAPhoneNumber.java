package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class LetterCombinationsOfAPhoneNumber {
	
	//recursion
	private String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
	 
	 public List<String> letterCombinations(String digits) {
		 List<String> ans = new LinkedList<>();
       if(digits.length() == 0) return ans;
		 backTracking("", digits, 0, ans);
		 return ans;
	 }
	 public void backTracking(String prefix, String digits, int index, List<String> ans){
		 if(index >= digits.length()) {
			 ans.add(prefix);
			 return;
		 }
		 String curChar = map[digits.charAt(index) - '0'];
		 for(int i = 0; i < curChar.length(); i++) {
			  backTracking(prefix + curChar.charAt(i), digits, index+1, ans);
		 }
	 }
}
