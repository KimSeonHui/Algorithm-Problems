package backjoon;

import java.io.*;
import java.util.*;

public class B1931 {
	static class Meeting implements Comparable<Meeting> {
		int start, end;

		public Meeting(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

        @Override
		public int compareTo(Meeting o) {
			int r = this.end - o.end;
			if(r==0) r = this.start - o.start;
			return r;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Meeting[] meeting = new Meeting[N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			meeting[i] = new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
        Arrays.sort(meeting);
		int cnt = 1;
		Meeting cur = meeting[0];
		for(int i=1; i<N; i++) {
			if(meeting[i].start >= cur.end) {
				cnt++;
				cur = meeting[i];
			}
		}
		System.out.println(cnt);
	}
}
