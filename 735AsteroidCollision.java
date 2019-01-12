
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> s = new Stack<>();
        for(int i = 0; i < asteroids.length; i++) {
            if(asteroids[i] > 0 || s.isEmpty() || s.peek() < 0)
                s.push(asteroids[i]);
            else if(s.peek() < Math.abs(asteroids[i])) {
                s.pop();
                i--;
            }else if(s.peek() == Math.abs(asteroids[i])) {
                s.pop();
            }
        }
        int[] ans = new int[s.size()];
        for(int i = ans.length - 1; i >= 0; i--)
            ans[i] = s.pop();
        
        return ans;
    }
}