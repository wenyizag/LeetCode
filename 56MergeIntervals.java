    //Override写到函数外面比较方便清晰
    class IntervalComparator implements Comparator<Interval>{
        @Override
        public int compare(Interval o1, Interval o2) {
            return o1.start - o2.start;
        }	
    }
    
	public List<Interval> merge(List<Interval> intervals) {
        //如果是array的话就用Arrays.sort，如果是list就用collections.sort
		Collections.sort(intervals, new IntervalComparator());
		
		for(int i = 1; i < intervals.size(); i++) {
			if(intervals.get(i).start <= intervals.get(i-1).end) {
				intervals.get(i-1).end = Math.max(intervals.get(i).end, intervals.get(i-1).end);
				intervals.remove(i);
				i--;
			}
		}
		return intervals;
	}