package org.leetcode.problems.medium;

import org.junit.Test;

import java.util.*;
import java.util.regex.Pattern;

public class WordLadderDP {

    @Test
    public void test(){
        WordLadderDP wordLadder = new WordLadderDP();
        List<String> wordList = new ArrayList<String>(Arrays.asList("hot","dot","dog","lot","log","cog"));
        String beginWord = "hit", endWord = "cog";

        beginWord = "qa";
        endWord = "sq";
        wordList = new ArrayList<>(Arrays.asList("si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"));
        wordList.add(beginWord);
        System.out.println(wordLadder.ladderLength(beginWord, endWord, wordList));
    }

    Map<String, List<Integer>> pathDistance = new HashMap<>();
    String END_WORD = "";

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        END_WORD = endWord;
        Set<String> wordSet = new HashSet<>();
        for(String w : wordList){
            if(!w.equals(endWord))
                wordSet.add(w);
        }
        List<String> transitions = new ArrayList<>();
        transitions.add(END_WORD);
        updatePathDistance(END_WORD, wordSet, 0, transitions);
        int min = Integer.MAX_VALUE;
        if(!pathDistance.containsKey(beginWord+endWord)){
            return 0;
        }

        for(Integer i : pathDistance.get(beginWord+endWord)){
            min = Math.min(i, min);
        }
        return min+1;
    }

    public void updatePathDistance(String endWord, Set<String> wordSet, int distance, List<String> transitions){
//        System.out.println();
//        System.out.print(" End Word: " + endWord + " | Word Set: " + wordSet + " | ");
        for(String s: wordSet){
            if(isSingleTransform(endWord, s)){
                List<String> copyTransitions = new ArrayList<>();
                copyTransitions.addAll(transitions);
                copyTransitions.add(s);

                if(pathDistance.containsKey(s+END_WORD)){
                    List<Integer> val = pathDistance.get(s+END_WORD);
                    val.add(distance);
                } else {
                    List<Integer> val = new ArrayList<>();
                    val.add(distance);
                    pathDistance.put(s+END_WORD, val);
                }
//                System.out.print("Transitions: ");
//                for (int i = 0; i < copyTransitions.size(); i++) {
//                    System.out.print(copyTransitions.get(i) + "->");
//                }
//                System.out.println();
//                System.out.println(s + " --> " + END_WORD + " Dist: " + ++distance);
                Set<String> tempSet = new HashSet<>();
                tempSet.addAll(wordSet);
                tempSet.remove(s);
                updatePathDistance(s, tempSet, distance, copyTransitions);
            }
        }
    }

    public boolean isSingleTransform(String word1, String word2){
        int i=0,j=0, mismatch = 0;

        while (i<word1.length() && j<word2.length()){
            if(word1.charAt(i) != word2.charAt(j)){
                mismatch++;
                if(mismatch == 2){
                    return false;
                }
            }
            i++;j++;
        }
        return true;
    }
}
