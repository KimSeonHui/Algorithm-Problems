import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for(int t=1; t<=10; t++) {
            int N = Integer.parseInt(br.readLine());

            LinkedList<Integer> list = new LinkedList<>();
            // 원본 암호문 코드 입력 받기
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int i=0; i<N; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }

            int orderCnt = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), " ");
            for(int i=0; i<orderCnt; i++) {
                String order = st.nextToken();
                if(order.equals("I")) {
                    int x = Integer.parseInt(st.nextToken());
                    int y = Integer.parseInt(st.nextToken());

                    for(int j=0; j<y; j++) {
                        list.add(x+j, Integer.parseInt(st.nextToken()));
                    }
                }
                else if(order.equals("D")) {
                    int x = Integer.parseInt(st.nextToken());
                    int y = Integer.parseInt(st.nextToken());
                    for(int j=0; j<y; j++) {
                        list.remove(x+j);
                    }
                }
                else {
                    int y = Integer.parseInt(st.nextToken());
                    for(int j=0; j<y; j++) {
                        list.addLast(Integer.parseInt(st.nextToken()));
                    }
                }
            }
            sb.append("#" + t + " ");
            for(int i=0; i<10; i++) {
                sb.append(list.get(i) + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}