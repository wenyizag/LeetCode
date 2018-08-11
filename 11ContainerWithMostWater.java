    //两头比较法
    public int maxArea(int[] height) {
    		int left = 0, right = height.length-1;
    		int ans = 0, area;
    		while(left < right) {
    			area = (right - left) * Math.min(height[right], height[left]);
    			if(area > ans) ans = area;
    			if(height[right] < height[left]) {
    				right--;
    			}else {
    				left++;
    			}
    		}
    		return ans;
    }