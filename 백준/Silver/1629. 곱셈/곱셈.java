import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws  Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());

        System.out.println(sol(a, b, c));
    }

    public static long sol(long a, long b, long c) {
        if(b == 1) return a % c;
        long val = sol(a, b/2, c);
        val = val * val % c;
        if(b % 2 == 0) return val;
        return val * a % c;
    }
}