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
public class WordSearch {

	@Test
	public void test() {
/*		char[][] board = {  {'A','B','C','E'},
				{'S','F','C','S'},
				{'A','D','E','E'}};*/
		char[][] board = {  {'C','A','A'},
				{'A','A','A'},
				{'B','C','D'}};
		
		String word = new String("AAB");
		assertEquals(true, exist(board, word));
	}

    public boolean exist(char[][] board, String word) {
    	boolean result = false;
    	boolean[][] visited = new boolean[board.length][board[0].length];
        for(int x=0; x<board.length; x++)
        	for(int y=0; y<board[x].length; y++){
//        		visited = new boolean[board.length][board[0].length];
        		result = existRecur(board, visited, word, x, y, 0);
        		if(result)
        			return result;
        	}

		return result;
    }
    
    public boolean existRecur(char[][] board, boolean[][] visited, String word, int x, int y, int wordIdx){
    	if(word == null || wordIdx >= word.length())
    		return true;
    	
    	if(x <0 || x >= board.length || y<0 || y >= board[0].length)
    		return false;
    	
    	if(board[x][y] == word.charAt(wordIdx)){
    		if(visited[x][y])
    			return false;
    		visited[x][y] = true;
//    		String remainingWord = word.substring(1);
    		boolean result = existRecur(board, visited, word, x+1, y, wordIdx + 1) 
    				|| existRecur(board, visited, word, x, y+1, wordIdx + 1)
    				|| existRecur(board, visited, word, x-1, y, wordIdx + 1)
    				|| existRecur(board, visited, word, x, y-1, wordIdx + 1) ;
    		if(result) return true;
       		visited[x][y] = false;
       		return false;
    	} else {
    		return false;
    	}
    }
}
