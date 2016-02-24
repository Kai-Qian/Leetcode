/*
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.

For example,
Given [[0, 30],[5, 10],[15, 20]],
return false.

Show Company Tags
Show Tags
Show Similar Problems

*/
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
	public boolean canAttendMeetings(Interval[] intervals) {
		if (intervals == null || intervals.length == 0)
			return true;
		Arrays.sort(intervals, new Comparator<Interval>() {
			public int compare(Interval i1, Interval i2) {
				return i1.start - i2.start;
			}
		});
		int end = intervals[0].end;
		// 检查每一个Interval
		for (int i = 1; i < intervals.length; i++) {
			// 如果Interval的开始时间小于之前最晚的结束时间，就返回假
			if (intervals[i].start < end)
				return false;
			end = intervals[i].end;
		}
		return true;
	}
}