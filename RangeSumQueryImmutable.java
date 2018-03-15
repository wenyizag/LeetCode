package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class RangeSumQueryImmutable {

	private int[] sum;
    public NumArray(int[] nums) {
        sum = new int[nums.length + 1]; //sum[0] = 0
        for(int i = 1; i <= nums.length; i++) {
        		sum[i] = sum[i-1] + nums[i-1];
        }
    }
    
    public int sumRange(int i, int j) {
        return sum[j+1] - sum[i];
    }
}
