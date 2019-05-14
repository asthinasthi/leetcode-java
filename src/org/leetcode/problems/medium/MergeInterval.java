package org.leetcode.problems.medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.List;
import java.util.Stack;

public class MergeInterval {

//    @Test
    public void test() {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(2, 6));
        intervals.add(new Interval(8, 10));
        intervals.add(new Interval(15, 18));

        List<Interval> results = merge(intervals);
        results.forEach(o -> System.out.println(o.start + " " + o.end));
    }

//    @Test
    public void test1() {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 4));
        intervals.add(new Interval(0, 0));

        List<Interval> results = merge(intervals);
        results.forEach(o -> System.out.println(o.start + " " + o.end));

    }

//    @Test
    public void test2() {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 4));
        intervals.add(new Interval(0, 5));

        List<Interval> results = merge(intervals);
        results.forEach(o -> System.out.println(o.start + " " + o.end));

    }

    @Test
    public void test3() {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(2,3));
        intervals.add(new Interval(4, 5));
        intervals.add(new Interval(6, 7));
        intervals.add(new Interval(8, 9));
        intervals.add(new Interval(1, 10));

        List<Interval> results = merge(intervals);
        results.forEach(o -> System.out.println(o.start + " " + o.end));

    }

    public List<Interval> merge(List<Interval> intervals) {
        if(intervals == null) return new ArrayList<>();
        if(intervals.size() == 0) return new ArrayList<>();

        intervals.sort((i1,i2)->(i1.end-i2.end));
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;

        List<Interval> mergedIntervals = new ArrayList<>();

        for(Interval currInterval: intervals){
            if(currInterval.start <= end){ //checks itself first time
                end = Math.max(end, currInterval.end);
            } else {
                mergedIntervals.add(new Interval(start, end)); //add the prev intervals. Like a delayed commit
                start = currInterval.start;
                end = currInterval.end;
            }
        }

        mergedIntervals.add(new Interval(start,end));
        return mergedIntervals;
    }

    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }
}
