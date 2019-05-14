package org.leetcode.problems.crackingthecodeintvw;

import org.junit.Test;

import java.util.Stack;

public class TowersOfHanoi {

    @Test
    public void test(){

        Tower tower1 = new Tower(4);
        tower1.disks.push(4);
        tower1.disks.push(3);
        tower1.disks.push(2);
        tower1.disks.push(1);

        Tower tower2 = new Tower(0);
        Tower tower3 = new Tower(0);

        tower1.move(tower3, tower2);


    }

    class Tower{
        int index;
        public Stack<Integer> disks = new Stack<>();

        public Tower(int i){
            this.index = i;
        }

        public void move(Tower destination, Tower buffer){
            while (!disks.isEmpty() ){
                Integer top = disks.pop();

                if(destination.disks.isEmpty() || destination.disks.peek() > top && destination.disks.peek() > index){
                    destination.disks.push(top);
                } else if(buffer.disks.isEmpty() || buffer.disks.peek() > top){
                    buffer.disks.push(top);
                } else {
                    Integer top1 = destination.disks.pop();
                    if(buffer.disks.isEmpty() || buffer.disks.peek() > top1){
                        buffer.disks.push(top1);
                    }
                }
            }

            if(index > 0 ){
                index--;
                buffer.index = index;
                buffer.move( destination, this);
            }
        }

    }
}

