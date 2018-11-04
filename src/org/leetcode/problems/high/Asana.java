package org.leetcode.problems.high;

import org.junit.Test;

public class Asana {

    @Test
    public void test(){

        System.out.println(getCarrots1(garden));
    }
    int[][] garden = new int[][]{{5,7,8,6,3}, {0,0,7,0,4},{4,6,3,4,9},{3,1,0,5,8}};
    int[][] visited = new int[garden.length][garden[0].length];

    public int getCarrots1(int[][] garden){
        int X,Y;
        int[] center = getCenter(garden);
        int[][] visited = new int[garden.length][garden[0].length];
        return getCUtil(center[0], center[1], garden, garden[center[0]][center[1]]);
    }

    public int getCUtil(int X, int Y, int[][] garden, int carrots){



        if(X<0 || Y<0 || X>garden.length-1 || Y>garden[0].length-1){
            return 0;
        }
        if(visited[X][Y] == 1)
            return 0;
        else
            visited[X][Y] = 1;

       int left = getCUtil(X, Y-1, garden, carrots);
       int right = getCUtil(X, Y+1, garden, carrots)   ;
       int top = getCUtil(X-1, Y, garden, carrots);
       int down = getCUtil(X+1, Y, garden, carrots);

       int max1 = Math.max(left, right);
       int max2 = Math.max(top, down);
       return carrots+Math.max(max1, max2);
    }

    public int getCarrots(int[][] garden){
        int totalCarrots = 0;

        int[] center = getCenter(garden);
        int[][] visited = new int[garden.length][garden[0].length];
        //getNext Max
        int routeX = center[0];
        int routeY = center[1];

        while (routeX < garden.length && routeY < garden[0].length){
            visited[routeX][routeY] = 1;
            totalCarrots += garden[routeX][routeY];

            int[] nextMaxCell1 = new int[2];
            int[] nextMaxCell2 = new int[2];

            //compare Rows
            if(routeY>0 && routeY+1<garden[0].length && visited[routeX][routeY-1] == 0 && visited[routeX][routeY+1] == 0 )
                nextMaxCell1 = getMax(routeX, routeY-1, routeX,routeY+1, garden);

            //compare Cols
            if(routeX>0 && routeX+1<garden.length && visited[routeX-1][routeY] == 0 && visited[routeX+1][routeY] == 0 )
                nextMaxCell2 = getMax(routeX-1, routeY, routeX+1,routeY, garden);

            //compare the nexMaxCells
            nextMaxCell1 = getMax(nextMaxCell1[0], nextMaxCell1[1], nextMaxCell2[0], nextMaxCell2[1], garden);

            routeX = nextMaxCell1[0];
            routeY = nextMaxCell1[1];
        }

        return totalCarrots;
    }

    public int[] getCenter(int[][] garden){
        int[] maxCenter = new int[2];
        //exact center or greedy center
        int columns = garden[0].length;
        int rows = garden.length;

        Integer centerCol = null;
        Integer centerRow = null;
        if(columns%2 != 0){ //odd column
            centerCol = columns/2;
        }

        if(rows%2 != 0){
            centerRow = rows/2;
        }

        if(centerCol == null && centerRow == null){
            //greedy row & col
            int minX = rows/2-1;
            int minY = columns/2-1;
            int maxX = rows/2 ;
            int maxY = columns/2 ;

            //4 possibilities for center
            //max in the first row
            int[] maxIn1Row = getMax(minX, minY, minX, maxY, garden);
            //max in the second row
            int[] maxIn2Row = getMax(maxX, minY, maxX, maxY, garden);

            //max from the above
            maxCenter = getMax(maxIn1Row[0], maxIn1Row[1], maxIn2Row[0], maxIn2Row[1], garden);
            return maxCenter;
        }

        if(centerRow == null){
            // check vertically
            int minX = rows/2-1;
            int maxX = rows/2;
            maxCenter = getMax(minX, centerCol, maxX, centerCol, garden);
            return maxCenter;
        }

        if(centerCol == null){
            //check horizontally
            int minY = columns/2-1;
            int maxY = columns/2;
            maxCenter = getMax(centerRow, minY, centerCol, maxY, garden);
            return maxCenter;
        }
        maxCenter[0] = centerRow;
        maxCenter[1] = centerCol;
        return maxCenter;
    }

    public int[] getMax(int x1, int y1, int x2, int y2, int[][] garden){

        if(garden[x1][y1] > garden[x2][y2] ){
            return new int[]{x1,y1};
        } else {
            return new int[]{x2, y2};
        }
    }
}
