class MyCalendar {

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
}