package org.leetcode.problems.hard;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class IntegertoWords {

    @Test
    public void test(){
        int num = 10000000;
//        System.out.println(numToIndianNumerals(num));
        System.out.println(numberToWords(num));
    }

    final String[] LESS_THAN_20s = new String[]{"","One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven",
    "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    final String[] TENS = new String[]{"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    final String[] THOUSANDS = new String[]{"", "Thousand", "Million", "Billion"};


    public String numberToWords(int num){
        String word = "";
        if(num == 0) return "Zero";

        int i=0;
        while(num>0){
            int last3 = num%1000;
            if(last3 != 0)
                word = wordUtil(last3) + THOUSANDS[i] + word;
            num = num/1000;
            i++;
        }
        return word.trim();
    }
    public String wordUtil(int num){
        if(num == 0)
            return "";

        if(num<20){
            return LESS_THAN_20s[num];
        }

        if(num<100){
            return TENS[num/10] +  " " + wordUtil(num%10);
        }

        if(num <1000){
            return LESS_THAN_20s[num/100] + " Hundred " + wordUtil(num%100);
        }
        return "";
    }

    public String numberToWords2(int num) {
        Map<Integer, String> wordMap = getWordMap();
        StringBuffer result = new StringBuffer();
        if(num <= 20){
            result.append(wordMap.get(num));
            return result.toString();
        }

        // Get highest place val & recurse
        String placeValStr = getMaxPlaceVal(num);
        Integer maxDivisor = getMaxDivisor(num);
        int digitAtMax = num/(maxDivisor);
        if(maxDivisor == 1){
            digitAtMax = digitAtMax/10;
            result.append(wordMap.get(digitAtMax*10));
            if(num%10 != 0){
                result.append(" ");
                result.append(numberToWords(num%10));
            }

        } else {
            result.append(numberToWords(digitAtMax));
            result.append(" ");
            result.append(placeValStr);
            if(num%maxDivisor != 0){
                result.append(" ");
                result.append(numberToWords(num%maxDivisor));
            }
        }
        return result.toString();
    }

    /*
    * One's place One, Two, Three, ...
    * Eleven, Twelve, Thirteen, ... --> 2 digit numbers special
    * Twenty One, Twenty Two ...
    * Zeros are special
    * One Hundred, One Hundred and One , ...
    * */

    public Map<Integer, String> getWordMap(){
        Map<Integer, String> map = new HashMap<>();
        map.put(0, "Zero");
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");
        map.put(4, "Four");
        map.put(5, "Five");
        map.put(6, "Six");
        map.put(7, "Seven");
        map.put(8, "Eight");
        map.put(9, "Nine");
        map.put(10, "Ten");
        map.put(11, "Eleven");
        map.put(12, "Twelve");
        map.put(13, "Thirteen");
        map.put(14, "Fourteen");
        map.put(15, "Fifteen");
        map.put(16, "Sixteen");
        map.put(17, "Seventeen");
        map.put(18, "Eighteen");
        map.put(19, "Nineteen");
        map.put(20, "Twenty");
        map.put(30, "Thirty");
        map.put(40, "Forty");
        map.put(50, "Fifty");
        map.put(60, "Sixty");
        map.put(70, "Seventy");
        map.put(80, "Eighty");
        map.put(90, "Ninety");
        return map;
    }

    public String getMaxPlaceVal(int num){
        if(num >= 1000000000){
            return "Billion";
        } else if(num >= 1000000){
            return "Million";
        } else if(num >= 1000){
            return "Thousand";
        } else if(num >= 100){
            return "Hundred";
        } else {
            return "";
        }
    }

    public Integer getMaxDivisor(int num){
        if(num >= 1000000000){
            return 1000000000;
        } else if(num >= 1000000){
            return 1000000;
        } else if(num >= 1000){
            return 1000;
        } else if(num >= 100){
            return 100;
        } else {
            return 1;
        }
    }

    final String[] LAKHS = new String[]{"", "Thousand", "Lakh", "Crore"};

    public String numToIndianNumerals(int num){
        String words = "";
        if(num == 0) return "Zero";

        words += wordUtil(num%1000);
        num = num/1000;

        int i=1;
        while(num>0){
            if(num%100 != 0)
                words = wordUtil(num%100) + " " + LAKHS[i] + " " +words;
            num = num/100;
            i++;
        }
        if(num == 100){
            words = "One " + LAKHS[i];
        }

        return words.trim();
    }


}
