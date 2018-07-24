/**
 * 
 */
package org.leetcode.problems.easy;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * @author amathad
 *
 */
public class ReverseVowels {

	@Test
	public void test() {
		String s = "OE";
		System.out.println(reverseVowels(s));
	}

    public String reverseVowels(String s) {

        char[] strArray = s.toCharArray();
        int low = 0;
        int high = strArray.length-1;
        
        while(low<high){
        	while( low<strArray.length && !isVowel(strArray[low])){
        		low++;
        	}
        	while( high >= 0 && !isVowel(strArray[high])){
        		high--;
        	}
        	if(low < high && isVowel(strArray[low]) && isVowel(strArray[high])){
            	char t = strArray[low];
            	strArray[low] = strArray[high];
            	strArray[high] = t;
            	low++;
            	high--;
        	}
        }
        return new String(strArray);
    
    }
    
    private boolean isVowel(char c){
    	if(c == 'a' || c=='e' || c == 'i' || c== 'o' || c=='u'
    		|| c=='A' || c=='E' || c=='I' || c=='O' || c=='U'){
    		return true;
    	} else {
    		return false;
    	}
    }
}
