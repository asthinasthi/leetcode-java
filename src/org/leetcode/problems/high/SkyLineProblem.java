package org.leetcode.problems.high;

import com.sun.org.apache.regexp.internal.RE;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.junit.Test;


public class SkyLineProblem {

    @Test
    public void test(){
//        int[][] buildings = new int[][]{ {2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8} } ;
//        int[][] buildings = new int[][]{ {0, 2, 3}, {2, 5, 3} } ;
//        int[][] buildings = new int[][]{ {1,2,1}, {1,2,2}, {1,2,3} } ;
//        int[][] buildings = new int[][]{ {0,3,3}, {1,5,3}, {2,4,3}, {3,7,3} } ;
//        int[][] buildings = new int[][]{ {2,4,7}, {2,4,5}, {2,4,6} } ;
//        int[][] buildings = new int[][]{ {4,10,10}, {5,10,9}, {6,10,8}, {7,10,7}, {8,10,6}, {9,10,5} } ;
//        int[][] buildings = new int[][]{ {2,9,10}, {3,7,15}, {5,12,12}, {15,20,10}, {19,24,8}} ;
//        int[][] buildings = new int[][]{ {2,13,10}, {10,17,25}, {12,20,14}} ;
//        int[][] buildings = new int[][]{};
//        int[][] buildings = new int[][]{{1,2,1},{1,2,2},{1,2,3}};
        int[][] buildings = new int[][]{{2,4,7},{2,4,5},{2,4,6}};
        List<int[]> results = getSkyline(buildings);
        printResults(results);
    }

    public List<int[]> getSkyline(int[][] buildings) {
        if(buildings.length == 0)
            return new ArrayList<>();
        // Merge sort
        return mergeSort(0, buildings.length-1, buildings);
    }

    public List<int[]> makeAtomicSkyLine(int[][] buildings){
        List<int[]> result = new ArrayList<>();
        for(int i=0; i<buildings.length; i++){
            result.add(new int[]{buildings[i][0], buildings[i][2]});
            result.add(new int[]{buildings[i][1], 0});
        }
        return result;
    }

    public List<int[]> mergeSort(int l, int r, int[][] buildings){
        List<int[]> skyLine = new ArrayList<>();
        if(l == r){
            skyLine.add(new int[]{buildings[l][0], buildings[l][2]});
            skyLine.add(new int[]{buildings[l][1], 0});
            return skyLine;
        } else {
            List<int[]> leftSkyLine = mergeSort(l, (l+r)/2, buildings);
            List<int[]> rightSkyLine = mergeSort((l+r)/2+1, r, buildings);

            int h1 = 0;
            int h2 = 0;
            int left = 0;
            int right = 0;
            while (left < leftSkyLine.size() && right < rightSkyLine.size()){
                int leftX = leftSkyLine.get(left)[0];
                int leftY = leftSkyLine.get(left)[1];

                int rightX = rightSkyLine.get(right)[0];
                int rightY = rightSkyLine.get(right)[1];

                if(leftX < rightX){
                    h1 = leftY;
                    int maxH = Math.max(h1, h2);
                    append(leftX, maxH, skyLine, left == leftSkyLine.size()-1);
                    left++;
                } else {
                    h2 = rightY;
                    int maxH = Math.max(h1, h2);
                    append(rightX, maxH, skyLine, right == rightSkyLine.size()-1);
                    right++;
                }
            }
            while (left < leftSkyLine.size()){
                append(leftSkyLine.get(left)[0], leftSkyLine.get(left)[1], skyLine, left == leftSkyLine.size()-1);
                left++;
            }

            while (right < rightSkyLine.size()){
                append(rightSkyLine.get(right)[0], rightSkyLine.get(right)[1], skyLine, right == rightSkyLine.size()-1);
                right++;
            }
        }
        return skyLine;
    }

    public void append(int x, int maxH, List<int[]> skyLine, boolean lastIndex){
        if(skyLine.size()>0){
            int prevY = skyLine.get(skyLine.size()-1)[1];
             if(maxH == prevY)
                 return;

             int prevX = skyLine.get(skyLine.size()-1)[0];
             if(prevX == x){ //blind append ?
                 int[] lastEntry = skyLine.get(skyLine.size()-1);
                 skyLine.remove(lastEntry);
                 if(!lastIndex)
                    lastEntry[1] = Math.max(lastEntry[1], maxH);
                 else
                     lastEntry[1] = 0;
                 skyLine.add(lastEntry);
                 return;
             }
        }
            skyLine.add(new int[]{x, maxH});
    }

    public void printResults(List<int[]> results){
        for(int[] r: results){
            System.out.println(r[0] + " " + r[1]);
        }
    }

}
