package backjoon;

import java.util.HashMap;
import java.util.Scanner;

public class B1157 {
	static int max = 0;
	static char answer = '0';
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashMap<Character, Integer> map = new HashMap<>();
		
		String str = sc.next();
		
		for(int i = 0; i < str.length(); i++) {
			char key = Character.toUpperCase(str.charAt(i));
			if(!map.containsKey(key)) map.put(key, 1);
			else map.put(key, map.get(key)+1);
		}
		
		
		map.forEach((key, value) -> {
			if(max < value) {
				max = value;
				answer = key;
			}
			else if(max == value) {
				max = value;
				answer = '?';
			}
		});
		
		System.out.println(answer);
	}

}
