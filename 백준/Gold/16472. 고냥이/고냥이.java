import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int start = 0; int end = 0;
        int[] isUsed = new int[26];

        int cnt = 0;
        int max = 0;
        while(end < str.length()) {
            char al = str.charAt(end);
            isUsed[al-'a']++;
            if(isUsed[al-'a'] == 1) cnt++;

            while(cnt > N) {
                isUsed[str.charAt(start)-'a']--;
                if(isUsed[str.charAt(start)-'a'] == 0) cnt--;
                start++;
            }
            max = Math.max(max, end - start + 1);
            end++;
        }
        System.out.println(max);
        br.close();
    }
}