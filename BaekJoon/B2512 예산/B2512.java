package M03_5;

import java.io.*;
import java.util.*;

public class B2512 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] req = new int[N];
		
		int sum = 0; int max=0;
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			req[i] = Integer.parseInt(st.nextToken());
			sum += req[i];
			if(max < req[i]) max = req[i];
		}
		int M = Integer.parseInt(br.readLine());
		
		if(sum<=M) System.out.println(max);
		else {
			Arrays.sort(req);
			int start=1, end=req[N-1];
			
			while(start < end) {
				int mid = (start+end)/2;
				int calMax=0;
				if(max == mid) break;
				max = mid;

				for(int i=0; i<N; i++) {
					if(req[i]<=mid) calMax += req[i];
					else calMax += mid;
				}
				
				if(calMax > M) end = mid;
				else start = mid;
			}
			System.out.println(max);
		}
		br.close();
	}
}
