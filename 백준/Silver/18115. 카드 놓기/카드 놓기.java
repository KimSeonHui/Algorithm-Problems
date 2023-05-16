import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] skill = new int[N];
		for(int i=N-1; i>=0; i--) {
			skill[i] = Integer.parseInt(st.nextToken());
		}
		
		ArrayDeque<Integer> de = new ArrayDeque<>();
		
		int num = 1; // 마지막에 뽑힌 숫자부터
		for(int i=0; i<N; i++) {
			if(skill[i] == 1) de.addFirst(num);
			else if(skill[i] == 2) {
				if(!de.isEmpty()) {
					int temp = de.poll();
					de.addFirst(num);
					de.addFirst(temp);
				}
				else de.addFirst(num);
			}
			else de.addLast(num);
			num++;
		}
		
		while(!de.isEmpty()) sb.append(de.poll()).append(" ");
		System.out.println(sb);
		br.close();
	}
}