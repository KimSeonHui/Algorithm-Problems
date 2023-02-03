package backjoon;

import java.io.*;
import java.util.*;

class Info {
	public int index;
	public int age;
	public String name;
	
	public Info(int index, int age, String name) {
		this.index = index;
		this.age = age;
		this.name = name;
	}
}

public class B10814 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int N = Integer.parseInt(br.readLine());
		List<Info> list = new ArrayList<>();
		int index = 0;
		
		for(int i=0; i <N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			
			list.add(new Info(index++, age, name));
		}
				
		Collections.sort(list, (Info o1, Info o2) -> {
				int r = Integer.compare(o1.age, o2.age);
				if(r==0) Integer.compare(o1.index, o2.index);
				return r;
			}
		);
		
		for(Info l : list) {
			sb.append(l.age).append(" ").append(l.name).append("\n");
		}
		System.out.println(sb.toString());
	}

}
