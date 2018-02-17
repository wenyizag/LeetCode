package leetcode;

import java.util.HashSet;
import java.util.LinkedList;

public class ReverseString {
	//方法一
	public static String reverseString(String s) {
        char[] s2 = s.toCharArray();

        for(int i = s2.length-1, j = 0; i > j ; i--, j++) {
        		char tmp = s2[i];
        		s2[i] = s2[j];
        		s2[j] = tmp;
        }
        return new String(s2);
    }
	
	//方法二
	public static String reverseString2(String s) {
		StringBuilder s2 = new StringBuilder(s);
		return s2.reverse().toString();
	}
	
}
