import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		int[] A = new int[N]; 
		int[] P = new int[N]; 
		int[] sort = new int[N]; 
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
			sort[i] = A[i];
			P[i] = -1;
		}
		
		Arrays.sort(sort);
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(P[i] == -1 && A[i] == sort[j]) {
					P[i] = j;
					sort[j] = -1;
				}
			}
		}
		
		for(int num : P) sb.append(num).append(" ");
		System.out.println(sb);
		br.close();
	}
	
}