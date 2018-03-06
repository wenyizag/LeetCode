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

public class MeetingRooms {
	public boolean canAttendMeetings(Interval[] intervals) {
        if(intervals == null) return false;
        Arrays.sort(intervals, new Comparator<Interval>() {
        		public int compare(Interval a, Interval b) {
        			return a.start - b.start;
        		}
        });
        for(int i = 1; i < intervals.length; i++) {
        		if(intervals[i].start < intervals[i-1].end) return false;
        }
        return true;
    }
}
