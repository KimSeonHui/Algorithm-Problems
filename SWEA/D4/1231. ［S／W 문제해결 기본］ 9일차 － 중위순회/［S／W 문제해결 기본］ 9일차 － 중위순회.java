import java.io.*;
import java.util.*;

public class Solution {
    static char[] nodes;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;

        for(int t=1; t<=10; t++) {
            sb.append("#" + t + " ");
            int N = Integer.parseInt(br.readLine());

            nodes = new char[N+1];
            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int index = Integer.parseInt(st.nextToken());
                char value = st.nextToken().charAt(0);

                nodes[index] = value;
            }

            dfs(1);
            sb.append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    public static void dfs(int index) {
        if(nodes.length <= index || nodes[index] == '\u0000') return;

        dfs(index*2); // 왼쪽 자식 탐색
        sb.append(nodes[index]);
        dfs(index*2+1);
    }
}