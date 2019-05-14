package org.leetcode.problems.medium;

import org.junit.Test;

public class DivideTwoIntegers {

    @Test
    public void test(){
//        System.out.println(divide(10, 4));
        System.out.println(divide(-10, 5));
        System.out.println(divide(-2147483648, -1));
        System.out.println(divide(-2147483648, 1));
//        System.out.println(divide(-2147483648, 1));
        System.out.println(divide(-2147483648, 2));
        System.out.println(divide(-1, 1));
        System.out.println(divide(0, 1));
    }

    public int divide(int dividend, int divisor) {
        int quotient = 0;
        if(dividend == 0) return 0;

        int sign = getSign(dividend, divisor);

        if(dividend == Integer.MIN_VALUE && divisor == -1 ){
            return Integer.MAX_VALUE;
        }
        int fastQuotient = getFastQuotient(dividend, divisor);

        if(dividend >= 0){
            while (dividend >= sign*divisor){
                dividend = dividend - sign*divisor;
                quotient++;
            }
        } else {
            while (dividend <= sign*divisor){
                dividend = dividend - sign*divisor;
                quotient++;
            }
        }


        return sign*quotient;
    }

    private int getSign(int dividend, int divisor){
        if((dividend > 0 && divisor >0) || (dividend<0 && divisor<0)){
            return 1;
        } else {
            return -1;
        }
    }

    private int getFastQuotient(int dividend, int divisor){
        int fastQuotient = 1;
        divisor = Math.abs(divisor);
        if(dividend >0){
            while (divisor <= dividend){
                fastQuotient+= fastQuotient;
                divisor+=divisor;
            }
        } else {
            while (divisor >= dividend){
                fastQuotient+= fastQuotient;
                divisor-=divisor;
            }
        }
        if(fastQuotient>1){
            return fastQuotient;
        } else {
            return 0;
        }
    }

}
