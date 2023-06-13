import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        String[] nums = new String[N];
        for(int i = 0; i < N; i++) nums[i] = br.readLine();

        Arrays.sort(nums, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int r = 0;
                // 길이가 짧은 것 먼저
                if(o1.length() != o2.length()) {
                    r = Integer.compare(o1.length(), o2.length());
                }
                else {
                    // 숫자의 자리합이 작은 것 먼저
                    int sum1 = 0; int sum2 = 0;
                    for(int i=0; i<o1.length(); i++) {
                        char ch1 = o1.charAt(i);
                        char ch2 = o2.charAt(i);

                        if(0<=ch1-'0' && ch1-'0' <=9) sum1 += ch1-'0';
                        if(0<=ch2-'0' && ch2-'0' <=9) sum2 += ch2-'0';
                    }
                    r = Integer.compare(sum1, sum2);

                    if(sum1 == sum2) {
                        // 사전순
                        r = o1.compareTo(o2);
                    }
                }
                return r;
            }
        });

        for(int i=0; i<N; i++) sb.append(nums[i]).append("\n");
        System.out.println(sb);
        br.close();
    }
}