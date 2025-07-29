package org.twoDArrays;

public class TwoDimArr {

    public static boolean canAttendMeetings(int[][] intervals) {
        for(int i=0; i<intervals.length; i++) {
            for(int j=i+1; j<intervals.length; j++) {
                if(overlap(intervals[i], intervals[j])) {
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
        int[][] arr = new int[4][5];
        int length = arr.length;
        System.out.println("Length of Rows: "+length);
        System.out.println("Length of Column: "+arr[3].length);

        int[][] data = new int[2][3];

        for(int i=0; i<data.length; i++) {
            for(int j=0; j<data[0].length; j++) {

            }
        }
        boolean result = TwoDimArr.canAttendMeetings(data);

    }
}
