package leetcode;

import java.util.ArrayList;
import java.util.List;

public class BestTimetoBuyandSellStockII {
	//Peak and Valley
	public int maxProfit(int[] prices) {
	       if(prices.length == 0) return 0;
			int maxProfit = 0, valley = prices[0], peak = prices[0];
			int i = 0;
			while(i < prices.length-1) {
				while(i < prices.length-1 && prices[i] >= prices[i+1]) i++;
				valley = prices[i];
				while(i < prices.length-1 && prices[i] <= prices[i+1]) i++;
				peak = prices[i];
				maxProfit += peak - valley;
			}
			return maxProfit;		
		}
	
	//one time pass
	public static int maxProfit2(int[] prices) {
		int maxProfit = 0;
		for(int i = 1; i < prices.length; i++) {
			maxProfit += (prices[i] - prices[i-1]) < 0 ? 0 : prices[i] - prices[i-1];
		}
		return maxProfit;
		
	}

}
