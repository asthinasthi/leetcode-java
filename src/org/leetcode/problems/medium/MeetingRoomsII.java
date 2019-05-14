package org.leetcode.problems.medium;

import org.junit.Test;
import sun.jvm.hotspot.utilities.Interval;

import java.util.*;

public class MeetingRoomsII {

    @Test
    public void test(){
        Interval[] intervals = new Interval[]{new Interval(0,30),new Interval(5,10),new Interval(15,20)};
//        Interval[] intervals = new Interval[]{new Interval(7,10),new Interval(2,4)};
//        Interval[] intervals = new Interval[]{new Interval(5,8),new Interval(6,8)};[[15,16],[10,15],[16,25]]
//        Interval[] intervals = new Interval[]{new Interval(15,16), new Interval(10,15), new Interval(16,25)};
        System.out.println(minMeetingRooms(intervals));
    }

    public int minMeetingRooms(Interval[] intervals) {
        if(intervals == null || intervals.length == 0) return 0;

        List<Interval> sortedBegins = new ArrayList<>();
        sortedBegins.addAll(Arrays.asList(intervals));
        Collections.sort(sortedBegins, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return (o1.start - o2.start);
            }
        });

        PriorityQueue<Interval> roomIntervals = new PriorityQueue<>(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.end - o2.end;
            }
        });
        roomIntervals.add(sortedBegins.get(0));
        for(int i=1; i<sortedBegins.size(); i++){
            Interval interval = roomIntervals.poll();
            if(sortedBegins.get(i).start >= interval.end){
                interval.end = sortedBegins.get(i).end;
            } else {
                roomIntervals.add(sortedBegins.get(i));
            }
            roomIntervals.add(interval);
        }

        return roomIntervals.size();
    }

    class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
  }
}
