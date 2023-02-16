package backjoon;

import java.io.*;
import java.util.*;

public class B17406 {
	static int N, M, K;
	static int[][] arr;
	static int min;
	static int[] rotateArr;
	static int[] a;
	static boolean[] v;
	static List<int[]> rotateInfo;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N+1][M+1];
		rotateArr = new int[K];
		v = new boolean[K];
		a = new int[K];
		rotateInfo = new ArrayList<>();
		min = 250000;
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=1; j<=M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			rotateInfo.add(new int[] {
					Integer.parseInt(st.nextToken()), 
					Integer.parseInt(st.nextToken()), 
					Integer.parseInt(st.nextToken())}
			);
			a[i] = i;
		}
		perm(0);
		System.out.println(min);
	}
	
	static void perm(int cnt) {
		if(cnt == K) {
			int[][] input = new int[N+1][M+1];
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=M; j++) input[i][j] = arr[i][j];
			}
			for(int i=0; i<K; i++) {
				int r = rotateInfo.get(rotateArr[i])[0];
				int c = rotateInfo.get(rotateArr[i])[1];
				int s = rotateInfo.get(rotateArr[i])[2];
				
				rotate(r,c,s, input);
			}
			for(int i=1; i<=N; i++) {
				int sum = 0;
				for(int j=1; j<=M; j++) sum += input[i][j];
				min = Math.min(min, sum);
			}
			return;
		}
        
		for(int i=0; i<K; i++) {
			if(v[i]) continue;
			v[i] = true;
			rotateArr[cnt] = a[i];
			perm(cnt+1);
			v[i] = false;
		}
	}
	
	static void rotate(int r, int c, int s, int[][] input) {
		int T = r-s;
		int R = c+s;
		int B = r+s;
		int L = c-s;
		
		// 배열 돌리기
		while(true) {
			if(T>=B) break;
			
			int temp = input[T][L];
			for(int i=T; i<B; i++) input[i][L] = input[i+1][L]; // ^
			for(int j=L; j<R; j++) input[B][j] = input[B][j+1]; // <
			for(int i=B; i>T; i--) input[i][R] = input[i-1][R]; // v
			for(int j=R; j>L; j--) input[T][j] = input[T][j-1];  // >
			input[T][L+1] = temp;
            
            T+=1;
			L+=1;
			B-=1;
			R-=1;
		}
	}

}
