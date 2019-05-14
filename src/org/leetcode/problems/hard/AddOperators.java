package org.leetcode.problems.hard;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class AddOperators {

    String num;
    int target;
    List<String> resultList = new ArrayList<>();

    public List<String> addOperators(String num, int target) {
        this.num = num;
        this.target = target;
        return addOperatorsUtil(0, 0, 0, "", 0, false);
    }

    public List<String> addOperatorsUtil(double runningSum, double runningMul, double prevDigit, String trail, int index, boolean prevOpMul){
        for(int i=index; i<num.length(); i++){
            Double currDigit = Double.parseDouble(num.substring(index,i+1));
            String currDigitStr = num.substring(index, i+1);
            if(currDigitStr.length() > 1 && currDigitStr.charAt(0) == '0'){ //01 02 004
                continue;
            }

            if(index==0){
                addOperatorsUtil(currDigit, 0, currDigit, new StringBuffer(trail).append(currDigitStr).toString(), i+1, false);
                continue;
            }

            //Add
            addOperatorsUtil(runningSum+runningMul+currDigit, 0, currDigit, new StringBuffer(trail).append("+").append(currDigitStr).toString(), i+1, false);

            //Sub
            addOperatorsUtil(runningSum + runningMul - currDigit, 0, -currDigit, new StringBuffer(trail).append("-").append(currDigitStr).toString(), i+1, false);

            //Mul
            if(!prevOpMul){ //mul starting now
                 //mul with prev digit & curr digit
                 // remove prev digit from runningSum
                addOperatorsUtil(runningSum - prevDigit, prevDigit*currDigit, currDigit, new StringBuffer(trail).append("*").append(currDigitStr).toString(), i+1, true);
            } else {
                //mul with prev digit & curr digit
                addOperatorsUtil(runningSum, runningMul*currDigit, currDigit, new StringBuffer(trail).append("*").append(currDigitStr).toString(), i+1, true);
            }
        }
        if(target == runningSum + runningMul && index==num.length()){
            resultList.add(trail);
        }
        return null;
    }

    @Test
    public void test(){
        num = "3456237490";
        target = 9191;

        addOperators(num, target);
    }
}
