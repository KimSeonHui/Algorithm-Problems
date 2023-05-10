import java.io.*;
import java.util.*;

public class Main {
	static char[] res, a, b;
	static boolean[] sel;
	static int max;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		a = st.nextToken().toCharArray();
		Arrays.sort(a);
		a = new StringBuilder(new String(a)).reverse().toString().toCharArray();
		b = st.nextToken().toCharArray();
		
		max = -1;
		sel = new boolean[a.length];
		res = new char[a.length];
		comb(0);
		System.out.println(max);
		br.close();
	}
	
	static void comb(int cnt) {
		if(res[0]=='0') return;
		if(cnt == a.length) {
			int numA = Integer.parseInt(new String(res));
			int numB = Integer.parseInt(new String(b));
			
			if(numA < numB) {
				max = Math.max(max, numA);
				return;
			}
			return;
		}
		
		for(int i=0; i<a.length; i++) {
			if(sel[i]) continue;
			
			sel[i] = true;
			res[cnt] = a[i];
			comb(cnt+1);
			sel[i] = false;
		}
	}
}
