package leetcode;

import java.util.ArrayList;
import java.util.List;

public class BestTimetoBuyandSellStock {
	//finding the maximum and minimum peak
	public static int maxProfit(int[] prices) {
		if(prices.length == 0) return 0;
        
		int maxProfit = 0, minPrice = prices[0];
		for(int i = 1; i < prices.length; i++) {
			if(prices[i] > minPrice) {
				maxProfit = Math.max(maxProfit, prices[i]-minPrice);
			}
			else
				minPrice = prices[i];
		}
		return maxProfit;
	}
	
	//Price difference prices[i]-prices[i-1]
	public static int maxProfit2(int[] prices) {
        int curProfit = 0, maxProfit = 0;
        for(int i = 1; i < prices.length; i++) {
        		curProfit = Math.max(0, curProfit + prices[i] - prices[i-1]);
        		maxProfit = Math.max(curProfit, maxProfit);
        }
        return maxProfit;
        
    }

}
