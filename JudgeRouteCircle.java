package leetcode;

public class JudgeRouteCircle {
	 public boolean judgeCircle(String moves) {
	        int a = 0, b = 0;
	        for(char c : moves.toCharArray()){
	            if(c == 'U') a--;
	            else if(c == 'D') a++;
	            else if(c == 'L') b--;
	            else b++;
	        }
	        return a==0 && b==0;
	    }
}
