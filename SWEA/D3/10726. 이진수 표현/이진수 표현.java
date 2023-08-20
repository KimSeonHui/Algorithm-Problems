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

            int mask = (1 << N) - 1; // 끝 N개 비트를 1인 마스크 생성
            M &= mask; // M과 mask를 & 연산 >> M의 끝 N개 비트가 유지됨

            // mask가 이미 끝 N개 비트가 1이기 때문에 M과 mask가 같으면 모두 인 비트
            if(M == mask) sb.append("#" + t + " ON" + "\n");
            else sb.append("#" + t + " OFF" + "\n");
        }
        System.out.println(sb);
    }
}