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
