import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, ans;
	static int[] res;
	static List[] bads;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		bads = new List[N+1];
		for(int i=1; i<=N; i++ ) bads[i] = new ArrayList<Integer>();
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			
			bads[num1].add(num2);
			bads[num2].add(num1);
		}
		
		res = new int[3];
		for(int i=1; i<=N; i++) {
			res[0] = i;
			for(int j=i+1; j<=N; j++) {
				if(!isPossible(1, j)) continue;
				res[1] = j;
				for(int k=j+1; k<=N; k++) {
					if(!isPossible(2, k)) continue;
					//System.out.println(i + " " + j + " " + k);
					ans++;
				}
			}
		}
		System.out.println(ans);
		br.close();
	}
	
	static boolean isPossible(int before, int cur) {
		for(int i=0; i<before; i++) {
			if(bads[res[i]].contains(cur)) return false;
		}
		return true;
	}
}