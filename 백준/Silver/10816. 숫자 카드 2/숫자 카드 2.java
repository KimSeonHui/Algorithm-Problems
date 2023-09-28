import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        Map<Integer, Integer> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(map.get(num) == null) map.put(num, 1);
            else map.put(num, map.get(num) + 1);
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<M; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(map.get(num) == null) sb.append(0 + " ");
            else sb.append(map.get(num) + " ");
        }
        System.out.println(sb);
    }
}