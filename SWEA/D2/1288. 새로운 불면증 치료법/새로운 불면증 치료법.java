import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
               BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        int check;
        int all_check = (1<<10) - 1;

        for(int t=1; t<=T; t++) {
            int N = Integer.parseInt(br.readLine());

            check = 0;

            for(int k=1;; k++) {
                // N의 각 자리수 가져오기
                int num = N*k;
                while(num > 0) {
                    int digit = num % 10;
                    check |= (1 << digit);
                    num /= 10;
                }

                if(check == all_check) {
                    sb.append("#" + t + " " + N*k+"\n");
                    break;
                }
            }
        }
        System.out.println(sb);
    }
}