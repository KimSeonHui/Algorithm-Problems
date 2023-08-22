import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++) {
            st = new StringTokenizer(br.readLine());
            // N ,M , L 입력 받기
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());

            // 수열 입력 받기
            ArrayList<Integer> nums = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++) {
                nums.add(Integer.parseInt(st.nextToken()));
            }

            // 편집 처리
            for(int i=0; i<M; i++) {
                st = new StringTokenizer(br.readLine());
                String order = st.nextToken();
                if(order.equals("I")) {
                    int index = Integer.parseInt(st.nextToken());
                    int num = Integer.parseInt(st.nextToken());
                    nums.add(index, num);
                } else if (order.equals("D")) {
                    int index = Integer.parseInt(st.nextToken());
                    nums.remove(index);
                }
                else {
                    int index = Integer.parseInt(st.nextToken());
                    int num = Integer.parseInt(st.nextToken());
                    nums.set(index, num);
                }
            }
            sb.append("#" + t + " ");
            if(nums.size() <= L) sb.append(-1 + "\n");
            else sb.append(nums.get(L) + "\n");
        }
        System.out.println(sb);
        br.close();
    }
}