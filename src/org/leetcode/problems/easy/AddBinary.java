package org.leetcode.problems.easy;

import org.junit.Test;

public class AddBinary {

    @Test
    public void test(){

        String a = "11";
        String b = "1";
        System.out.println(addBinary(a,b));
    }

    public String addBinary(String a, String b){
        StringBuffer result = new StringBuffer();
        int aIdx = a.length()-1;
        int bIdx = b.length()-1;
        int carry = 0;
        while (aIdx >=0 || bIdx >=0 ){
            int sum = carry;
            if(aIdx>=0) sum += a.charAt(aIdx--) -'0';
            if(bIdx>=0) sum += b.charAt(bIdx--) -'0';

            result.append(sum%2);
            carry = sum/2;
        }
        if(carry!=0) result.append(carry);
        return result.reverse().toString();
    }

    public String addBinary1(String a, String b) {
        int longestDigits = Math.max(a.length(), b.length());

        int aIdx = a.length()-1;
        int bIdx = b.length()-1;
        int carry = 0;
        int sum = 0;
        String result = "";
        int firstDigit = 0;
        int secondDigit = 0;
        while(longestDigits > 0){
            if(aIdx>=0)
                firstDigit = Integer.parseInt(a.substring(aIdx,aIdx+1));
            else
                firstDigit = 0;
            if(bIdx>=0)
                secondDigit = Integer.parseInt(b.substring(bIdx,bIdx+1));
            else
                secondDigit = 0;
            aIdx--;
            bIdx--;
            sum = (firstDigit ^ secondDigit) ^ carry;
            result = new Integer(sum).toString() + result;
            if(carry == 0){
                carry = firstDigit & secondDigit;
            } else {
                carry = firstDigit | secondDigit;
            }

            longestDigits--;
        }
        if(carry != 0)
            return "1"+result;
        return result;
    }
}
