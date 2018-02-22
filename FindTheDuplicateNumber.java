package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class FindTheDuplicateNumber {
	//solution 1. Count the number of elements less or equal than [mid]
	//only for special input 
	public static int findDuplicate(int[] nums) {
		int low = 1;
		int high = nums.length-1;
		int mid, belowCount;
		while(low < high) {
			mid = low + (high - low)/2;
			belowCount = findCount(nums, mid);
			//A lethal bug!! 
			if(belowCount <= mid) low = mid + 1;
			else high = mid;
		}
		return low;
       
    }	
	//1, 2, 3, ... 10, 10, 10, 10,
	public static int findCount(int[] nums, int mid) {
		int count = 0;
		for(int i = 0 ; i < nums.length; i++) {
			if(nums[i] <= mid) count++;
		}
		return count;
	}
	
	
	//Solution 2. Floyd's tortoise and hare algorithm
	  public static int findDuplicate2(int[] nums) {
  		int fast = nums[0];
  		int slow = nums[0];
      
  		//detect a cycle
  		 do{
  			fast = nums[nums[fast]];
  			slow = nums[slow];
  		}while(fast != slow);
  		
  		//find the beginning of cycle
  		slow = nums[0];
  		while(fast != slow) {
  			fast = nums[fast];
  			slow = nums[slow];
  		}
  		
  		return slow;    	
  }
}
