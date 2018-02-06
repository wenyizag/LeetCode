package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ValidPalindrome {
	//方法一
	 public static boolean isPalindrome1(String s) {		 
		 int i = 0, j = s.length()-1;
		 while(i<=j) {
			 if(!Character.isLetterOrDigit(s.charAt(i))){
				 System.out.println("skit i");
				 i++;
				 continue;
			 }
			 if(!Character.isLetterOrDigit(s.charAt(j))){
				 j--;
				 continue;
			 }
			 if(Character.toLowerCase(s.charAt(i))!=Character.toLowerCase(s.charAt(j))) {
				 return false;
			 }
			 else {
				 i++;
				 j--;
			 }
		 }
		 return true;	        
	 } 
	 
	 //方法二
	 public static boolean isPalindrome2(String s) {
		 String actual = s.replaceAll("[^0-9a-zA-Z]", "");
		 StringBuilder re = new StringBuilder(actual);
		 return actual.equalsIgnoreCase(re.reverse().toString());
	 }
}
