		public int compare(Interval o1, Interval o2) {
			return o1.start < o2.start ? -1 : o1.start == o2.start ? 0 : 1;
		}	
	}
	public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new sortIntervals());
        
        LinkedList<Interval> merged = new LinkedList<Interval>();
        for(Interval o1 : intervals) {
        		if(merged.isEmpty() || merged.getLast().end < o1.start) merged.add(o1);
        		else {
        			merged.getLast().end = Math.max(merged.getLast().end, o1.end);
        		}
        }
        return merged;
    }