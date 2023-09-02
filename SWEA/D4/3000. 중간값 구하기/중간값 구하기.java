import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++) {
            st = new StringTokenizer(br.readLine(), " ");

            PriorityQueue<Integer> minH = new PriorityQueue<>(); // 중간값보다 큰 값들
            PriorityQueue<Integer> maxH = new PriorityQueue<>(); // 중간값, 중간값보다 작은 값들
            int N = Integer.parseInt(st.nextToken());
            int mid = Integer.parseInt(st.nextToken());
            int sum = 0;
            maxH.offer(-mid);

            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine(), " ");

                while(st.hasMoreTokens()) {
                    int num = Integer.parseInt(st.nextToken());

                    if(num <= mid) maxH.offer(-num);
                    else minH.offer(num);
                }

                if(maxH.size() > minH.size()) {
                    while(maxH.size() - minH.size() > 1) {
                        minH.offer(-maxH.poll());
                    }
                }
                else {
                    while(minH.size() - maxH.size() >= 1) {
                        maxH.offer(-minH.poll());
                    }
                }

                mid = -maxH.peek();
                sum = (mid + sum) % 20171109;
            }

            sb.append("#" + t + " " + sum + "\n");
        }
        System.out.println(sb);
    }
}