class Solution {
    public String reverseVowels(String s) {
        int left = 0, right = s.length() - 1;
        String vowels = "aeiouAEIOU";
        char[] c = s.toCharArray();
        while(left < right) {
            while(left < right && !vowels.contains(c[left] + "")) left++;
            while(left <= right && !vowels.contains(c[right] + "")) right--;
            if(left < right) {
                char tmp = c[left];
                c[left++] = c[right];
                c[right--] = tmp; 
            }
        }
        return String.valueOf(c);
    }
}