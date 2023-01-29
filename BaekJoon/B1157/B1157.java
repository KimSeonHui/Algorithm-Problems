package backjoon;

import java.io.*;
import java.util.*;

public class B1157 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<Character, Integer> map = new HashMap<>();
		String str = br.readLine();
		
		for(int i=0; i <str.length(); i++) {
			char key = Character.toUpperCase(str.charAt(i));
			if(!map.containsKey(key)) map.put(key, 1);
			else map.put(key, map.get(key)+1);
		}
		
		int max = 0;
		char answer = ' ';
		for(Map.Entry<Character, Integer> entry : map.entrySet()) {
			if(max < entry.getValue()) {
				max = entry.getValue();
				answer = entry.getKey();
			}
			else if(max == entry.getValue()) {
				answer = '?';
			}
		}
		System.out.println(answer);
	}

}
