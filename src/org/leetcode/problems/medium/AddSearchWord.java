/**
 * 
 */
package org.leetcode.problems.medium;

import static org.junit.Assert.*;

import org.junit.Test;
import org.leetcode.problems.medium.ImplementTrie.TrieNode;

/**
 * @author amathad
 * 
 */
public class AddSearchWord {

	@Test
	public void test() {
		WordDictionary dict = new WordDictionary();
		dict.addWord("a");
		dict.addWord("a");
//		dict.addWord(".");
		System.out.println(dict.search("a."));
	}

	public class WordDictionary {

		Trie trie = new Trie();

		public class TrieNode {
			char val;
			private TrieNode[] children;
			private boolean isWord;

			public TrieNode() {
				children = new TrieNode[26];
			}

			public TrieNode[] getChildren() {
				return children;
			}

			public char getValue() {
				return this.val;
			}

			public void setValue(char v) {
				this.val = v;
			}

			public void setChild(TrieNode node) {
				this.children[node.getValue() - 'a'] = node;
			}
		}

		public class Trie {
			TrieNode root;

			public Trie() {
				root = new TrieNode();
			}

			public void addWord(String word) {

				int index = 0;
				int charIdx = word.charAt(index) - 'a';
				TrieNode temp = root;
				while (temp.getChildren()[charIdx] != null) {
					temp = temp.getChildren()[charIdx];
					if (index == word.length() - 1) {
						temp.isWord = true;
						return;
					}
					charIdx = word.charAt(++index) - 'a';
				}
				// current index doesn't exist
				while (index < word.length()) {
					TrieNode currNode = new TrieNode();
					currNode.setValue(word.charAt(index));
					temp.setChild(currNode);
					temp = currNode;
					if (index == word.length() - 1) {
						temp.isWord = true;
					}
					index++;
				}
			}
		}

		// Adds a word into the data structure.
		public void addWord(String word) {
			this.trie.addWord(word);
		}

		// Returns if the word is in the data structure. A word could
		// contain the dot character '.' to represent any one letter.
		public boolean search(String word) {
			return searchChildren(this.trie.root, word);
		}

		public boolean searchChildren(TrieNode root, String word) {
	
			if(root == null)
				return false;
			
			if (word.length() == 1) {
				if(word.charAt(0) == '.'){
					//is any child a word 
					for(int i=0; i<26; i++){
						TrieNode currNode = root.getChildren()[i];
						if(currNode!=null && currNode.isWord)
							return true;
					}
					return false;
				}
				TrieNode currNode = root.getChildren()[word.charAt(0) - 'a'];
				if (currNode != null
						&& currNode.isWord) {
					return true;
				} else {
					return false;
				}
			}

			if (word.charAt(0) == '.') {
				boolean result = false;
				for (int i = 0; i < 26; i++) {
					TrieNode currNode = root.getChildren()[i];
					result = result || searchChildren(currNode ,word.substring(1));
				}
				return result;
			} else if (root.getChildren()[word.charAt(0) - 'a'] != null) {
				root = root.getChildren()[word.charAt(0) - 'a'];
				return searchChildren(root, word.substring(1));
			}
			return false;
		}
	}
}
