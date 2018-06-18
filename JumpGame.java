package leetcode;

public class JumpGame {
	//Solution 1 
	 enum Judge{
			Good, Bad, Undefined
		}
		
		public static boolean canJump(int[] nums) {
			Judge[] memo = new Judge[nums.length];
			for(int i = 0; i < nums.length; i++) {
				memo[i] = Judge.Undefined;
			}
			
			memo[nums.length-1] = Judge.Good;
			
			for(int i = nums.length-2; i >= 0; i--) {
				int furthestJump = Math.min(nums[i] + i , nums.length-1);
				for(int j = i+1; j <= furthestJump; j++) {
					if(memo[j] == Judge.Good) {
						memo[i] = Judge.Good;
						break;
					}
				}
			}
			
	        return memo[0] == Judge.Good;
	    }
}
