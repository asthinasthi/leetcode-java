package org.leetcode.problems.medium;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Codec {

    @Test
    public void test(){
        List<String> inputList = new ArrayList<>();
        inputList.add("Anirudh");
        inputList.add("Mathad");
        inputList.add("is");
        inputList.add("a");
        inputList.add("great");
        inputList.add("leader!");

        String encodedStr = encode(inputList);
        System.out.println(encodedStr);
//        List<String> decodedList = decode(encodedStr);
        List<String> decodedList = decode(encodedStr);
        Assert.assertEquals(inputList.size(), decodedList.size());
        Assert.assertEquals(inputList.get(0), decodedList.get(0));
        Assert.assertEquals(inputList.get(inputList.size()-1), decodedList.get(decodedList.size()-1));
        Assert.assertEquals(inputList.get(inputList.size()/2), decodedList.get(decodedList.size()/2));

        String[] arr = {"63/Rc","h","BmI3FS~J9#vmk","7uBZ?7*/","24h+X","O "};
        inputList = Arrays.asList(arr);
        encodedStr = encode(inputList);
        System.out.println(decode(encodedStr));
    }
    // Encodes a list of strings to a single string.
    // 4/abcd5/abcde6/ab4/de
    // 4abcd5abcde6123456
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for(String s: strs){
            sb.append(s.length()).append("/").append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String s){
        if(s == null || s.isEmpty()) return new ArrayList<>();

        List<String> strs = new ArrayList<>();
        int i=0;

        while (i<s.length()){ // 7/Anirudh 0-->7 1-->/ 2-->A 8-->h
            int slashIdx = s.indexOf("/",i);
            String lenStr = s.substring(i, slashIdx);
            int len = Integer.valueOf(lenStr);
            String validStr = s.substring(slashIdx+1, slashIdx+len+1);
            strs.add(validStr);
            i = slashIdx+len+1;
        }
        return strs;
    }

}
