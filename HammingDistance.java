package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class HammingDistance {
	public int hammingDistance(int x, int y) {
        int res = x^y;
        int count = 0;
        while(res > 0) {
        		if(res%2 == 0) {
        			count++;
        		}
        		res = res>>1;
        }
        return count;
    }
}
