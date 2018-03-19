package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class MajorityElement {
	
	//HashMap
	public static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int length = nums.length;
        for(int i = 0; i < length; i++){
        		//System.out.println(" 1 : " + map.get(nums[i]));
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            System.out.println(map.get(nums[i]));
            if(map.get(nums[i]) > length / 2) return nums[i];                   
        }
        return 0;
    }
	
	//Boyer Moore's Algorithm
	public static int majorityElement2(int[] nums) {
	       int count = 0;
	       int candidate = 0;
	       for(int i = 0; i < nums.length; i++) {
	    	   		if(count == 0) {
	    	   			candidate = nums[i];
	    	   			count++;
	    	   		}
	    	   		else {
	    	   			if(nums[i] == candidate)
	        	   			count++;
	    	   			else count--;
	    	   		}    	   		
	       }
	       return candidate;
	    }
}
