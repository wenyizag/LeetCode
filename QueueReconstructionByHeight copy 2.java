package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import leetcode2.Comparator;

public class QueueReconstructionByHeight {
	//Sort + LinkedList
		public int[][] reconstructQueue(int[][] people) {
			 Arrays.sort(people, new Comparator<int[]>() {
				 public int compare(int[] p1, int[] p2) {
					 return p1[0] != p2[0]? - p1[0] + p2[0]: p1[1] - p2[1];
				 }
			 });
			 List<int[]> list = new LinkedList<>();
			 for(int[] cur : people) {
				 list.add(cur[1], cur);
			 }
			 
		     return list.toArray(new int[people.length][]);  
		 }
		
		//Sort + without extra space
		public int[][] reconstructQueue2(int[][] people) {
	        
	        if(people.length <= 1) return people;
			 Arrays.sort(people, new Comparator<int[]>() {
				 public int compare(int[] p1, int[] p2) {
					 return p1[0] != p2[0]? - p1[0] + p2[0]: p1[1] - p2[1];
				 }
			 });
			 
			 for(int i = 1; i < people.length; i++) {
				 int index = people[i][1];
				 int[] tmp = people[i];
				 for(int j = i; j > index; j--) {
					 people[j] = people[j-1]; 
				 }
				 people[index] = tmp;
			 }
			 
		     return people;  
		 }
}
