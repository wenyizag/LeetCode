package leetcode;

import java.util.HashSet;
import java.util.LinkedList;

public class ReverseWordsInAStringII {
	public static char[] reverseWords(char[] str) {
		int len = str.length;
		reverse(str, 0, len-1);
		
		int start = 0, end = 0;
		while(end < len ) {
			if(str[end] == ' ') {
				reverse(str, start, end-1);
				start = end+1;
			}
			end++;
		}		
	    reverse(str, start, len-1);       
	    return str;
    }
	
	public static void reverse(char[] str, int start, int end) {		
		char tmp = 0;
		while(start < end) {
			tmp = str[start];
			str[start] = str[end];
			str[end] = tmp;
			start++;
			end--;
		}
	
}
