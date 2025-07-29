package org.twoDArrays;

public class MeetingRoom {
    public static boolean canAttendMeetings(int[][] intervals) {
        for (int i = 0; i < intervals.length; i++) {
            for (int j = i + 1; j < intervals.length; j++) {
                if (overlap(intervals[i], intervals[j])) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean overlap(int[] interval1, int[] interval2) {
        return (interval1[0] >= interval2[0] && interval1[0] < interval2[1])
                || (interval2[0] >= interval1[0] && interval2[0] < interval1[1]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{0,30}, {5,10}, {15,20}};
        canAttendMeetings(intervals);
    }
}


