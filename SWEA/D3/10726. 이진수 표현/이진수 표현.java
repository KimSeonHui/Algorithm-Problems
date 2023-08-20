import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t<=T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            boolean flag = true;
            for(int i=0; i<N; i++) {
                if((M & (1 << i))  == 0) {
                    flag = false;
                    break;
                }
            }
            if(flag) sb.append("#" + t + " ON" + "\n");
            else sb.append("#" + t + " OFF" + "\n");
        }
        System.out.println(sb);
    }
}