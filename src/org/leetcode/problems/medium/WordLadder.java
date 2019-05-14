package org.leetcode.problems.medium;

import org.junit.Test;

import java.util.*;

public class WordLadder {

    @Test
    public void test(){
        WordLadder wordLadder = new WordLadder();
        List<String> wordList = new ArrayList<String>(Arrays.asList("hot","dot","dog","lot","log","cog"));
        String beginWord = "hit", endWord = "cog";
//        System.out.println(wordLadder.ladderLength(beginWord, endWord, wordList));

        beginWord = "qa";
        endWord = "sq";
        wordList = new ArrayList<>(Arrays.asList("si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"));
        System.out.println(wordLadder.ladderLength(beginWord, endWord, wordList));
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>();
        for(String w : wordList){
            wordSet.add(w);
        }

        if(!wordSet.contains(endWord)) return 0;
        int result = ladderLengthUtil(beginWord, endWord, wordSet);
        if(result == 1000){
            return 0;
        } else {
            return result;
        }
    }

    public int ladderLengthUtil(String beginWord, String endWord, Set<String> wordSet){
        int transforms = 1000, prevTransforms = 1000;

        if(beginWord.equals(endWord)){
            return 1;
        }

        for(String word: wordSet){
            if(isSingleTransform(beginWord, word)){
                Set<String> set = new HashSet<String>();
                set.addAll(wordSet);
                set.remove(word);
                transforms = 1+ladderLengthUtil(word, endWord, set);
//                System.out.println(beginWord + " -> " + word + " Transforms: " + transforms);
                transforms = Math.min(transforms, prevTransforms);
                prevTransforms = transforms;
            }
        }
        return transforms;
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
