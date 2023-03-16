package M03_3;

import java.io.*;
import java.util.*;

public class B1263 {
	static class Todo  implements Comparable<Todo>{
		int time, deadLine;
		
		public Todo(int time, int deadLine) {
			this.time = time;
			this.deadLine = deadLine;
		}

		@Override
		public int compareTo(Todo o) {
			int r = -Integer.compare(deadLine, o.deadLine);
			if(r==0) r = -Integer.compare(time, o.time);
			return r;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Todo[] todos = new Todo[N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int time = Integer.parseInt(st.nextToken());
			int deadLine = Integer.parseInt(st.nextToken());
			todos[i] = new Todo(time, deadLine);
		}
		
		Arrays.sort(todos);
		
		int endTime = todos[0].deadLine;
		for(Todo t : todos) {
			if(endTime <= t.deadLine) {
				endTime -= t.time;
				if(endTime < 0) break;
			}
			else {
				endTime = t.deadLine - t.time;
			}
		}
		System.out.println(endTime<0? -1 : endTime);
		br.close();
	}
}
