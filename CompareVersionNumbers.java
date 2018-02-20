package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class CompareVersionNumbers {
	public static int compareVersion(String version1, String version2) {
		String[] l1 = version1.split("\\.");
		String[] l2 = version2.split("\\.");
		int len = Math.max(l1.length, l2.length);
		for(int i = 0; i < len; i++) {
			int num1 = (i < l1.length) ? Integer.parseInt(l1[i]):0;
			int num2 = (i < l2.length) ? Integer.parseInt(l2[i]):0;
			if(num1 > num2) return 1;
			if(num1 < num2) return -1;
		}
		return 0;
 	}
}
