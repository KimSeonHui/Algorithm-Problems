import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            String str1 = st.nextToken();
            String str2 = st.nextToken();

            if(str1.length() != str2.length()) {
                sb.append("Impossible" + "\n");
                continue;
            }

            List<Character> list = new ArrayList<>();
            for(int s=0; s< str1.length(); s++) {
                list.add(str1.charAt(s));
            }

            for(int s=0; s<str2.length(); s++) {
                char ch = str2.charAt(s);
                if(list.contains(ch)) list.remove((Object) ch);
            }

            if(list.isEmpty())  sb.append("Possible" + "\n");
            else  sb.append("Impossible" + "\n");
        }
        System.out.println(sb);
        br.close();
    }
}