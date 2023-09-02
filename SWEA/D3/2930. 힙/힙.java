import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++) {
            int N = Integer.parseInt(br.readLine());

            StringTokenizer st;
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            sb.append("#" + t + " ");
            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine(), " ");

                int oper = Integer.parseInt(st.nextToken());
                if(oper == 1) {
                    int num = Integer.parseInt(st.nextToken());
                    pq.offer(-num);
                }
                else {
                    if(pq.isEmpty()) sb.append(-1 + " ");
                    else sb.append(-pq.poll() + " ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}