package org.leetcode.problems.medium;

import org.junit.Test;

import javax.swing.text.Segment;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class ExamRoom2 {

    @Test
    public void test(){
        ExamRoom examRoom = new ExamRoom(10);

//        ["ExamRoom","seat","seat","seat","leave","leave","seat","seat","seat","seat","seat","seat","seat","seat","seat","leave",
//                "leave","seat","seat","leave","seat","leave","seat","leave","seat","leave","seat","leave","leave","seat","seat",
//                "leave","leave","seat","seat","leave"]
//[[10],[],[],[],[0],[4],[],[],[],[],[],[],[],[],[],[0],[4],[],[],[7],[],[3],[],[3],[],[9],[],[0],[8],[],[],[0],[8],[],[],[2]]

//[null,0,9,4,null,null,0,4,2,6,1,3,5,7,8,null,null,0,4,null,7,null,3,null,3,null,9,null,null,0,8,null,null,0,8,null]

        callSeat(3, examRoom);
        callLeave(0, examRoom);
        callLeave(4, examRoom);
        callSeat(9, examRoom);
        callLeave(0, examRoom);
        callLeave(4, examRoom);
        callSeat(2, examRoom);
        callLeave(7, examRoom);
        callSeat(1, examRoom);
        callLeave(3, examRoom);
        callSeat(1, examRoom);
        callLeave(3, examRoom);
        callSeat(1, examRoom);
        callLeave(9, examRoom);
        callSeat(1, examRoom);
        callLeave(0, examRoom);
        callLeave(8, examRoom);
        callSeat(2, examRoom);
        callLeave(0, examRoom);
        callLeave(8, examRoom);
        callSeat(2, examRoom);
        callLeave(2, examRoom);

    }

    public void callSeat(int n, ExamRoom examRoom){
        while (n>0){
            System.out.print(examRoom.seat() +  " , ");
            n--;
        }

    }

    public void callLeave(int position, ExamRoom examRoom){
        System.out.print(" null, ");
        examRoom.leave(position);
    }

    class ExamRoom{
        int N;
        TreeSet<Integer> treeSet = new TreeSet<>();

        public ExamRoom(int N) {
            this.N = N;
        }

        public int seat() {
            int position = 0;

            if(treeSet.isEmpty()){
                treeSet.add(position);
                return position;
            }

            //First Segment can between 0 --> First Set
            int nextOccupied = 0;
            int maxDistance = 0;
            if(treeSet.first() != 0){
                nextOccupied = treeSet.first();
                maxDistance = nextOccupied;
            }

            int prev = nextOccupied;
            for(Integer p: treeSet){
                int distance = (p - prev)/2;
                if(distance > maxDistance){
                   position = prev + distance;
                   maxDistance = distance;
                }
                prev = p;
            }

            //Last Segment
            if(treeSet.last() != N-1){
                int distance = N-1 - prev;
                if(distance > maxDistance){
                    position = N-1;
                }
            }
            treeSet.add(position);
            return position;
        }

        public void leave(int p) {
            treeSet.remove(p);
        }
    }
}
