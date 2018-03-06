package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import leetcode2.Comparator;
import leetcode2.Interval;

public class MeetingRoomsII {
	public int minMeetingRooms(Interval[] intervals) {
        if(intervals.length == 0) return 0;
        Arrays.sort(intervals, new Comparator<Interval>() {
        		public int compare(Interval a, Interval b) {
        			return a.start - b.start;
        		}
        });
        PriorityQueue<Interval> heap = new PriorityQueue(intervals.length, new Comparator<Interval>(){
        		public int compare(Interval a, Interval b) {return a.end - b.end;}
        });
        heap.offer(intervals[0]);
        for(int i = 1; i < intervals.length; i++) {
        		Interval curMin = heap.poll();
        		if(curMin.end <= intervals[i].start) {
        			curMin.end = intervals[i].end;
        		}else {
        			heap.add(intervals[i]);
        		}
        		heap.offer(curMin);
        }
        return heap.size();       
    }
}
