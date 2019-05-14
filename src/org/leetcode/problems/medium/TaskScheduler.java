package org.leetcode.problems.medium;

import org.junit.Test;

import java.util.*;

public class TaskScheduler {


    @Test
    public void test(){
        char[] tasks = new char[] {'A','A','A','B','B','B'};
        int n = 50;
        System.out.println(leastInterval(tasks, n));
    }
    /*
    * 26 diff types of tasks max
    * n 0-100
    * tasks 1 - 10000
    * */
    public int leastInterval(char[] tasks, int n) {

        //priority queue of A num of occurences
        // pick A occurs 4 times. 3 places to fill atleast n
        int[] charMap = new int[26];
        for(char c : tasks){
            charMap[c-'A']++;
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(26, Collections.reverseOrder());
        for(int i: charMap){
            if(i>0)
                priorityQueue.add(i);
        }
        int cpuCycle = 0;

        while (!priorityQueue.isEmpty()){
            int session = 0;
            List<Integer> putBackList = new ArrayList<>();
            while (session <= n){
                if(!priorityQueue.isEmpty()){
                    if(priorityQueue.peek() > 1){
                        putBackList.add(priorityQueue.poll()-1);
                    } else {
                        priorityQueue.poll();
                    }
                }
                cpuCycle++;
                if(priorityQueue.isEmpty() && putBackList.isEmpty())
                    break;
                session++;

            }

            for(Integer i: putBackList){
                priorityQueue.add(i);
            }
        }
        return cpuCycle;
    }

    public int leastInterval1(char[] tasks, int n) {
        int[] map = new int[26];
        for (char c: tasks)
            map[c - 'A']++;
        PriorityQueue < Integer > queue = new PriorityQueue < > (26, Collections.reverseOrder());
        for (int f: map) {
            if (f > 0)
                queue.add(f);
        }
        int time = 0;
        while (!queue.isEmpty()) {
            int i = 0;
            List < Integer > temp = new ArrayList< >();
            while (i <= n) {
                if (!queue.isEmpty()) {
                    if (queue.peek() > 1)
                        temp.add(queue.poll() - 1);
                    else
                        queue.poll();
                }
                time++;
                if (queue.isEmpty() && temp.size() == 0)
                    break;
                i++;
            }
            for (int l: temp)
                queue.add(l);
        }
        return time;
    }
}
