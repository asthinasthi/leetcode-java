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
public class ImplementTrie {

	@Test
	public void test() {
		Trie trie = new Trie();
//		trie.insert("anoop");
//		trie.insert("anirudh");
//		System.out.println(trie.startsWith("an"));
		
		trie.insert("abc");
		trie.insert("ab");
		System.out.println(trie.startsWith("an"));
		System.out.println(trie.search("ab"));
		trie.delete("ab");
		System.out.println(trie.search("ab"));
		trie.insert("ab");
		System.out.println(trie.search("ab"));
	}

	class TrieNode {
	    // Initialize your data structure here.
		private char value;
		private TrieNode[] child;
		public boolean isLeaf;
	    public TrieNode() {
	        //26 TrieNodes
	    	child = new TrieNode[26];
	    }
		public char getValue() {
			return value;
		}
		public void setValue(char value) {
			this.value = value;
		}
		public TrieNode[] getChild() {
			return child;
		}
		public void setChild(TrieNode node){
			this.child[node.getValue()-'a'] = node;
		}
		public boolean isLeaf(){
			return isLeaf;
		}
	}

	public class Trie {
	    private TrieNode root;

	    public Trie() {
	        root = new TrieNode();
	    }

	    // Inserts a word into the trie.
	    public void insert(String word) {
	    	int index = 0;
	        int charIdx = word.charAt(index) - 'a';
	        TrieNode temp = root;
	        while(temp.getChild()[charIdx] != null){
	        	temp = temp.getChild()[charIdx];
	        	if(index == word.length()-1){
	        		temp.isLeaf=true;
	        		return;
	        	}
	        	charIdx = word.charAt(++index) - 'a';
	        }
	        //current index doesn't exist
	        while(index < word.length()){
		        TrieNode currNode = new TrieNode();
		        currNode.setValue(word.charAt(index));
		        temp.setChild(currNode);
		        temp = currNode;
	        	if(index == word.length()-1){
	        		temp.isLeaf=true;
	        	}
		        index++;
	        }
	    }

	    // Returns if the word is in the trie.
	    public boolean search(String word) {
	    	int index = 0;
	    	int charIdx = word.charAt(index) - 'a';
	    	TrieNode temp = root;
	        while(temp.getChild()[charIdx]!=null){
	        	temp = temp.getChild()[charIdx];
	        	if(index == word.length()-1)
	        		if(temp.isLeaf())
	        			return true;
	        		else 
	        			return false;
	        	charIdx = word.charAt(++index) - 'a';
	        }
	        return false;
	    }

	    // Returns if there is any word in the trie
	    // that starts with the given prefix.
	    public boolean startsWith(String prefix) {
	    	int index = 0;
	    	int charIdx = prefix.charAt(index) - 'a';
	    	TrieNode temp = root;
	        while(temp.getChild()[charIdx]!=null){
	        	temp = temp.getChild()[charIdx];
	        	if(index == prefix.length()-1)
	        		return true;
	        	charIdx = prefix.charAt(++index) - 'a';
	        }
	        return false;
	    }
	    
	    public void delete(String word){
	    	if(search(word)){
		    	int index = 0;
		    	int charIdx = word.charAt(index) - 'a';
		    	TrieNode temp = root;
		        while(temp.getChild()[charIdx]!=null){
		        	temp = temp.getChild()[charIdx];
		        	if(index == word.length()-1){
		        		temp.isLeaf = false;
		        		return;
		        	}
		        	charIdx = word.charAt(++index) - 'a';
		        }
	    	}
	    }
	}
}
