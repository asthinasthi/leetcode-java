package org.leetcode.problems.high;

import org.junit.Test;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class RearrangeStringNoAdj {

    @Test
    public void test() throws Exception{
        String output = rearrange("aaaaaab");
        System.out.println(output);
    }

    public String rearrange(String input) throws  Exception{
        StringBuilder output = new StringBuilder();

        PriorityQueue<KV> pQueue = new PriorityQueue<KV>(new Comparator<KV>() {
            @Override
            public int compare(KV o1, KV o2) {
                return o2.num-o1.num;
            }
        });
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<input.length();i++){
            String key = input.substring(i,i+1);
            if(map.containsKey(key)){
                Integer val = map.get(key);
                val++;
                map.put(key, val);
            } else {
                map.put(key, 1);
            }
        }

        for (String key: map.keySet()){
            pQueue.add(new KV(key, map.get(key)));
        }

        while (!pQueue.isEmpty()){
            KV kV1 = pQueue.poll();
            output.append(kV1.str);

            KV kV2 = pQueue.poll();
            if(kV2!=null)
                output.append(kV2.str);
            else
                break;

            kV1.num--;
            if(kV1.num>0)
                pQueue.add(kV1);
            kV2.num--;
            if(kV2.num>0)
                pQueue.add(kV2);

        }

        if(output.toString().length() != input.length())
           throw new Exception("Cannot Do!");

        return output.toString();
    }

    class KV{
        String str;
        Integer num;

        public KV(String str, Integer num){
            this.str = str;
            this.num = num;
        }
    }
}
