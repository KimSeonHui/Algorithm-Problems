import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] factorial = new int[N+1];
        factorial[1] = 1;
        for(int i=2; i<= N; i++) {
            factorial[i] = factorial[i-1] * i;
        }
        if(K != 0 && N != K) System.out.println(factorial[N] / (factorial[K] * factorial[N-K]));
        else System.out.println(1);
    }
}