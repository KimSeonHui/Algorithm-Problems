package M03_1;

import java.io.*;
import java.util.*;

public class B1753 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine());

		List<int[]>[] g = new List[N + 1];
		for (int i = 0; i <= N; i++)
			g[i] = new ArrayList<>();
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			g[from].add(new int[] { to, weight });
		}

		int[] dis = new int[N + 1];
		boolean[] v = new boolean[N + 1];
		for (int i = 1; i <= N; i++)
			dis[i] = Integer.MAX_VALUE;

		dis[start] = 0;
		for (int i = 1; i <= N; i++) {
			int min = Integer.MAX_VALUE;
			int cur = -1;

			for (int j = 1; j <= N; j++) {
				if (!v[j] && min > dis[j]) {
					min = dis[j];
					cur = j;
				}
			}

			if (cur == -1)
				break;
			v[cur] = true;
			for (int[] info : g[cur]) {
				if (!v[info[0]] && dis[info[0]] > min + info[1]) {
					dis[info[0]] = min + info[1];
				}
			}
		}

		for (int i = 1; i <= N; i++) {
			sb.append(dis[i] == Integer.MAX_VALUE ? "INF" : dis[i]).append("\n");
		}
		System.out.println(sb.toString());
		br.close();
	}
}
