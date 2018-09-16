    public char nextGreatestLetter(char[] letters, char target) {
        int low = 0, high = letters.length-1, mid, len = letters.length-1;
        while(low < high){
            mid = low + (high-low)/2;
            if(letters[mid] <= target){
                low = mid+1;
            }else{
                high = mid;
            }
        }
        if(letters[low] <= target) low = 0;
        return letters[low];
    }