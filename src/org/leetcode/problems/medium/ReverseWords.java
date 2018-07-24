/**
 * 
 */
package org.leetcode.problems.medium;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author amathad
 *
 */
public class ReverseWords {

	@Test
	public void test() {
//		String s = "My name is Anirudh";
		String s = "  a  b ";
		System.out.println(s);
		System.out.println(s.trim().split("\\s"));
		System.out.println(reverseWords(s));
	}

    public String reverseWords(String s) {
    	if(s == null || s.isEmpty() || s.equals(" "))
    		return "";
    	
        String[] strArray = s.split(" ");
        if(strArray.length == 0)
        	return "";
        int start=0;
        while(strArray[start].equals("")){
        	start++;
        }
        s = "";
        
        for(int i=strArray.length-1; i>start ;i--){
        	if(!strArray[i].equals(""))
        		s+= strArray[i]+" ";
        }
        s += strArray[start];
        return s;
    }
}
