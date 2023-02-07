package backjoon;

import java.io.*;
import java.util.*;

public class B1244 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] switches = new int[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=1; i <=N; i++) {
			switches[i] = Integer.parseInt(st.nextToken());
		}
		
		int students = Integer.parseInt(br.readLine());
		for(int i=0; i<students; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int gender = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			
			if(gender == 1) {
				for(int j=num; j<=N; j++) {
					if(j%num == 0) switches[j] = (switches[j]+1)%2; 
				}
			}
			else {
				switches[num] = (switches[num]+1)%2;
				for(int j=1; j<Math.min(num, switches.length-num); j++) {
					if(switches[num-j] == switches[num+j]) {
						switches[num-j] = (switches[num-j]+1)%2; 
						switches[num+j] = (switches[num+j]+1)%2; 
					}
					else break;
				}
			}
		}
		for(int i=1; i<=N; i++) {
			sb.append(switches[i]).append(" ");
			if(i%20 == 0) sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
