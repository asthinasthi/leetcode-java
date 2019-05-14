package org.leetcode.problems.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CyclicGraph {
    private Graph graph;

//    @Test
    public void init(){
        List<Integer> list = new ArrayList<>(10);
        System.out.println(list.size());
    }

    @Test
    public void test(){
        graph = new Graph(5);
        //0-->1-->2-->3-->4-->0
        graph.addEdge(0,1);
        graph.addEdge(1,2);
        graph.addEdge(2,3);
        graph.addEdge(3,4);
        graph.addEdge(4,0);

        boolean isCyclic = isCyclic();
        System.out.println(isCyclic);
    }

    public boolean isCyclic(){
        boolean[] visited = new boolean[graph.v];
        boolean[] recStack = new boolean[graph.v];

        for (int i = 0; i < graph.v; i++) {
            if(isCyclicUtil(i, visited, recStack)){
                return true;
            }
        }
        return false;
    }

    public boolean isCyclicUtil(int src, boolean[] visited, boolean[] recStack){
        if(recStack[src])
            return true;
        if(visited[src])
            return true;
        recStack[src]=true;
        visited[src]=true;
        List<Integer> dests = graph.adj.get(src);
        for(Integer d: dests){
            if(isCyclicUtil(d, visited, recStack)){
                return true;
            }
        }
        recStack[src]=false;
        return false;
    }

    class Graph{
        int v;
        List<List<Integer>> adj = new ArrayList<>();
        public Graph(int v){
            this.v = v;
            this.adj = new ArrayList<>(v);
            for (int i = 0; i < v ; i++) {
                this.adj.add(new ArrayList<>());
            }
        }

        public void addEdge(int source, int dest){
            this.adj.get(source).add(dest);
        }
    }
}
