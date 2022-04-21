package com.java.codes.GeeksCodes.meeting;

import java.util.*;

class Meeting {
    int start;
    int end;
    int pos;

    public Meeting(int start, int end, int pos) {
        this.start = start;
        this.end = end;
        this.pos = pos;
    }
}

class MyComparator implements Comparator<Meeting> {

    @Override
    public int compare(Meeting m1, Meeting m2) {
        if (m1.end < m2.end)
            return -1;
        else if (m1.end > m2.end)
            return 1;
        return 0;
    }
}

public class MaxMeetingOneRoom {
    public List<Integer> getMaxMeetingsDetails(List<Meeting> meetings) {
        List<Integer> posList = new ArrayList<>();
        MyComparator myComparator = new MyComparator();
        Collections.sort(meetings, myComparator);
        posList.add(meetings.get(0).pos);
        int endTime = meetings.get(0).end;
        for (int i = 1; i < meetings.size(); i++) {
            if (meetings.get(i).start > endTime) {
                posList.add(meetings.get(i).pos);
                endTime = meetings.get(i).end;
            }
        }
        return posList;
    }

    public static void main(String[] args) {
        MaxMeetingOneRoom maxMeetingOneRoom = new MaxMeetingOneRoom();
        List<Meeting> meetings = new ArrayList<>();
        meetings.add(new Meeting(1, 2, 0));
        meetings.add(new Meeting(3, 4, 1));
        meetings.add(new Meeting(0, 6, 2));
        meetings.add(new Meeting(5, 7, 3));
        meetings.add(new Meeting(8, 9, 4));
        meetings.add(new Meeting(5, 9, 5));
        List<Integer> maxMeetingsDetails = maxMeetingOneRoom.getMaxMeetingsDetails(meetings);
        for (Integer integer : maxMeetingsDetails) {
            System.out.println(integer);
        }
    }
}
/**
 * https://www.geeksforgeeks.org/find-farthest-node-from-each-node-in-tree/
 * https://www.geeksforgeeks.org/longest-path-undirected-tree/
 * https://www.geeksforgeeks.org/minimum-iterations-pass-information-nodes-tree/
 * https://www.geeksforgeeks.org/farthest-distance-of-a-node-from-each-node-of-a-tree/
 *
 * https://www.geeksforgeeks.org/diameter-n-ary-tree/
 */