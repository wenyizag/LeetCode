package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class GraphValidTree {
	public boolean validTree(int n, int[][] edges) {
		int[] parents = new int[n];
		Arrays.fill(parents, -1);
		int edge = edges.length;
		
		for(int i = 0; i < edge; i++) {
			int x = find(edges[i][0], parents);
			int y = find(edges[i][1], parents);
			if(x == y) return false;
			parents[x] = y;
		}
		return true;
	}
	public int find(int n, int parents[]) {
		if(parents[n] != -1) find(parents[n], parents);
		return n;
	}
}

//solution 2. Union and Find，刚刚自己写的一个比较完整的union and find
public class Solution {
    /**
     * @param n: An integer
     * @param edges: a list of undirected edges
     * @return: true if it's a valid tree, or false
     */
    public boolean validTree(int n, int[][] edges) {
        // write your code here
        if(edges.length != n-1) return false;
        UnionAndFind unionEdges = new UnionAndFind(n);
        for(int[] edge : edges) {
            if(!unionEdges.union(edge[0], edge[1])) return false;
        }
        return true;
    }

class UnionAndFind {
    int[] parent;
    int[] rank;
    public UnionAndFind(int n) {
        parent = new int[n];
        rank = new int[n];
        for(int i = 0; i<n; i++) 
            parent[i] = i;
    }
    
    public int find(int i) {
        if(parent[i] != i) parent[i] = find(parent[i]);
        return parent[i];
    }
    
    public boolean union(int i, int j) {
        int p_i = find(i);
        int p_j = find(j);
        if(p_i == p_j) return false;
        //union
        if(rank[p_i] == rank[p_j]) {
            parent[p_j] = p_i;
            rank[p_i]++;
        }else if(rank[p_i] > rank[p_j]) {
            parent[p_j] = p_i;
        }else {
            parent[p_i] = p_j;
        }
        return true;
    }
}
}
