class MyCalendar {
//solution 1
    TreeMap<Integer, Integer> calendar;
    public MyCalendar() {
        calendar = new TreeMap<>();
        
    }
    
    public boolean book(int start, int end) {
        Integer floor = calendar.floorKey(start);
        if(floor != null && calendar.get(floor) > start) return false;
        
        Integer ceil = calendar.higherKey(start);
        if(ceil != null && ceil < end) return false;
        
        calendar.put(start, end);
        return true;
        
    }
    
      
    //solution 2
        List<int[]> books;
    public MyCalendar() {
        books = new ArrayList<int[]>();
    }
    
    public boolean book(int start, int end) {
        for(int[]cur : books) {
            if(Math.max(start, cur[0]) < Math.min(end, cur[1])) return false;
        }
        books.add(new int[]{start, end});
        return true;
    }
}
