package backjoon;

import java.io.*;
import java.util.*;

public class B12891 {
	static HashMap<Character, int[]> check;
	static char[] dna = {'A', 'C', 'G', 'T'};
	public static void main(String[] args) throws IOException {
		  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		  StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		  int N = Integer.parseInt(st.nextToken());
		  int R = Integer.parseInt(st.nextToken());
		  int C = 0;
	      String str = br.readLine();
	      check = new HashMap<>(); 
	      
	      st = new StringTokenizer(br.readLine(), " ");
	      for(char c : dna) {
	    	  check.put(c, new int[] {0, Integer.parseInt(st.nextToken())});
	      }
	      
	      for(int i=0; i<R; i++) {
	    	 check.get(str.charAt(i))[0]++;
	      }
	      if(isPossible()) C++;
	      
	      for(int i=0; i<N-R; i++) {
	    	  check.get(str.charAt(i))[0]--;
	    	  check.get(str.charAt(i+R))[0]++;
	    	  
	    	  if(isPossible()) C++;
	      }
	      System.out.println(C);
	}
	static boolean isPossible() {
		 for(char c : dna) {
			 if(check.get(c)[0] < check.get(c)[1]) return false;
		 }
		 return true;
	}
}
