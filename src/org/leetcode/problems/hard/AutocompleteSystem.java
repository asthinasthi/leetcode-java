package org.leetcode.problems.hard;

import java.util.*;
import java.util.List;

public class AutocompleteSystem {
    TrieNode root;
    String prefix;

    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new TrieNode();
        prefix = "";

        for (int i = 0; i < sentences.length ; i++) {
            add(sentences[i], times[i]);
        }
    }

    public void add(String s, Integer times){
        TrieNode curr = root;
        for(Character c: s.toCharArray()){
            TrieNode next = curr.children.get(c);
            if(next == null){
                next = new TrieNode();
                curr.children.put(c, next);
            }
            curr = next;
            curr.counts.put(s, curr.counts.getOrDefault(s, 0)+times);
        }
        curr.endOfWord = true;
    }

    public List<String> input(char c) {
        List<String> autoCompletes = new ArrayList<>();
        TrieNode curr = root;
        if(c == '#'){
            add(prefix, 1);
            prefix = "";
            return autoCompletes;
        }

        prefix += c;

        for(Character cc: prefix.toCharArray()){
            TrieNode next = curr.children.get(cc);
            if(next == null){
                return autoCompletes;
            }
            curr = next;
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.count==b.count?a.sentence.compareTo(b.sentence):b.count-a.count);

        for (String s: curr.counts.keySet()) {
            pq.add(new Pair(s, curr.counts.get(s)));
        }

        for (int i = 0; i < 3 && !pq.isEmpty() ; i++) {
            autoCompletes.add(pq.poll().sentence);
        }
        return autoCompletes;
    }

    class TrieNode{
        Map<Character, TrieNode> children;
        Map<String, Integer> counts;
        boolean endOfWord;

        public TrieNode(){
            children = new HashMap<>();
            counts = new HashMap<>();
        }
    }

    class Pair{
        String sentence;
        Integer count;

        public Pair(String sentence, Integer count){
            this.sentence = sentence;
            this.count = count;
        }
    }
}
